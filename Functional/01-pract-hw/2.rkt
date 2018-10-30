#lang racket

(define (to-k-ary n k)
  (if (= 0 (quotient n k))
      (remainder n k)
      (+ (remainder n k) (* 10 (to-k-ary (quotient n k) k)))))

(define (from-k-ary n k)
  (define (helper i n)
    (if (= n 0)
      0
      (+ (* (remainder n 10) (expt k i)) (helper (+ i 1) (quotient n 10)))))
  (helper 0 n))
