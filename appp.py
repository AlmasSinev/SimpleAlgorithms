from tkinter import *


def main(q, q1, q2, e, a, b, c):

    def fibonacci(num):
        if num in (1, 2):
            return 1
        return fibonacci(num - 1) + fibonacci(num - 2)

    def equalization(x):
        return round(a * x ** 2 + b * x + c, 4)

    def L(num):
        return fibonacci(num) / fibonacci(num + 1) * (q2 - q1) + (-1) ** q / fibonacci(num + 1) * e

    while q != 1:
        x1 = round(q1 + L(q), 4)
        x2 = round(q2 - L(q), 4)
        q = q - 1
        if a > 0:
            if equalization(x1) >= equalization(x2):
                q2 = x1
                mm = equalization(x2)

            else:
                q1 = x2
                mm = equalization(x1)

        else:
            if equalization(x1) <= equalization(x2):
                q2 = x1
                mm = equalization(x2)
            else:
                q1 = x2
                mm = equalization(x1)

    output.insert("0.0", ' ')
    output.insert("0.0", 'Ответ: [' + str(q1) + ' ' + str(q2) + ']')
    output.insert("0.0", ' \n')
    output.insert("0.0", ' Точка: ' + str(mm))


def handler():
    n = float(N.get())
    size_11 = float(size_1.get())
    size_22 = float(size_2.get())
    e = float(E.get())
    a_11 = float(a.get())
    b_11 = float(b.get())
    c_11 = float(c.get())
    main(n, size_11, size_22, e, a_11, b_11, c_11)



root = Tk()
root.title("Метод Фибоначчи")
root.minsize(300, 150)
root.resizable(width=False, height=False)

# создаем рабочую область
frame = Frame(root)
frame.grid()

n_lab = Label(frame, text="Введите n:").grid(row=1, column=1)
N = Entry(frame, width=3)
N.grid(row=1, column=2,  padx=2)

e_lab = Label(frame, text="Введите E:").grid(row=2, column=1)
E = Entry(frame, width=3)
E.grid(row=2, column=2)

size_lab_1 = Label(frame, text="Введите промежуток [").grid(row=3, column=1)

size_1 = Entry(frame, width=2)
size_1.grid(row=3, column=2)
size_lab_2 = Label(frame, text=", ").grid(row=3, column=3, padx=0.3, pady=1)
size_2 = Entry(frame, width=2)
size_2.grid(row=3, column=4)
size_lab_3 = Label(frame, text="]").grid(row=3, column=5)


a = Entry(frame, width=3)
a.grid(row=4, column=2, padx=(10, 0))

a_l = Label(frame, text="Введите уравнение").grid(row=4, column=1)
a_lab = Label(frame, text="x^2 ").grid(row=4, column=3)

b = Entry(frame, width=3)
b.grid(row=4, column=4)
b_lab = Label(frame, text="x ").grid(row=4, column=5)

c = Entry(frame, width=4)
c.grid(row=4, column=6)

but = Button(frame, text="Решить", command=handler).grid(row=1, column=7, padx=(10, 0))
exit_button = Button(frame, text="Выход", width=6, command=root.destroy).grid(row=2, column=7, padx=(10, 0))

output = Text(frame, bg="lightblue", font="Arial 11", width=40, height=3)
output.grid(row=5, columnspan=8)

root.mainloop()
