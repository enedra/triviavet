create table Respuestas(
	id int(11) NOT NULL auto_increment primary key,
    resp varchar(56) not null,
    corIncor bool,
    pregId int,
    foreign key (pregId) references Preguntas(id),
    created_at DATETIME,
	updated_at DATETIME
	);