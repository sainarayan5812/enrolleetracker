create table enrollees(
id integer NOT NULL AUTO_INCREMENT,
name VARCHAR2 (50) NOT NULL,
status VARCHAR2(1) NOT NULL,
dob DATE  NOT NULL,
phone_number VARCHAR2(20),
PRIMARY KEY(id)
);

create table dependents(
id integer NOT NULL AUTO_INCREMENT,
name VARCHAR2 (50) NOT NULL,
dob DATE  NOT NULL,
enrollee_id integer NOT NULL,

PRIMARY KEY(id),
FOREIGN KEY(enrollee_id) REFERENCES enrollees(id)
);