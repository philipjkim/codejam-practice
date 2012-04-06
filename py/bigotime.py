#!/usr/bin/env python

import sys
from math import *

def big_o_time(n):
    #c = pow(10, -8)
    c = 1
    # TODO represent numbers like 10^x
    print "O(logN) = %.2f" % (log(n, 2) * c)
    print "O(N) = %d" % (n * c)
    print "O(Nlog(N)) = %.2f" % ((n * log(n, 2)) * c)
    print "O(N^2) = %d" % (pow(n, 2) * c)
    print "O(N^3) = %d" % (pow(n, 3) * c)
    print "O(2^N) = %d" % (pow(2, n) * c)
    print "O(N!) = %d" % (factorial(n) * c)

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print "Usage: %s POSITIVE_INT" % sys.argv[0]
        sys.exit(-1)
    n = int(sys.argv[1])
    if n < 1:
        raise ValueError("Positive integer expected as input")

    big_o_time(n)
