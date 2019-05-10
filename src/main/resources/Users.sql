CREATE TABLE Users (
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  userName VARCHAR(56) NOT NULL,
  cantCorrectas int,
  cantIncorrectas int,
  created_at DATETIME,
  updated_at DATETIME
  );