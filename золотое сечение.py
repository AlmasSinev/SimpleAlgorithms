import math

tau = 0.618


def primer(value):
    return a * value ** 2 + b * value + c


print('Введите координату 1 и 2 точки')
la = float(input('Введите координату 1 точки: '))
lb = float(input('Введите координату 2 точки: '))
print('Введите коэф-ты при ax^2, bx^1, cx^0')

a = float(input('a: '))
b = float(input('b: '))
c = float(input('c: '))
n = 1
length = lb-la

E = float(input('Введите эпсилон: '))
while math.fabs(lb - la) > E:
{
    if a > 0:{
        L = round(math.exp(n * math.log(tau)) * length, 3)
        la2 = round(la + L, 3)
        lb2 = round(lb - L, 3)
        if primer(la2) > primer(lb2):{
            lb = la2
            solve = lb2
}
        else:{
            la = lb2
            solve = la2}
        n = n + 1
}

    else:{
        L = round(math.exp(n * math.log(tau)) * length, 3)
        la2 = round(la + L, 3)
        lb2 = round(lb - L, 3)
        if primer(la2) < primer(lb2):{
            lb = la2
            solve = lb2}
        else:{
            la = lb2
            solve = la2}
        n = n + 1
}
}

print()
print('Точка [{0}, {1}]'.format(la, lb))
print('Значение: {}'. format(solve))
