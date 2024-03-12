--Soccer JPA 버전
show tables;

drop table stadium;
CREATE TABLE stadium (
  id int not null AUTO_INCREMENT,
  stadium_name varchar(40) not null,
  hometeam_id VARCHAR(10) not null,
  seat_count int not null,
  address VARCHAR(60) not null,
  ddd VARCHAR(10) not null,
  tel VARCHAR(10) not null,
  PRIMARY KEY (id)
);

drop table schedule;
CREATE TABLE schedule (
  id int not null AUTO_INCREMENT,
  sche_date varchar(10),
  stadium_id int,
  gubun VARCHAR(10),
  hometeam_id varchar(10),
  awayteam_id VARCHAR(10),
  home_score int,
  away_score int,
  PRIMARY KEY (id),
  FOREIGN KEY (stadium_id) references stadium (id)
);

CREATE TABLE team (
  id int not null AUTO_INCREMENT,
  stadium_id int,
  region_name varchar(10),
  team_name varchar(40),
  e_team_name VARCHAR(50),
  origin_yyyy varchar(10),
  zip_code1 VARCHAR(10),
  zip_code2 VARCHAR(10),
  address varchar(80),
  ddd varchar(10),
  tel varchar(10),
  fax varchar(10),
  homepage varchar(50),
  owner varchar(10),
  PRIMARY KEY (id),
  FOREIGN KEY (stadium_id) references stadium (id)
);

CREATE TABLE player (
  id int not null AUTO_INCREMENT,
  team_id int,
  player_name varchar(20),
  e_player_name VARCHAR(40),
  nickname varchar(30),
  join_yyyy VARCHAR(10),
  position VARCHAR(10),
  back_no int,
  nation varchar(20),
  birth_date date,
  solar varchar(10),
  height int,
  weight int,
  PRIMARY KEY (id),
  FOREIGN KEY (team_id) references team (id)
);