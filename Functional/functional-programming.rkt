#lang racket
(define (succ x) (+ x 1))
(define (pred x) (- x 1))
  
(define (my-plus x y)
  (if (> y 0) (my-plus (succ x) (pred y)) x))


(define (my-mult x y)
  (
   if(= x 1) y
     (+
       y
       (my-mult (- x 1) y)
      )
     )
)

(define (factorial x)
  (
   if(= x 0) 1
    (my-mult
       x
       (factorial (- x 1))
    )
  )
)

(define (divides? x y)
  (= 0 (remainder y x)))

(define (is-prime? x y)
  (define (help-me i current)
    (and (divides i x)) (help-me (+ i 1)
                                 )