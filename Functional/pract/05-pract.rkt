#lang racket

(define (my-foldr f v xs)
    (if (null? xs)
        v
        (f (car xs) (my-foldr f v (cdr xs)))))

(define (sum xs)
    (foldr + 0 xs))

(define (minus-from n xs)
    (if (null? xs)
        n
        (minus-from (- n (car xs)) (cdr xs))))

(define (devide-from n xs)
    (if (null? xs)
        n
        (minus-from (/ n (car xs)) (cdr xs))))

(define (my-reverse xs)
    (define (helper new old)
        (if (null? old)
            new
            (helper (cons (car old) new) (cdr old))))
    (helper '() xs))

(define (foldl f nv xs)
    (if (null? xs)
        nv
        (foldl f (f nv (car xs)) (cdr xs))))

(define (flip f)
    (lambda (x y) (f y x)))

(define (reverse-foldl xs)
    (foldl (flip cons) '() xs))


;zip '(1 2) '(5 6) -> ('(1 5) . '(2 6))

(define (zip xs ys)
    (if (null? xs)
        '()
        ((flip cons) (zip (cdr xs) (cdr ys)) (cons (car xs) (car ys)))))

(define (zip-with-func f xs ys)
    (if (null? xs)
        '()
        ((flip cons) (zip-with-func f (cdr xs) (cdr ys)) (f (car xs) (car ys)))))

(define (append xs ys)
    (if (null? xs)
        ys
        (cons (car xs) (append (cdr xs) ys))))

(define (concat xss)
    (define (helper acc xss)
        (if (null? xss)
            acc
            (helper (append acc (car xss)) (cdr xss))))
    (helper '() xss))



(define (make-all-pairs n xs)
    (map (lambda (x) (cons n x)) xs))

(define (cartesian xs ys)
    (define (helper acc xs)
        (if (null? xs)
            acc
            (helper (append acc (make-all-pairs (car xs) ys))(cdr xs))))
    (helper '() xs))

(cartesian '(1 2) '(3 4))

;(define (concat ))




