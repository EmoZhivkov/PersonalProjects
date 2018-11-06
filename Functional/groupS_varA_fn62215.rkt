#lang racket

;01 a).
(define (numOfDigits n)
    (if (= 0 n)
        0
        (+ 1 (numOfDigits (/ (- n (remainder n 10)) 10)))))

(define (reverseDigits i acc x)
        (if (= i 0)
            acc
            (reverseDigits (- i 1) (+ acc (* (expt 10 (- i 1)) (remainder x 10))) (/ (- x (remainder x 10)) 10))))

(define (diffReverse x)
    (- x (reverseDigits (numOfDigits x) 0 x)))

;01 b).
(define (getListOfDigits x)
    (if (= x 0)
        '()
        (cons (remainder x 10) (getListOfDigits (/ (- x (remainder x 10)) 10)) )))

(define (foldl op nv list)
    (if (null? list)
        nv
        (foldl op (op (car list) nv) (cdr list))))

(define (reverse list)
    (foldl cons '() list))

(define (biggestNumInList list)
    (define (helper current biggest i length list)
        (if (= i length)
            biggest
            (if (> current biggest)
                (helper (car list) current (+ i 1) length (cdr list))
                (helper (car list) biggest (+ i 1) length (cdr list)))))
    (helper (car list) 0 -1 (length list) list))


(define (sortListDescending list)
    (define (helper acc list)
        (if (null? list)
            acc
            (helper (cons (biggestNumInList list) acc) (remove (biggestNumInList list) list))))
    (reverse (helper '() list)))

(define (sortDigits x)
    (define (helper i list acc)
        (if (= i 0)
            acc
            (helper (- i 1) (cdr list) (* (car list) (expt 10 i)))))
    (helper (length (getListOfDigits x)) (getListOfDigits x) 0)

;////////////////////////////
;02
(define (switchFunctions f g x)
    (define (helper i x f g acc)
        (if (= i x)
            acc
            (if (even? i)
                (helper (+ i 1) x f g (f acc))
                (helper (+ i 1) x f g (g acc)))))
    (helper 1 x f g x))

(define (permutable? a b f g)
    (and #t
        (if (> a b)
            #t
            (if (even? a)
                (and (= (switchFunctions f g a) (switchFunctions g f a)) (permutable? (+ a 1) b f g))
                (or #t (permutable? (+ a 1) b f g))))))










