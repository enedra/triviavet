create table PregunResp(
	respId int,
    userId int,
    foreign key (respId) references Respuestas (id),
    foreign key (userId) references Users (id),
	created_at DATETIME,
	updated_at DATETIME
);