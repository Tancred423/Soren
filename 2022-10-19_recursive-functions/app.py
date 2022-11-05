num_list = []
fin = False

# get inputs

while (fin == False):
    print("Introduce los números que quieres tener en la lista. Cuando desees terminar, envía 'fin':")
    num_added = input()

    if (num_added == 'fin'):
        fin = True
    else:
        num_list.append(int(num_added))

num_added = len(num_list)


def encuentra_mayor(i, counter, big_number):
    num = num_list[counter]

    if (num > big_number):
        big_number = num

    if (counter + 1 < i):
        counter += 1
        return encuentra_mayor(i, counter, big_number)
    else:
        return big_number


big_num = encuentra_mayor(num_added, 0, 0)
print(big_num)
