#lang racket
(require rackunit rackunit/text-ui)

; factoriel of n + tests
(define (factorial-iter n)
    (define (for counter max sum)
        (if (> counter max) sum
            (for (+ counter 1) max (* sum counter))))
    (for 1 n 1))

(define factorial-iter-tests
  (test-suite
   "Tests for factorial-iter"

   (check = (factorial-iter 0) 1)
   (check = (factorial-iter 1) 1)
   (check = (factorial-iter 2) 2)
   (check = (factorial-iter 3) 6)
   (check = (factorial-iter 4) 24)
   (check = (factorial-iter 5) 120)
   (check = (factorial-iter 6) 720)
   (check = (factorial-iter 7) 5040)))

;(run-tests factorial-iter-tests)

; sum of the numbers from start to end + tests
(define (sum-iter start end)
    (define (for counter end sum)
        (if (> counter end) sum
                (for (+ counter 1) end (+ sum counter))))
    (for start end 0))

(define sum-iter-tests
  (test-suite
   "Tests for sum-iter"

   (check = (sum-iter 1 1) 1)
   (check = (sum-iter 1 2) 3)
   (check = (sum-iter 1 3) 6)
   (check = (sum-iter 0 4) 10)
   (check = (sum-iter -4 2) -7)))

;(run-tests sum-iter-tests)

; ...........

(define (expt-iter x n)
    (define (for counter end final)
        (cond ((= counter end) final)
           (else (for (+ counter 1) end (* final x)))))

    (cond ((= n 0) 1)
            ((< n 0)  (/ 1 (for 1 (- n) x)))
            (else (for 1 n x))))

(define expt-iter-tests
  (test-suite
   "Tests for expt-iter"

   (check = (expt-iter -2 -11) -1/2048)
   (check = (expt-iter -2 -10) 1/1024)
   (check = (expt-iter 2 -10) 1/1024)
   (check = (expt-iter 5 -3) 1/125)
   (check = (expt-iter 3 -2) 1/9)
   (check = (expt-iter 2 -2) 1/4)
   (check = (expt-iter 2 -1) 1/2)
   (check = (expt-iter 2 0) 1)
   (check = (expt-iter 2 1) 2)
   (check = (expt-iter 2 2) 4)
   (check = (expt-iter 3 2) 9)
   (check = (expt-iter 5 3) 125)
   (check = (expt-iter 2 10) 1024)
   (check = (expt-iter -2 10) 1024)
   (check = (expt-iter -2 11) -2048)))

(run-tests expt-iter-tests)

