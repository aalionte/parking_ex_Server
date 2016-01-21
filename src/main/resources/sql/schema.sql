drop table if exists gates cascade;

drop table if exists parking_place cascade;

drop table if exists charging_station;

drop table if exists parking_statistics;


create table if not exists gates(
 id         SERIAL UNIQUE NOT NULL,
 name       varchar(40) NOT NULL,
 	PRIMARY KEY(id)

);

create table if not exists parking_place(
	id 		SERIAL UNIQUE NOT NULL,
	row 	varchar(10) NOT NULL,
	number 	integer not null,
	isFree	boolean default true,
	PRIMARY KEY(id)

);

create table if not exists charging_station(
	id		SERIAL UNIQUE NOT NULL,
	isConnected boolean default false,
	power 	integer default 100,
	parking_place_id     integer references parking_place(id),
		PRIMARY KEY(id)

);

create table if not exists parking_statistics(
	id 			SERIAL UNIQUE NOT NULL,
	gate_id  	integer references gates(id),
	parking_place_id integer references parking_place(id),
	enter_time	 date,
	exit_time	 date,
		PRIMARY KEY(id)

	
)