delete from individual_workout;
DELETE FROM group_workout;
DELETE FROM COACH;
DELETE FROM FITNESS_USER;

INSERT INTO COACH(email, username, phone_number, education, professional_experience)
VALUES ('v.dimitrov@abv.bg', 'Valentin Dimitrov', '0898955457', 'National Sports Academy "Vassil Levski"', '10 years');
INSERT INTO COACH(email, username, phone_number, education, professional_experience)
VALUES ('kalo.ivanov@abv.bg', 'Kaloyan Ivanov', '0895200635', 'National Sports Academy "Vassil Levski"', '6 years');
INSERT INTO COACH(email, username, phone_number, education, professional_experience)
VALUES ('dim.petrov@abv.bg', 'Dimitar Petrov', '0559654785', 'Paisii Hilendarski University of Plovdiv', '3 years');

INSERT INTO Fitness_User(email, username, password)
VALUES ('mimi@abv.bg', 'Maria', 'alabala123');
INSERT INTO Fitness_User(email, username, password)
VALUES ('kiko22@gmail.com', 'Kiko', '123456789');
INSERT INTO Fitness_User(email, username, password)
VALUES ('asibasi@abv.bg', 'Asa', '123');
INSERT INTO Fitness_User(email, username, password)
VALUES ('eli@abv.bg', 'Eli', '111');

insert into group_workout(date, email, name, hall_number, description)
values ('2024/10/12 10:10:11','v.dimitrov@abv.bg', 'crossfit', 4, 'test');
insert into group_workout(date, email, name, hall_number, description)
values ('2024/10/12 10:10:12','v.dimitrov@abv.bg', 'crossfit', 4, 'test');
insert into group_workout(date, email, name, hall_number, description)
values ('2024/10/12 10:10:13','v.dimitrov@abv.bg', 'crossfit', 4, 'test');

INSERT INTO individual_workout(date, coach_email, email)
values ('2024/10/12 10:11:11','v.dimitrov@abv.bg','asibasi@abv.bg');
INSERT INTO individual_workout(date, coach_email, email)
values ('2024/10/11 11:11:11','kalo.ivanov@abv.bg','mimi@abv.bg');
INSERT INTO individual_workout(date, coach_email, email)
values ('2024/10/10 09:00:00','kalo.ivanov@abv.bg','mimi@abv.bg');


