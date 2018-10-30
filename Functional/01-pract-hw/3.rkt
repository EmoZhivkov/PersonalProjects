#lang racket

(define (my-sqrt x)
    (define (helper i)
        (if (< (abs (- (* i i) x)) 0.000001)
            i
            (helper (- i (/ (- (* i i) x) (* i 2))))))
    (helper 0.001))