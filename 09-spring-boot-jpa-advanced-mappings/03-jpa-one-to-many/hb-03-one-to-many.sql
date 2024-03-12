DROP SCHEMA IF EXISTS `hb-03-one-to-many`;

CREATE SCHEMA `hb-03-one-to-many`;

USE `hb-03-one-to-many`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detail`;
CREATE TABLE `instructor_detail` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `youtube_channel` varchar(128) DEFAULT NULL,
    `hobby` varchar(45) DEFAULT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email`varchar(45) DEFAULT NULL,
    `instructor_detail_id` int(11) DEFAULT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`instructor_detail_id`) REFERENCES `instructor_detail`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(128) DEFAULT NULL,
    `instructor_id` int(11) DEFAULT NULL,
    PRIMARY KEY(`id`),
    UNIQUE KEY `TITLE_UINQUE` (`title`),  
    FOREIGN KEY(`instructor_id`) REFERENCES `instructor`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10;