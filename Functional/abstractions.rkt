#lang racket

(define (accumulate combiner nv term a next b)
    (if (> a b)
        nv
        (combiner a (accumulate combiner nv term (next a) next b))))

(define (filter pred list)
    (if (null? list)
        '()
        (if (not (pred (car list)))
            (filter pred (cdr list))
            (cons (car list) (filter pred (cdr list))))))

(define (foldl op nv list)
    (if (null? list)
        nv
        (foldl op (op (car list) nv) (cdr list))))

(define (foldr op nv list)
    (if (null? list)
        nv
        (op (car list) (foldr op nv (cdr list)))))

