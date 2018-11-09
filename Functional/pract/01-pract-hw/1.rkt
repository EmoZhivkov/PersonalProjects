#lang racket

(define (stopping-time n)
    (define (helper i n)
        (if (= n 1)
            i
            (if (even? n)
                (helper (+ i 1) (quotient n 2))
                (helper (+ i 1) (+ (* 3 n) 1)))))
    (if (= n 1)
        3
        (helper 0 n)))

