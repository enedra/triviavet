create table Games(
	id int not null auto_increment primary key,
    userId int,
    fecha date,
    foreign key (userId) references Users (id),
	created_at DATETIME,
	updated_at DATETIME
);