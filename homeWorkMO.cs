using System;
using System.Linq;

namespace methodRandomWaysSpace
{
    class methodRandomWays
    {
        static Random random = new Random();

        public static double Function(double x1, double x2, double a, double b, double c, double d, double e, double f) => a * x1 * x1 + b * x1 * x2 + c * x2 * x2 + d * x1 + e * x2 + f;

        public static void methodRW()
        {
            double x1, x2;
            
            //Ввод
            Console.Write("Введите a: ");
            double a1 = double.Parse(Console.ReadLine());
            Console.Write("Введите b: ");
            double b1 = double.Parse(Console.ReadLine());
            Console.Write("Введите с: ");
            double c1 = double.Parse(Console.ReadLine());
            Console.Write("Введите d: ");
            double d1 = double.Parse(Console.ReadLine());
            Console.Write("Введите e: ");
            double e1 = double.Parse(Console.ReadLine());
            Console.Write("Введите f: ");
            double f1 = double.Parse(Console.ReadLine());
            Console.Write("Введите точность, через запятую: ");
            double _accuracy = double.Parse(Console.ReadLine());     
            Console.Write("x1 = ");
            x1 = Convert.ToDouble(Console.ReadLine());
            Console.Write("x2 = ");
            x2 = Convert.ToDouble(Console.ReadLine());

            //Инициализация наборов значений
            double newX1, newX2, alpha1, alpha2, index, bufferIndex1, bufferIndex2, count = 0, h = 1, accuracy = 1000;
            double[] mas_x1 = new double[6];
            double[] mas_x2 = new double[6];
            double[] mas_x1_Buffer = new double[6];
            double[] mas_x2_Buffer = new double[6];
            double[] mas_F = new double[6];
            double[] mas_F_Buffer = new double[6];

            Console.WriteLine();


            for (int i = 0; i < mas_F.Length; i++)
            {
                mas_F[i] = Math.Sign(a1) * 1000;
                mas_x1[i] = Math.Sign(a1) * 1000;
                mas_x2[i] = Math.Sign(a1) * 1000;
            }

            //Решение
            while (accuracy > _accuracy)
            {
                for (int i = 0; i < mas_x1.Length; i++)
                {
                    newX1 = 2 * random.NextDouble() - 1;
                    newX2 = 2 * random.NextDouble() - 1;
                    alpha1 = newX1 / Math.Sqrt(newX1 * newX1 + newX2 * newX2);
                    alpha2 = newX2 / Math.Sqrt(newX1 * newX1 + newX2 * newX2);
                    mas_x1_Buffer[i] = mas_x1[i];
                    mas_x1[i] = x1 + h * alpha1;
                    mas_x2_Buffer[i] = mas_x2[i];
                    mas_x2[i] = x2 + h * alpha2;
                    mas_F_Buffer[i] = mas_F[i];
                    mas_F[i] = Function(mas_x1[i], mas_x2[i], a1, b1, c1, d1, e1, f1);
                }

                if (a1 > 0) 
                {
                    if (mas_F.Min() > mas_F_Buffer.Min())
                    {
                        h /= 2;
                        index = Array.IndexOf(mas_F_Buffer, mas_F_Buffer.Min());
                        x1 = mas_x1_Buffer[(int)index];
                        x2 = mas_x2_Buffer[(int)index];
                    }
                    else
                    {
                        index = Array.IndexOf(mas_F, mas_F.Min());
                        x1 = mas_x1[(int)index];
                        x2 = mas_x2[(int)index];
                    }
                }
                else
                {
                    if (mas_F.Max() < mas_F_Buffer.Max())
                    {
                        h /= 2;
                        index = Array.IndexOf(mas_F_Buffer, mas_F_Buffer.Max());
                        x1 = mas_x1_Buffer[(int)index];
                        x2 = mas_x2_Buffer[(int)index];
                    }
                    else
                    {
                        index = Array.IndexOf(mas_F, mas_F.Max());
                        x1 = mas_x1[(int)index];
                        x2 = mas_x2[(int)index];
                    }
                }

                if (a1 > 0)
                {
                    bufferIndex1 = Array.IndexOf(mas_F, mas_F.Min());
                    bufferIndex2 = Array.IndexOf(mas_F_Buffer, mas_F_Buffer.Min());
                }
                else
                {
                    bufferIndex1 = Array.IndexOf(mas_F, mas_F.Max());
                    bufferIndex2 = Array.IndexOf(mas_F_Buffer, mas_F_Buffer.Max());
                }
                
                Console.WriteLine($"Точка {count+1}:      [{Math.Round(x1, 3)} ; {Math.Round(x2, 3)}]");
                accuracy = 5 * Math.Abs(Function(mas_x1[(int)bufferIndex1], mas_x2[(int)bufferIndex1], a1, b1, c1, d1, e1, f1) - Function(mas_x1_Buffer[(int)bufferIndex2], mas_x2_Buffer[(int)bufferIndex2], a1, b1, c1, d1, e1, f1));
                count++;
            }

            //Итог
            Console.WriteLine();
            Console.WriteLine($"Количество итераций: {count}");
            if (a1 > 0)
            {
                Console.WriteLine($"Минимум функции: {-Math.Round(Function(x1, x2, a1, b1, c1, d1, e1, f1), 3)}");
            }
            else
                Console.WriteLine($"Максимум функции: {Math.Round(Function(x1, x2, a1, b1, c1, d1, e1, f1), 3)}");
            Console.WriteLine($"Точка x1: {Math.Round(x1, 3)}");
            Console.WriteLine($"Точка x2: {Math.Round(x2, 3)}");
            
            
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            methodRandomWays.methodRW();
            Console.ReadLine();
        }
    }
}