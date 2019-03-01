CREATE TABLE IF NOT EXISTS hero (
  id long identity primary key,
  name varchar(128) not null,
  fullname varchar(128) not null,
  description varchar(1024) not null
);