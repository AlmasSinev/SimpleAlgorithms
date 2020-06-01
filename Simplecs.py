import math


def koord_1(x1_01, x2_01, xj_11):
    return (x1_01 + x2_01 + xj_11) - 2 * xj_11


def koord_2(x1_11, x2_11, xj_22):
    return (x1_11 + x2_11 + xj_22) - 2 * xj_22


def solve(x1, x2):
    return a*x1**2 + b*x1*x2 + c*x2**2 + d*x1 + e*x2 + f


E = 0.0001  # float(input('Введите эпсилон: '))
x1 = 1  # float(input('Введите 1 координату точки: '))
x2 = 1  # float(input('Введите 2 координату точки: '))
n = 2
# print('Введите уравнение вида ax1^2 + bx1x2 + cx2^2 + dx1 + ex2 + f: ')
a = 5  # float(input('Введите а:'))
b = 1  # float(input('Введите b:'))
c = 3  # float(input('Введите c:'))
d = 4  # float(input('Введите d:'))
e = -7  # float(input('Введите e:'))
f = 2  # float(input('Введите f:'))
h = 1  # float(input('Введите длину ребра: '))


x1_1 = x1 + h
x1_2 = x2
x2_1 = (x1_1 + x1) / 2
x2_2 = x1_2 + h * 0.866

F = [solve(x1, x2), solve(x1_1, x1_2), solve(x2_1, x2_2)]
print("F[0] = ({0}, {1})". format(x1, x2))
print("F[1] = ({0}, {1})". format(x1_1, x1_2))
print("F[2] = ({0}, {1})". format(x2_1, x2_2))
print("------------------")

print("F[0] = {}".format(F[0]))
print("F[1] = {}".format(F[1]))
print("F[2] = {}".format(F[2]))
print("------------------")

x_new1 = 0
x_new2 = 0
mas = [F[0], F[1], F[2]]

while (math.fabs(F[0] - F[1]) >= E) and (math.fabs(F[0] - F[2]) >= E) and (math.fabs(F[1] - F[2]) >= E):

    if F.index(max(F)) == 0:
        x_new1 = koord_1(x1_1, x2_1, x1)
        x_new2 = koord_2(x1_2, x2_2, x2)
        x1 = x_new1
        x2 = x_new2

    else:
        if F.index(max(F)) == 1:
            x_new1 = koord_1(x1, x2_1, x1_1)
            x_new2 = koord_2(x2, x2_2, x1_2)
            x1_1 = x_new1
            x1_2 = x_new2
        else:
            x_new1 = koord_1(x1, x1_1, x2_1)
            x_new2 = koord_2(x2, x1_2, x2_2)
            x2_1 = x_new1
            x2_2 = x_new2

    F[F.index(max(F))] = solve(x_new1, x_new2)
    print("*************************")
    print("F[0] = ({0}, {1})".format(x1, x2))
    print("F[1] = ({0}, {1})".format(x1_1, x1_2))
    print("F[2] = ({0}, {1})".format(x2_1, x2_2))

    print("--------------")
    print("F[0] = {}".format(F[0]))
    print("F[1] = {}".format(F[1]))
    print("F[2] = {}".format(F[2]))

    print("*************************")

    if F[F.index(max(F))] not in mas:
        mas.append(F[F.index(max(F))])
        print(mas[-1])

    else:
        break

print(max(F))



