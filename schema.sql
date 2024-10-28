CREATE TABLE Exercise(
	id INT NOT NULL AUTO_INCREMENT,
    name varchar(50),
    instructions varchar(255),
	PRIMARY KEY (id)
);

CREATE TABLE Template(
	id INT NOT NULL AUTO_INCREMENT,
    title varchar(50),
    PRIMARY KEY (id)
);

CREATE TABLE Template_Item(
	id INT NOT NULL AUTO_INCREMENT,
    exercise_id int,
    template_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (exercise_id) REFERENCES Exercise(id),
    FOREIGN KEY (template_id) REFERENCES Template(id)
);
