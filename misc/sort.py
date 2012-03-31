#!/usr/bin/env python

import sys
from random import *

SIZE = 100

def sort(l):
    print "## Unknown sort"
    numbers = l[:]
    print "Unsorted: ", numbers

    for i in range(len(numbers)):
        for j in range(i, len(numbers)):
            if numbers[i] > numbers[j]:
                t = numbers[i]
                numbers[i] = numbers[j]
                numbers[j] = t
                #print "Swapped: ", numbers

    print "Sorted: ", numbers

def bubblesort(l):
    print "## Bubble sort"
    numbers = l[:]
    print "Unsorted: ", numbers

    swapped = True
    while (swapped):
        swapped = False
        for i in range(len(numbers)-1):
            if numbers[i] > numbers[i+1]:
                t = numbers[i]
                numbers[i] = numbers[i+1]
                numbers[i+1] = t
                swapped = True
                #print "Swapped: ", numbers
    print "Sorted: ", numbers

if __name__ == "__main__":
    l = range(SIZE)
    shuffle(l)
    from timeit import Timer
    t1 = Timer("sort(l)", "from __main__ import sort, l")
    t2 = Timer("bubblesort(l)", "from __main__ import bubblesort, l")
    print t1.timeit(1)
    print t2.timeit(1)
