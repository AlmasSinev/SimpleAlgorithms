import math


def derivative_1(y1, y2):
    return 2*a*y1 + b * y2 + d


def derivative_1_1(y1, y2):  # Производная для коэффициента перед alpha
    return 2*a*y1 + b * y2


def derivative_2(y1, y2):
    return b * y1 + 2 * c * y2 + e


def derivative_2_2(y1, y2):  # Производная для коэффициента перед alpha
    return b * y1 + 2 * c * y2


def solve(y1, y2):
    return a*y1**2 + b*y1*y2 + c*y2**2 + d*y1 + e*y2 + f


E = float(input('Введите эпсилон: '))
x1 = int(input('Введите 1 координату точки: '))
x2 = int(input('Введите 2 координату точки: '))

print('Введите уравнение вида ax1^2 + bx1x2 + cx2^2 + dx1 + ex2 + f: ')
a = float(input('Введите а:'))
b = float(input('Введите b:'))
c = float(input('Введите c:'))
d = float(input('Введите d:'))
e = float(input('Введите e:'))
f = float(input('Введите f:'))

mes = 'max'  # input('max/ min: ')
F = [solve(x1, x2), solve(x1, x2) + 1]

i = 1
if mes == 'max':
    while math.fabs(F[1] - F[0]) > E:
        new_point = [derivative_1(x1, x2), derivative_2(x1, x2)]
        q = derivative_1(x1, x2) ** 2 + derivative_2(x1, x2) ** 2
        q1 = derivative_1(x1, x2) * derivative_1_1(new_point[0], new_point[1]) + derivative_2(x1, x2) * derivative_2_2(
            new_point[0], new_point[1])
        alpha = q/-q1
        x1 = x1 + new_point[0]*alpha
        x2 = x2 + new_point[1]*alpha
        F[1] = F[0]
        F[0] = solve(x1, x2)
        print()
        print(str(i) + '.')
        i += 1
        print('Шаг (альфа): {}'.format(round(alpha, 3)))
        print('Кординаты точки: ({0}, {1}) '.format(round(x1, 3), round(x2, 3)))
        print('Значение: {}'.format(round(F[0], 4)))
        print()



