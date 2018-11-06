#lang racket

(define (getNumDigits x)
    (define (helper i x)
        (if (= x 0)
            i
            (helper (+ i 1) (/ (- x (remainder x 10)) 10))))
    (helper 0 x))

(define (helper i x n)
            (if (= i (quotient (getNumDigits x) 2))
                (remainder n 10)
                (helper (+ i 1) x (/ (- n (remainder n 10)) 10))))

(define (middle-digit x)
    (if (even? (getNumDigits x))
        (- 1)
        (helper 0 x x)))

;//////////////////////

(define (reverse l)
    (foldl cons '() l))

(define (every? p l)
    (foldl (lambda (x acc) (and (p x) acc)) #t l))

(define (endomorphism? l op f)
    (and (every? (lambda (x) (member (f x) l)))
         (every?  (lambda (x) (every? (lambda (y) (= (op (f x) (f y)) (f (op x y)))) l)) l)))

;//////////////////////
(define (exists? predicate a b)
    (and (<= a b)
        (or (predicate a) (exists? predicate (+ a 1) b))))
        
(define (meet-twice? f g a b)
    (exists? (lambda (x)
        (exists? (lambda (y)
            (and (not (=  x y))
                 (= (f x) (g x))
                 (= (f y) (g y)))
            a b))) a b))




