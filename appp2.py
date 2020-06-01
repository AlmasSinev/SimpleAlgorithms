import math


def derivative_1(y1, y2):
    return 2*a*y1 + b * y2 + d


def derivative_2(y1, y2):
    return b * y1 + 2 * c * y2 + e


def solve(y1, y2):
    return a*y1**2 + b*y1*y2 + c*y2**2 + d*y1 + e*y2 + f


E = float(input('Введите эпсилон: '))
h = float(input('Введите шаг: '))
x1 = int(input('Введите 1 координату точки: '))
x2 = int(input('Введите 2 координату точки: '))


print('Введите уравнение вида ax1^2 + bx1x2 + cx2^2 + dx1 + ex2 + f: ')
a = float(input('Введите а:'))
b = float(input('Введите b:'))
c = float(input('Введите c:'))
d = float(input('Введите d:'))
e = float(input('Введите e:'))
f = float(input('Введите f:'))


mes = input('max/ min: ')
F0 = solve(x1, x2)
F1 = solve(x1, x2) + 5   # условно взял, чтобы прошел первый цикл

if mes == 'min':
    while math.fabs(F1 - F0) > E:
        der_1 = derivative_1(x1, x2)
        der_2 = derivative_2(x1, x2)
        if (der_1 == 0) and (der_2 == 0):
            exit()
        if math.fabs(der_1) < math.fabs(der_2):
            while F0 >= solve(x1, x2-h):
                F0 = round(solve(x1, x2-h), 4)
                x2 -= h
                print('F0 = ' + str(F0))
        else:
            while F1 >= solve(x1-h, x2):
                F1 = round(solve(x1 - h, x2), 4)
                x1 -= h
                print('F1 = ' + str(F1))
else:  # MAX
    while math.fabs(F1 - F0) > E:
        der_1 = derivative_1(x1, x2)
        der_2 = derivative_2(x1, x2)
        if (der_1 == 0) and (der_2 == 0):
            exit()
        if math.fabs(der_1) > math.fabs(der_2):
            while F0 <= solve(x1, x2 + h):
                F0 = solve(x1, x2 + h)
                x2 += h
                print('F0 = ' + str(F0))
        else:
            while F1 <= solve(x1 + h, x2):
                F1 = solve(x1 + h, x2)
                x1 += h
                print('F1 = ' + str(F1))

print('Ответ: [' + str(round(x1, 3)) + ', ' + str(round(x2, 3)) + ']')





