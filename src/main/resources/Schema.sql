CREATE DATABASE IF NOT EXISTS trivia_dev;

use trivia_dev;

CREATE TABLE IF NOT EXISTS users (
  id int(11) NOT NULL auto_increment PRIMARY KEY,
  name VARCHAR(56) NOT NULL,
  pass VARCHAR(56),
  canc int,
  cani int,
  admi BOOLEAN,
  created_at DATETIME,
  updated_at DATETIME
);

CREATE TABLE IF NOT EXISTS questions (
  id int(11) NOT NULL auto_increment PRIMARY KEY,
  user_id int(11),
  categorie_id int(11),
  ques VARCHAR(255) NOT NULL,
  actv BOOLEAN,
  created_at DATETIME,
  updated_at DATETIME
);

CREATE TABLE IF NOT EXISTS Categories (
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  nomb VARCHAR(56) NOT NULL,
  created_at DATETIME,
  updated_at DATETIME
  );

CREATE TABLE IF NOT EXISTS options (
  id int(11) NOT NULL auto_increment PRIMARY KEY,
  question_id int(11),
  optn VARCHAR(255) NOT NULL,
  corr BOOLEAN,
  created_at DATETIME,
  updated_at DATETIME
);

create table IF NOT EXISTS Games(
	id int not null auto_increment primary key,
    user_id int(11),
    fech date,
    created_at DATETIME,
	updated_at DATETIME
);

create table IF NOT EXISTS Questions_Games(
	question_id int(11),
    user_id int(11),
	created_at DATETIME,
	updated_at DATETIME
);

create table IF NOT EXISTS Questions_Options(
	option_id int(11),
    user_id int(11),
	created_at DATETIME,
	updated_at DATETIME
);