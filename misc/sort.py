#!/usr/bin/env python

import sys
from logging import *
from random import *

basicConfig(level=INFO)

SIZE = 100

def swap(arr, idx1, idx2):
    temp = arr[idx1]
    arr[idx1] = arr[idx2]
    arr[idx2] = temp

def sort(l):
    debug("## Unknown sort")
    arr = l[:]
    debug("Unsorted: %s" % arr)

    for i in range(len(arr)):
        for j in range(i+1, len(arr)):
            if arr[i] > arr[j]:
                swap(arr, i, j)
                debug("Swapped: %s" % arr)

    debug("Sorted: %s" % arr)

def bubblesort(l):
    debug("## Bubble sort")
    arr = l[:]
    debug("Unsorted: %s" % arr)

    swapped = True
    while (swapped):
        swapped = False
        for i in range(len(arr)-1):
            if arr[i] > arr[i+1]:
                swap(arr, i, i+1)
                swapped = True
                debug("Swapped: %s" % arr)
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

if __name__ == "__main__":
    l = range(SIZE)
    shuffle(l)
    from timeit import Timer
    t1 = Timer("sort(l)", "from __main__ import sort, l")
    t2 = Timer("bubblesort(l)", "from __main__ import bubblesort, l")
    t3 = Timer("selectionsort(l)", "from __main__ import selectionsort, l")
    print t1.timeit(1)
    print t2.timeit(1)
    print t3.timeit(1)
