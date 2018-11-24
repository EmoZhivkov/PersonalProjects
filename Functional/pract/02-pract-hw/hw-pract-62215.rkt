#lang racket

;1)
(define (all? p? xs)
    (foldl (lambda (x nv) (and nv (p? x))) #t xs))

;2)
(define (any? p? xs)
    (if (null? xs)
        #f
        (foldl (lambda (x nv) (or nv (p? x))) #f xs)))

;3)
(define (concat xss)
    (foldr (lambda (xs nv) (foldr (lambda (x nvv)
        (cons x nvv)) nv xs)) '() xss))

;4)
(define (rows xss) xss)

;5)
(define (cols xss)
    (if (null? (concat xss))
        '()
        (cons (foldr (lambda (xs nv) (cons (car xs) nv))
                    '()
                    xss)
            (cols (map cdr xss)))))

;6)
(define (matrix-ref xss i j)
    (list-ref (list-ref xss i) j))

;7.1)
(define (add-before xs i)
  (if (= 0 i)
      '()
      (cons (car xs) (add-before (cdr xs) (- i 1)))))

;7.2)
(define (drop-before xs i)
  (if (= i -1)
      xs
      (drop-before (cdr xs) (- i 1))))

;7.3)
(define (set xs i x)
  (append (add-before xs i)
          (cons x (drop-before xs i))))

;8)
(define (place xss i j x)
  (append (add-before xss i) (cons (set (list-ref xss i) j x) (drop-before xss i))))

;9)
(define (diag xss)
  (if (null? xss)
      '()
      (cons (car (car xss)) (diag (map cdr (cdr xss))))))

;10.1)
(define (reverse xs)
    (foldl cons '() xs))

(define (flip xss)
  (foldr (lambda (xs nv) (cons (reverse xs) nv)) '() xss))

;10.2)
(define (diags xss)
  (cons (diag xss) cons (diag (flip xss)) '())))

;11)
(define (map-matrix f xss)
  (foldr (lambda (xs nv) (cons (map f xs) nv)) '() xss))

;12)
(define (filter-matrix p? xss)
  (map (lambda (xs) (filter p? xs)) xss))

;13)
(define (zip-with f xs ys)
  (if (or (null? xs) (null? ys))
      '()
      (cons (f (car xs) (car ys)) (zip-with f (cdr xs) (cdr ys)))))

;14)
(define (zip-matrix xss yss)
  (if (or (null? xss) (null? yss))
      '()
      (cons (zip-with cons (car xss) (car yss))
            (zip-matrix (cdr xss) (cdr yss)))))





