DROP DATABASE IF EXISTS `CA-1`;
DROP DATABASE IF EXISTS `CA-1_Test`;
CREATE SCHEMA `CA-1` ;
CREATE SCHEMA `CA-1_Test` ;
USE `CA-1`;


CREATE TABLE `CA-1`.`cars` (
  `id` INT NOT NULL,
  `Year` INT NOT NULL,
  `Make` VARCHAR(45) NOT NULL,
  `Model` VARCHAR(45) NOT NULL,
  `Price` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `CA-1`.`members` (
  `Studentid` VARCHAR(45) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `FavCandy` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Studentid`));


CREATE TABLE `CA-1`.`jokes` (
  `id` INT NOT NULL,
  `Joke` VARCHAR(126) NOT NULL,
  `Type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
  INSERT INTO cars (id, Year, Make, Model, Price)
VALUES    (1, 1997, "Ford", "E350", 3000),
		  (2, 1999, "Chevy", "Venture", 4900),
		  (3, 2000, "Chevy", "Venture", 5000),
		  (4, 1996, "Jeep", "Grand Cherokee", 4999),
		  (5, 2005, "Volvo", "V70", 44799);
          
INSERT INTO members (studentid, Name, FavCandy)
VALUES ("na157", "Nicolas", "Salte Fisk"),
	   ("aw116", "Alex", "Lakrids"),
       ("aa344", "Andreas", "Chokolade"),
       ("cf161", "Christoffer", "Vingummi");
       
       
INSERT INTO jokes (id, joke, type) 
VALUES (1, "Hvad hedder verdens fattigste konge? Kong Kurs", "Plat"),
	(2, "Hvorfor er fisk så grimme? De er vandskabt", "Plat"),
    (3, "Hvad sagde jesus da han satte sig ind i taxaen? Sømmet i bund!", "Farjokes"),
    (4, "Tror i appelsiner har lyst til at være juice? Eller bliver de presset til det?", "Farjokes"),
    (5, "Skal vi dele en bolle? Eller bolle en del?", "Sjofel"),
    (6, "Hvilken frisure har en kagemand? Slikhår", "Plat"),
    (7, "Hvorfor har et fjernsyn knapper? Det ville se dumt ud med lynlås", "Plat"),
    (8, "Hvad gør en due når den har travlt? Den laver en to-due list", "Farjokes"),
    (9, "Hvordan bliver man ekspert i tordenvejr? Man tager et lynkursus", "Farjokes"),
    (10, "Hvad hedder draculas veganske fætter? Rucola", "Farjokes");