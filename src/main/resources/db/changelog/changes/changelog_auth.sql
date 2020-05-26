CREATE TABLE IF NOT EXISTS user (
  username varchar(40) PRIMARY KEY,
  password varchar(40),
  email varchar(40),
  nickname varchar(40),
  category varchar(40)
);

CREATE TABLE IF NOT EXISTS tutorials (
  ID   INT(10) PRIMARY KEY AUTO_INCREMENT,
  title varchar(40),
  description text(5000),
  tutorialprofile varchar(500),
  video varchar(500),
  photos varchar(100),
  category varchar(40),
  rating integer,
  visibility integer
);

CREATE TABLE IF NOT EXISTS contact (
  ID   INT(10) PRIMARY KEY AUTO_INCREMENT,
    firstname varchar (40),
    lastname varchar(40),
    email varchar(100),
    phone varchar(20),
    comment text(5000)
);




