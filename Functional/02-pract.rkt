#lang racket

(define (divides p q)
    (= (remainder q p) 0))

(define (prime? x)
    (define (helper i)
        (cond ((= i 1) #t)
              ((divides i x) #f)
              (else (helper (- i 1)))))
    (helper (- x 1)))

; need a new stack frame in every stack
(define (sum-interval a b)
    (if (= a b)
        b
        (+ b (sum-interval a (- b 1)))))

; better because it doesn't need a new stack frame when iterating
(define (sum-interval-iter a b)
    (define (help i acc)
        (if (= i b)
            (+ i acc)
            (help (+ i 1) (+ acc i))))
    (help a 0))

; iterative fibonacci - far better because it doesn't need a new stack frame
(define (fib-iter x)
    (define (help prev curr i)
        (cond  ((= i x) curr)
               ((= x 1) 1)
               ((= x 2) 1)
               (else (help curr (+ prev curr) (+ i 1)))))
        (help 1 1 2))









