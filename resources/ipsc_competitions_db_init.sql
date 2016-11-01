CREATE DATABASE ipsc_competitions;
USE ipsc_competitions;

CREATE USER 'ipsc' IDENTIFIED BY 'ipsc-password-!@#';
GRANT ALL PRIVILEGES ON ipsc_competitions.* TO 'ipsc';

CREATE TABLE roles
(
id INT AUTO_INCREMENT PRIMARY KEY,
name ENUM ('ADMIN', 'MODERATOR', 'USER') UNIQUE NOT NULL
);
INSERT INTO roles (name) VALUES ('ADMIN'), ('MODERATOR'), ('USER');

-- *****************************************************************************************************

CREATE TABLE countries
(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL,
img_flag BLOB
);
INSERT INTO countries (name) VALUES ('Namibia'), ('South'), ('Africa'), ('Zimbabwe'), ('Australia'), ('Cambodia'), ('China'), ('Guam'), 
('Hong Kong'), ('Indonesia'), ('Japan'), ('Kuwait'), ('Laos'), ('Macau'), ('Malaysia'), ('Mongolia'), ('New Zealand'), ('Papua New Guinea'), 
('Philippines'), ('Singapore'), ('Sri Lanka'), ('Taiwan'), ('Thailand'), ('Andorra'), ('Armenia'), ('Austria'), 
('Belarus'), ('Belgium'), ('Bosnia and Herzegovina'), ('Bulgaria'), ('Channel Islands'), ('Croatia'), ('Cyprus'), ('Czech Republic'), 
('Denmark'), ('Estonia'), ('Finland'), ('France'), ('Germany'), ('Gibraltar'), ('Greece'), ('Hungary'), ('Ireland'), ('Isle of Man'),
('Israel'), ('Italy'), ('Kazakhstan'), ('Kyrgyzstan'), ('Latvia'), ('Lithuania'), ('Malta'), ('Moldova'), ('Monaco'), 
('Montenegro'), ('Netherlands'), ('Northern Ireland'), ('Norway'), ('Poland'), ('Portugal'), ('Romania'), ('Russia'), ('Serbia'), 
('Slovakia'), ('Slovenia'), ('Spain'), ('Sweden'), ('Switzerland'), ('Turkey'), ('Ukraine'), ('United Kingdom'), ('Aruba'), ('Barbados'), 
('Cayman'), ('Islands'), ('Colombia'), ('Costa Rica'), ('Curaçao'), ('Ecuador'), ('El Salvador'), ('Guatemala'), ('Honduras'), 
('Jamaica'), ('Nicaragua'), ('Panama'), ('Puerto Rico'), ('Saint Lucia'), ('Trinidad and Tobago'), ('Venezuela'), 
('Canada'), ('USA'), ('Argentina'), ('Bolivia'), ('Brazil'), ('Chile'), ('Guyana'), ('Paraguay'), ('Peru'), ('Suriname'), ('Uruguay');

-- *************************************************************************************************

CREATE TABLE clubs
(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL
);
-- *************************************************************************************************

CREATE TABLE powerfactors
(
id INT AUTO_INCREMENT PRIMARY KEY,
name ENUM ('MINOR', 'MAJOR') UNIQUE NOT NULL
);
INSERT INTO powerfactors (name) VALUES ('MINOR'),('MAJOR');

-- ***************************************************************************************************
CREATE TABLE handgun_divisions
(
id INT AUTO_INCREMENT PRIMARY KEY,
name ENUM ('PRODUCTION', 'STANDART', 'CLASSIC', 'OPEN', 'REVOLVER'),
powerfactor_id INT NOT NULL,
CONSTRAINT fk_handgun_divisions_powerfactors FOREIGN KEY (powerfactor_id) REFERENCES powerfactors (id),
UNIQUE KEY handgun_division_name_pf (name, powerfactor_id)
);
INSERT INTO handgun_divisions (name, powerfactor_id) 
      VALUES ('PRODUCTION', 1), ('STANDART', 1),('STANDART', 2),
             ('CLASSIC', 1),('CLASSIC', 2), ('OPEN',1), ('OPEN',2),('REVOLVER',1), ('REVOLVER',2);

CREATE TABLE shotgun_divisions
(
id INT AUTO_INCREMENT PRIMARY KEY,
name ENUM ('STANDART MANUAL','STANDART', 'MODIFIED', 'OPEN'),
powerfactor_id INT,
CONSTRAINT fk_shotgun_divisions_powerfactors FOREIGN KEY (powerfactor_id) REFERENCES powerfactors (id),
UNIQUE KEY shotgun_division_name_pf (name, powerfactor_id)
);
INSERT INTO shotgun_divisions  (name) 
    VALUES ('STANDART MANUAL'), ('STANDART'), ('MODIFIED'), ('OPEN');

CREATE TABLE rifle_divisions
(
id INT AUTO_INCREMENT PRIMARY KEY,
name ENUM ('SEMI-AUTO STANDART','SEMI-AUTO OPEN', 'MANUAL ACTION STANDART', 'MANUAL ACTION OPEN'),
powerfactor_id INT NOT NULL,
CONSTRAINT fk_rifle_divisions_powerfactors FOREIGN KEY (powerfactor_id) REFERENCES powerfactors (id),
UNIQUE KEY riffle_division_name_pf (name, powerfactor_id)
);
INSERT INTO rifle_divisions  (name, powerfactor_id) 
   VALUES ('SEMI-AUTO STANDART',1), ('SEMI-AUTO OPEN',1), ('MANUAL ACTION STANDART',1), ('MANUAL ACTION OPEN',1),
          ('SEMI-AUTO STANDART',2), ('SEMI-AUTO OPEN',2), ('MANUAL ACTION STANDART',2), ('MANUAL ACTION OPEN',2);

