#lang racket

(define (id a) a)

(define (accumulate combiner base term a next b)
    (if (> a b)
        base
        (combiner (term a) (accumulate combiner base term (next a) next b))))

;(define (sum term a next b)
 ;   (accumulate + 0 term a next b))

(define (accumulate-iter combiner base term a next b)
        (if (> a b)
            base
            (accumulate-iter combiner (combiner (term a) base) term (next a) next b)))

(define (sum term a next b)
    (accumulate-iter + 0 term a next b))

(sum id 1 (lambda (x) (+ x 1)) 5)

(define (count predicate a b)
    (accumulate
        (lambda (x acc)
        (if (predicate x)
            (+ acc 1)
            acc))
            0
            (lambda (x) x)
            a
            (lambda (x) (+ x 1))
            b))

(count odd? 1 6)






