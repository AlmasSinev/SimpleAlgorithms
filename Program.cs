using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pi
{
    class Program
    {
        public static double a, b, c, d, e, f, epsilon, x01, x02, counter, x11, x12, x1max, x2max, iter;
        public static bool isMax;
        public static double y1, y2, reqire, random1, random2, ext, h;

        static void Main(string[] args)
        {
            isMax = false;
            counter = 0;
            h = 1;
            iter = 0;

            Random rnd = new Random();

            Console.WriteLine("Введите a, b, c, d, e, f: ");
            a = Convert.ToDouble(Console.ReadLine());
            b = Convert.ToDouble(Console.ReadLine());
            c = Convert.ToDouble(Console.ReadLine());
            d = Convert.ToDouble(Console.ReadLine());
            e = Convert.ToDouble(Console.ReadLine());
            f = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("\nВведите эпсилон: ");
            epsilon = Convert.ToDouble(Console.ReadLine());
            
            Console.WriteLine("\nВведите координаты начальной точки (xo1, xo2): ");
            x01 = Convert.ToDouble(Console.ReadLine());
            x02 = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("\nВведите 0 для минимума, 1 для максимума: ");
            reqire = Convert.ToDouble(Console.ReadLine());

            if (reqire == 0)
            {
                isMax = false;
            }
            else
            {
                isMax = true;
            }

            y1 = Function(a, b, c, d, e, f, x01, x02);
            ext = y1;

            do
            { 
                if (isMax == true)
                {
                    y1 = ext;

                    for (int i = 0; i < 100; i++)
                    {   
                        random1 = rnd.NextDouble() * 2 - 1;
                        random2 = rnd.NextDouble() * 2 - 1;

                        x11 = x01 + h * AlphaGen1();
                        x12 = x02 + h * AlphaGen2();

                        y2 = Function(a, b, c, d, e, f, x11, x12);

                        if (y2 > ext)
                        {
                            ext = y2;
                            x1max = x11;
                            x2max = x12;                                
                        }

                        else
                        {
                            counter++;
                        }
                    }

                    if (counter == 100)
                    {
                        h = h / 2;
                    }

                    y2 = ext;
 
                    x01 = x1max;
                    x02 = x2max;

                    counter = 0;
                }

                if (isMax == false)
                {
                    y1 = ext;

                    for (int i = 0; i < 100; i++)
                    {
                        random1 = rnd.NextDouble() * 2 - 1;
                        random2 = rnd.NextDouble() * 2 - 1;

                        x11 = x01 + h * AlphaGen1();
                        x12 = x02 + h * AlphaGen2();

                        y2 = Function(a, b, c, d, e, f, x11, x12);

                        if (y2 < ext)
                        {
                            ext = y2;
                            x1max = x11;
                            x2max = x12;
                        }

                        else
                        {
                            counter++;
                        }
                    }

                    if (counter == 100)
                    {
                        h = h / 2;
                    }

                    y2 = ext;

                    x01 = x1max;
                    x02 = x2max;

                    counter = 0;
                }

                iter++;
            }

            while (Math.Abs(y2 - y1) >= epsilon);

            Console.WriteLine("\nОптимум равен: " + Math.Round(y2, 3));
            Console.WriteLine("\nКоординаты оптимума равены: " + Math.Round(x1max, 3) + "      " + Math.Round(x2max, 3));
            Console.WriteLine("\nКол-во итераций: " + iter);
            Console.ReadKey();
        }

        public static double AlphaGen1()
        {
            return random1 / Math.Sqrt(random1 * random1 + random2 * random2);
        }

        public static double AlphaGen2()
        {
            return random2 / Math.Sqrt(random1 * random1 + random2 * random2);
        }

        public static double Function(double a, double b, double c, double d, double e, double f, double x1, double x2)
        {
            return a * x1 * x1 + b * x1 * x2 + c * x2 * x2 + d * x1 + e * x2 + f;
        }
    }
}
