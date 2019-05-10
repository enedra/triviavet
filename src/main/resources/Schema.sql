CREATE DATABASE IF NOT EXISTS trivia_dev;

use trivia_dev;

CREATE TABLE IF NOT EXISTS users (
  id int(11) NOT NULL auto_increment PRIMARY KEY,
  username VARCHAR(56) NOT NULL,
  password VARCHAR(56),
  cantCorrectas int,
  cantIncorrectas int,
  admin BOOLEAN,
  created_at DATETIME,
  updated_at DATETIME
);

CREATE TABLE IF NOT EXISTS questions (
  id int(11) NOT NULL auto_increment PRIMARY KEY,
  user_id int(11),
  categorie_id int(11),
  description VARCHAR(255) NOT NULL,
  active BOOLEAN,
  created_at DATETIME,
  updated_at DATETIME
);

CREATE TABLE Categories (
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  nomCat VARCHAR(56) NOT NULL,
  user_id int,
  created_at DATETIME,
  updated_at DATETIME
  );

CREATE TABLE IF NOT EXISTS options (
  id int(11) NOT NULL auto_increment PRIMARY KEY,
  question_id int(11),
  description VARCHAR(255) NOT NULL,
  correct BOOLEAN,
  created_at DATETIME,
  updated_at DATETIME
);

create table Games(
	id int not null auto_increment primary key,
    user_id int(11),
    fecha date,
    created_at DATETIME,
	updated_at DATETIME
);

create table Questions_Games(
	question_id int(11),
    user_id int(11),
	created_at DATETIME,
	updated_at DATETIME
);

create table PregunResp(
	resp_id int(11),
    user_id int(11),
	created_at DATETIME,
	updated_at DATETIME
);