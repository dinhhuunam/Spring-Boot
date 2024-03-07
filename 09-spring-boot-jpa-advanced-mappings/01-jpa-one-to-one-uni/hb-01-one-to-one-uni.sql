DROP SCHEMA IF EXISTS `hb-01-one-to-one-uni`;

CREATE SCHEMA `hb-01-one-to-one-uni`;

USE `hb-01-one-to-one-uni`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detail`;

CREATE TABLE `instructor_detail` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `youtube_channel` varchar(128) DEFAULT NULL,
    `hobby` varchar(45) DEFAULT NULL,
    PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
	`instructor_detail_id` int(11) DEFAULT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`instructor_detail_id`) REFERENCES `instructor_detail`(`id`)
);
SET FOREIGN_KEY_CHECKS=1;