CREATE TABLE `user` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`is_admin` BOOLEAN NOT NULL,
	`username` varchar(255) NOT NULL UNIQUE,
	`password` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE `comment` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`message` varchar(255) NOT NULL,
	`post_date` DATETIME NOT NULL,
	`creator_id` BIGINT NOT NULL,
	`anime_id` BIGINT,
	`episode_id` BIGINT,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE `anime` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`title` varchar(255) NOT NULL,
	`genre` varchar(255),
	`synopsis` TEXT,
	`aired` DATE,
	`ended` DATE,
	`rating` FLOAT,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE `episode` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`anime_id` BIGINT NOT NULL,
	`saison` INT(64) NOT NULL,
	`episode_nb` INT(64) NOT NULL,
	`air_date` DATE,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB;

ALTER TABLE `comment` ADD CONSTRAINT `comment_fk0` FOREIGN KEY (`creator_id`) REFERENCES `user`(`id`);

ALTER TABLE `comment` ADD CONSTRAINT `comment_fk1` FOREIGN KEY (`anime_id`) REFERENCES `anime`(`id`);

ALTER TABLE `comment` ADD CONSTRAINT `comment_fk2` FOREIGN KEY (`episode_id`) REFERENCES `episode`(`id`);

ALTER TABLE `episode` ADD CONSTRAINT `episode_fk0` FOREIGN KEY (`anime_id`) REFERENCES `anime`(`id`);
