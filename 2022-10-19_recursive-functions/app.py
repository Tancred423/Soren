numList = []
fin = False

# get inputs

while (fin == False):
    print("Introduce los números que quieres tener en la lista. Cuando desees terminar, envía 'fin':")
    numAdded = input()

    if (numAdded == 'fin'):
        fin = True
    else:
        numList.append(int(numAdded))

numAdded = len(numList)


def encuentraMayor(i, counter, bigNumber):
    num = numList[counter]

    if (num > bigNumber):
        bigNumber = num

    if (counter + 1 < i):
        counter += 1
        return encuentraMayor(i, counter, bigNumber)
    else:
        return bigNumber


bigNum = encuentraMayor(numAdded, 0, 0)
print(bigNum)
