create database "movies-platform";

create table movies (
  id int primary key auto_increment,
  name varchar(400) not null unique,
  genre varchar(20) not null,
  description varchar(500) not null,
  duration_in_minutes int not null,
  is_available boolean not null default true,
  age_range int not null
);

create table people (
  id int primary key auto_increment,
  name varchar(255) not null,
  email varchar(50) not null unique,
  password varchar(255) not null,
  telephone varchar(16) not null,
  address varchar (255),
  is_admin boolean not null default false
);

create table people_movies (
  person_id int not null auto_increment,
  movie_id int not null,
  minutes_watched int not null,
  constraint fk_person foreign key(person_id) references people(id),
  constraint fk_movie foreign key(movie_id) references movies(id),
  primary key(person_id, movie_id)
);