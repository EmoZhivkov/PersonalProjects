#lang racket
(define (length l)
    (define (helper i l)
        (if (null? l)
            i
            (helper (+ i 1) (cdr l))))
    (helper 0 l))

(define (sum l)
    (if (null? l)
        0
        (+ (car l) (sum (cdr l)))))

(define (member? x l)
    (cond ((null? l) #f)
          ((= x (car l)) #t)
    (else (member? x (cdr l)))))

(define (last l)
    (define (helper i l)
        (if (null? l)
            i
            (helper (car l) (cdr l))))
    (helper (- 1) l))

(define (nth l n)
    (define (helper i l)
        (if (= i n)
            (car l)
            (helper (+ i 1) (cdr l))))
    (helper 0 l))

(define (scale l x)
    (if (null? l)
        '()
        (cons (* (car l) x) (scale (cdr l) x))))

(define (reverse l)
    (define (helper new old)
        (if (null? old)
            new
            (helper (cons (car old) new) (cdr old))))
    (helper '() l))

(reverse '(1 2 3 4))


