#lang racket

; = работи само с числа, не може със стрингове и тн.
; eq? буквално проверява дали са един и същи обект
; eqv? работи по същия начин, но за числа е по стойност, за стрингове примерно е другото
; equal? проверява ги по стойност

; 1). '() списък, празен списък
; 2). а - стойност
;     б - списък  => (cons a b) е списък

;(cons 1(cons 2(cons 3(cons 4 '()))))

;'(1 2 3 4)

;(null? '())

;(car (cons 1 2))

;(cdr '(1 2 3 4))

(define (my-length xs)
    (define (helper i list)
        (if (null? list)
        i
        (helper (+ i 1) (cdr list))))
    (helper 0 xs))


(define (sum xs)
    (if (null? xs)
    0
    (+ (car xs) (sum (cdr xs)))))

(define (prod xs)
    (if (null? xs)
        1
        (* (car xs) (prod (cdr xs)))))

(define (index n xs)
    (if (equal? n (car xs))
        0
        (+ 1 (index n (cdr xs)))))

(define (fromTo a b)
    (if (= a b)
        (cons b '())
        (cons a (fromTo (+ a 1) b))))

(define (sum-interval a b)
    (sum (fromTo a b)))

(define (fact n)
    (prod (fromTo 1 n)))

(define (mine-append xs ys)
    (if (null? xs)
        ys
        (cons (car xs) (mine-append (cdr xs) ys))))

; абстракция на сум и прод
(define (fold f base xs)
    (if (null? xs )
        base
        (f (car xs) (fold f base (cdr xs)))))

; mine-append with fold
(define (my-append xs ys)
    (fold cons ys xs))

(define (my-map f xs)
    (if (null? xs)
        '()
        (cons (f (car xs)) (my-map f (cdr xs)))))

; my-map with fold
(define (my-map f xs)
    (fold (lambda (a b) (cons (f a ) b)) '() xs))





