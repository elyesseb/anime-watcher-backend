CREATE TABLE `user` (
                        `user_id` BIGINT NOT NULL AUTO_INCREMENT,
                        `is_admin` BOOLEAN NOT NULL,
                        `username` varchar(255) NOT NULL UNIQUE,
                        `password` varchar(255) NOT NULL,
                        `email` varchar(255) NOT NULL UNIQUE,
                        PRIMARY KEY (`user_id`)
)ENGINE=InnoDB;

CREATE TABLE `comment` (
                           `comment_id` BIGINT NOT NULL AUTO_INCREMENT,
                           `message` varchar(255) NOT NULL,
                           `post_date` DATETIME NOT NULL,
                           `creator_id` BIGINT NOT NULL,
                           PRIMARY KEY (`comment_id`)
)ENGINE=InnoDB;

CREATE TABLE `animes` (
                          `anime_id` BIGINT NOT NULL AUTO_INCREMENT,
                          `title` varchar(255) NOT NULL,
                          `genre` varchar(255) NOT NULL,
                          `img` LONGBLOB,
                          `synopsis` TEXT NOT NULL,
                          `aired` DATE,
                          `ended` DATE,
                          `rating` FLOAT,
                          PRIMARY KEY (`anime_id`)
)ENGINE=InnoDB;

CREATE TABLE `episodes` (
                            `episode_id` BIGINT NOT NULL AUTO_INCREMENT,
                            `anime_id` BIGINT NOT NULL,
                            `saison` INT(64) NOT NULL,
                            `episode_nb` INT(64),
                            `air_date` DATE,
                            PRIMARY KEY (`episode_id`)
)ENGINE=InnoDB;

ALTER TABLE `comment` ADD CONSTRAINT `comment_fk0` FOREIGN KEY (`creator_id`) REFERENCES `user`(`user_id`);

ALTER TABLE `episodes` ADD CONSTRAINT `episodes_fk0` FOREIGN KEY (`anime_id`) REFERENCES `animes`(`anime_id`);
