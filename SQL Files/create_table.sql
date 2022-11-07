CREATE DATABASE IF NOT EXISTS moviedb;

USE moviedb;

CREATE TABLE movies (
    id VARCHAR(10) DEFAULT '' NOT NULL PRIMARY KEY,
    title VARCHAR(100) DEFAULT '' NOT NULL,
    year INTEGER NOT NULL,
    director VARCHAR(100) DEFAULT '' NOT NULL
);

CREATE TABLE stars (
    id VARCHAR(10) DEFAULT '' NOT NULL PRIMARY KEY,
    name VARCHAR(100) DEFAULT '' NOT NULL,
    birth_year INTEGER
);

CREATE TABLE stars_in_movies(
    star_id VARCHAR(10) DEFAULT '' NOT NULL,
    movie_id VARCHAR(10) DEFAULT '' NOT NULL,
    FOREIGN KEY (star_id) REFERENCES stars(id),
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);

CREATE TABLE genres(
   id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(32) DEFAULT '' NOT NULL
);

CREATE TABLE genres_in_movies(
    genre_id INTEGER NOT NULL,
    movie_id VARCHAR(10) DEFAULT ''  NOT NULL,
    FOREIGN KEY (genre_id) REFERENCES genres(id),
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);

CREATE TABLE creditcards(
    id VARCHAR(20) DEFAULT '' NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) DEFAULT '' NOT NULL,
    last_name VARCHAR(50) DEFAULT '' NOT NULL,
    expiration DATE NOT NULL
);

CREATE TABLE customers(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) DEFAULT '' NOT NULL,
    last_name VARCHAR(50) DEFAULT '' NOT NULL,
    cc_id VARCHAR(20) DEFAULT '' NOT NULL,
    address VARCHAR(200) DEFAULT '' NOT NULL,
    email VARCHAR(50) DEFAULT '' NOT NULL,
    password VARCHAR(20) DEFAULT '' NOT NULL,
    FOREIGN KEY (cc_id) REFERENCES creditcards(id)
);

CREATE TABLE sales(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customer_id INTEGER NOT NULL,
    movie_id VARCHAR(10) DEFAULT '' NOT NULL, 
    sale_date DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);

CREATE TABLE ratings(
    movie_id VARCHAR(10) DEFAULT '' NOT NULL,
    rating FLOAT,
    num_votes INTEGER,
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);