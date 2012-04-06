#!/usr/bin/env python

import sys

def fibonacci(i):
    if i == 0:
        return 0
    elif i == 1:
        return 1
    else:
        return fibonacci(i-2) + fibonacci(i-1)

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print "Usage: %s POSITIVE_INT" % sys.argv[0]
        sys.exit(-1)
    i = int(sys.argv[1])
    if i < 0:
        raise ValueError("Input should not be negative")

    for j in range(0, i):
        print "F%d = %d" % (j, fibonacci(j))
