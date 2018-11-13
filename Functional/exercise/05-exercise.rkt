#lang racket

((lambda args 1) 1 2 3)

(define (double x) (* 2 x))
(define (square x) (* x x))
(define (inc x) (+ x 1))



;;; (define (compose . fns)
;;;     (define (compose-two f g)
;;;         (lambda (x) (f (g x))))
;;;     (if (null? fns)
;;;         (lambda (x) x)
;;;         (compose-two (car fns) (apply compose (cdr fns)))))



(define (compose . fns)
    (define (compose-two f g)
        (lambda (x) (f (g x))))
    (foldr compose-two (lambda (x) x) fns))

(define f (compose double square inc))

(define (flip fn)
    (lambda args
        (apply fn (reverse args))))

(define list^ (flip list))

;;; (define (zip x y)
;;;     (if (or (null? x) (null? y))
;;;         '()
;;;         (cons (list (car x) (car y)) (zip (cdr x) (cdr y)))))

;;; (define (zip-with fn x y)
;;;     (if (or (null? x) (null? y))
;;;         '()
;;;         (cons (fn (car x) (car y)) (zip-with fn (cdr x) (cdr y)))))

(define (zip x y) (zip-with list x y))

;;;(zip '(1 2 3) '(1 2 3))

(define (zip-with fn . list)
    (if (or (null? list) (not (null? (filter null? list))))
        '()
        (cons (apply fn (map car list)) (apply zip-with fn (map cdr list)))))

(zip-with + '(1 2 3) '(4 5 6) '(7 8 9))
(zip-with +)
(zip-with + '(1 2 3))

(define (juxt . fns)
    (lambda args
        (if (null? fns)
            '()
            (cons (apply (car fns) args)
                  (apply (apply juxt (cdr fns)) args)))))

((juxt (lambda (x) x) (lambda (x) (* x x))) 2)













