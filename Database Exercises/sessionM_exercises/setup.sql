USE master
GO
if exists (select * from sysdatabases where name='ecommerce')
	DROP DATABASE ecommerce
GO

CREATE DATABASE ecommerce
GO
USE ecommerce
GO

CREATE TABLE `users` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`first_name` varchar(255) NOT NULL CHARACTER SET utf8 COLLATE
utf8_unicode_ci NOT NULL,
`last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci
NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8

CREATE TABLE `items` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`description` varchar(255) CHARACTER SET utf8 COLLATE
utf8_unicode_ci NOT NULL,
`cost_pennies` int(11) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 

CREATE TABLE `user_items` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(11) NOT NULL,
`item_id` int(11) NOT NULL,
`purchased_at` datetime NOT NULL,
PRIMARY KEY (`id`),
KEY `user_id` (`user_id`),
KEY `item_id` (`item_id`),
CONSTRAINT `user_items_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES
`items` (`id`),
CONSTRAINT `user_items_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES
`users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 