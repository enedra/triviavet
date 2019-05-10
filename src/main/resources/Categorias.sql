CREATE TABLE Categorias (
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  nomCat VARCHAR(56) NOT NULL,
  userId int,
  foreign key (userId) references Users(id),
  created_at DATETIME,
  updated_at DATETIME
  );