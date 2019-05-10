create table Preguntas(
	id  int(11) NOT NULL auto_increment PRIMARY KEY,
	question VARCHAR(56) NOT NULL,
    userId int,
    catId int,
	foreign key (userId) references Users(id),
	foreign key (catId) references Categorias(id),
	created_at DATETIME,
	updated_at DATETIME
	);