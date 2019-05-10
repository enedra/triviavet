create table Pregun_Games(
	questionId int,
    userId int,
    foreign key (questionId) references Preguntas (id),
    foreign key (userId) references Users (id),
	created_at DATETIME,
	updated_at DATETIME
);