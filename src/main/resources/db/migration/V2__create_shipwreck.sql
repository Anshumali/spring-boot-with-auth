CREATE SEQUENCE SHIPWRECK_SEQ START 101;

create table shipwreck(
	id int,
	name varchar(225),
	description varchar(2000),
	condition varchar(225),
	depth int,
	latitude NUMERIC,
	longitude NUMERIC,
	year_discovered int );