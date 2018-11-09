#lang racket

(define (succ n) (+ n 1))

(define (iterate n f x)
    (define (for counter answer)
        (if (>= counter n)
            answer
           (for (+ counter 1) (f answer))))
    (for 0 x))

(define (pow2 a) (* a a))

(define (oper-interval f base oper a b)
    (if (> a b)
        base
        (oper (f a) (oper-interval f base oper (succ a) b))))

(define (sum-after-square a b)
    (oper-interval pow2 0 + a b))

;;; (define (next-oper f x y)
;;;     (if (= x 1)
;;;         y
;;;         (f y (next-oper f (- x 1) y))))

(define (next-oper f) (lambda (x y)
    (if (= x 1)
        y
        (f y ((next-oper f) (- x 1) y)))))

(define (combo f g) (lambda (x)
    (f (g x))))

((combo (lambda (x) (+ x 1)) (lambda (x) (- x 1))) 1)




