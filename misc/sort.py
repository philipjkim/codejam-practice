#!/usr/bin/env python

import sys
import time
from random import *

SIZE = 10

def sort(l):
    print "## Unknown sort"
    numbers = l[:]
    print "Unsorted: ", numbers

    started = time.time()
    for i in range(len(numbers)):
        for j in range(i, len(numbers)):
            if numbers[i] > numbers[j]:
                t = numbers[i]
                numbers[i] = numbers[j]
                numbers[j] = t
                #print "Swapped: ", numbers

    elapsed = time.time() - started
    print "Sorted: ", numbers
    print "Elapsed: %.10f" % elapsed

def bubblesort(l):
    print "## Bubble sort"
    numbers = l[:]
    print "Unsorted: ", numbers

    started = time.time()
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
    elapsed = time.time() - started
    print "Sorted: ", numbers
    print "Elapsed: %.10f" % elapsed


if __name__ == "__main__":
    l = range(SIZE)
    shuffle(l)
    sort(l)
    bubblesort(l)