-- *************************************************************************************************


CREATE TABLE categories
(
id INT AUTO_INCREMENT PRIMARY KEY,
name ENUM ('REGULAR', 'JUNIOR', 'LADY', 'SENIOR', 'SUPER SENIOR') UNIQUE NOT NULL
);
INSERT INTO categories (name) VALUES ('REGULAR'),('JUNIOR'),('LADY'),('SENIOR'),('SUPER SENIOR');

-- ****************************************************************************************************

CREATE TABLE currencies
(
id INT AUTO_INCREMENT PRIMARY KEY,
name ENUM ('BGN', 'EUR') UNIQUE NOT NULL
);
INSERT INTO currencies (name) VALUES ('BGN'), ('EUR');

-- ****************************************************************************************************

CREATE TABLE users
(
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
midle_name VARCHAR(20),
last_name VARCHAR(20) NOT NULL,
username VARCHAR(50) UNIQUE NOT NULL,
alias VARCHAR(50),
password VARCHAR(50) NOT NULL,
email VARCHAR(50) UNIQUE NOT NULL,
telephone VARCHAR(50),
role_id INT NOT NULL,
club_id INT NOT NULL,
country_id INT NOT NULL,
category_id INT NOT NULL,
handgun_division_id INT ,
shoting_division_id INT,
rifle_division_id INT,
CONSTRAINT fk_users_roles FOREIGN KEY (role_id) REFERENCES roles (id),
CONSTRAINT fk_users_clubs FOREIGN KEY (club_id) REFERENCES clubs (id),
CONSTRAINT fk_users_countries FOREIGN KEY (country_id) REFERENCES countries (id),
CONSTRAINT fk_users_categories FOREIGN KEY (category_id) REFERENCES categories (id),
CONSTRAINT fk_users_handgun_division FOREIGN KEY (handgun_division_id) REFERENCES handgun_divisions (id),
CONSTRAINT fk_users_shoting_division FOREIGN KEY (shoting_division_id) REFERENCES shotgun_divisions (id),
CONSTRAINT fk_users_rifle_division FOREIGN KEY (rifle_division_id) REFERENCES rifle_divisions (id)
);


-- ***************************************************************************************************

CREATE TABLE competitions
(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(200) NOT NULL,
date_pre_match DATE,
date_main_match DATE NOT NULL,
date_registry_deadline DATE,
date_payment_deadline DATE,
entry_fee DECIMAL NOT NULL,
currency_id INT NOT NULL,
match_level INT NOT NULL,
description TEXT,
created_by INT NOT NULL,
CONSTRAINT fk_competitions_currencies FOREIGN KEY (currency_id) REFERENCES currencies (id),
CONSTRAINT fk_competitions_users FOREIGN KEY (created_by) REFERENCES users (id)
);

-- ****************************************************************************************************

CREATE TABLE stages
(
id INT AUTO_INCREMENT PRIMARY KEY,
number INT NOT NULL,
competition_id INT NOT NULL,
min_rounds INT NOT NULL,
max_points INT NOT NULL,
description TEXT,
stage_img BLOB,
CONSTRAINT fk_stages_competitions FOREIGN KEY (competition_id) REFERENCES competitions (id),
UNIQUE KEY stage_number_competition_id (number, competition_id)
);

-- ****************************************************************************************************

CREATE TABLE squads
(
id INT AUTO_INCREMENT PRIMARY KEY,
number INT NOT NULL,
competition_id INT NOT NULL,
CONSTRAINT fk_squads_competitions FOREIGN KEY (competition_id) REFERENCES competitions (id),
UNIQUE KEY squad_number_competition_id (number, competition_id)
);

-- ****************************************************************************************************

CREATE TABLE personal_resuts
(
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
stage_id INT NOT NULL,
A INT,
C INT,
D INT,
miss INT,
P_T INT,
proc INT,
time DECIMAL NOT NULL,
CONSTRAINT fk_personal_resuts_users FOREIGN KEY (user_id) REFERENCES users (id),
CONSTRAINT fk_personal_resuts_stages FOREIGN KEY (stage_id) REFERENCES stages (id),
UNIQUE KEY stage_id_user_id (stage_id, user_id)
);

-- *****************************************************************************************************

CREATE TABLE registered_users
(
id INT AUTO_INCREMENT PRIMARY KEY,
competition_id INT NOT NULL,
user_id INT NOT NULL,
payment_status ENUM ('YES', 'NO'),
result_status ENUM ('PROCESS', 'FINISH', 'DQ'),
CONSTRAINT fk_registered_users_competitions FOREIGN KEY (competition_id) REFERENCES competitions (id),
CONSTRAINT fk_registered_users_users FOREIGN KEY (user_id) REFERENCES users (id),
UNIQUE KEY user_id_competition_id (user_id, competition_id)
);

