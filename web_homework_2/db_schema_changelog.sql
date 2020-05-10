/*
    USERNAME: root
    PASSWORD: 123456
*/

DROP DATABASE `62215_Emil_Zhivkov`;

CREATE DATABASE IF NOT EXISTS `62215_Emil_Zhivkov` CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

USE `62215_Emil_Zhivkov`;

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(64) NOT NULL,
    second_name VARCHAR(64) NOT NULL,
    course_year INT NOT NULL CHECK (course_year >= 1),
    course_name VARCHAR(64) NOT NULL,
    fn INT NOT NULL CHECK (fn >= 1),
    group_number INT NOT NULL CHECK (group_number >= 1),
    birth_date DATE NOT NULL,
    zodiac_sign VARCHAR(20) NOT NULL CHECK (zodiac_sign in ("capricorn","aquarius","pisces","aries","taurus","gemini","cancer","leo","virgo","libra","scorpio","sagittarius")),
    link VARCHAR(255) NOT NULL,
    picture VARCHAR(512) NOT NULL,
    motivation VARCHAR(512) NOT NULL
);

INSERT INTO
    Users (
        first_name,
        second_name,
        course_year,
        course_name,
        fn,
        group_number,
        birth_date,
        zodiac_sign,
        link,
        picture,
        motivation
    )
VALUES
    (
        'Emil',
        'Zhivkov',
        2018,
        'Software Engineering',
        62215,
        3,
        '1998-07-31',
        'leo',
        'https://www.facebook.com/EmoZhivkov/',
        '../images/emo.png',
        'This is my motivation!'
    );
