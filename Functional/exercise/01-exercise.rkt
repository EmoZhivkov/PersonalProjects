#lang racket
(define pi 3.14)
(define a (+ 1 2))
(define (square x) (* x x))

;;; (define (abs x)
;;;     (cond ((< x 0) (- x))
;;;           ((= x 0) 0)
;;;           ((> x 0) x)))

(define (abs x)
    (cond ((< x 0) (- x))
        (else x)))


