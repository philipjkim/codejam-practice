#!/usr/bin/env python

import sys
from logging import *
from random import *

basicConfig(level=INFO)
#basicConfig(level=DEBUG)

SIZE = 200

def swap(arr, idx1, idx2):
    temp = arr[idx1]
    arr[idx1] = arr[idx2]
    arr[idx2] = temp

def bubblesort(l):
    debug("## Bubble sort")
    arr = l[:]
    debug("Unsorted: %s" % arr)

    n = len(arr)
    swapped = True
    while swapped:
        swapped = False
        for i in range(n-1):
            if arr[i] > arr[i+1]:
                swap(arr, i, i+1)
                swapped = True
                debug("Swapped: %s" % arr)
        n -= 1
    debug("Sorted: %s" % arr)

def selectionsort(l):
    debug("## Selection sort")
    arr = l[:]
    debug("Unsorted: %s" % arr)

    for i in range(len(arr)):
        minIdx = i
        for j in range(i+1, len(arr)):
           if arr[minIdx] > arr[j]:
               minIdx = j
        if i != minIdx:
            swap(arr, i, minIdx)
            debug("Swapped: %s" % arr)
    debug("Sorted: %s" % arr)

def insertionsort(l):
    debug("## Insert sort")
    arr = l[:]
    debug("Unsorted: %s" % arr)

    for i in range(1, len(arr)):
        t = arr[i]
        j = i-1
        while j >= 0 and arr[j] > t:
            arr[j+1] = arr[j]
            debug("Shifted: %s" % arr)
            j -= 1
        arr[j+1] = t
        if j+1 != i:
            debug("Inserted: %s" % arr)

    debug("Sorted: %s" % arr)

if __name__ == "__main__":
    l = range(SIZE)
    shuffle(l)
    from timeit import Timer
    t1 = Timer("bubblesort(l)", "from __main__ import bubblesort, l")
    t2 = Timer("selectionsort(l)", "from __main__ import selectionsort, l")
    t3 = Timer("insertionsort(l)", "from __main__ import insertionsort, l")
    print "Array size: ", SIZE
    print "bubble:    ", t1.timeit(1)
    print "selection: ", t2.timeit(1)
    print "insertion: ", t3.timeit(1)
