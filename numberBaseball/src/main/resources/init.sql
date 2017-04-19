DROP TABLE IF EXISTS player;

CREATE TABLE player (
	no INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id VARCHAR(10) NOT NULL,
	password VARCHAR(20) NOT NULL,
	point INT(20)
);

INSERT INTO player(id, password, point) VALUES('test', '1234', '10');