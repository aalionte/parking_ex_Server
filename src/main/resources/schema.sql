create table if not exists gates(
 id         integer CONSTRAINT firstkey PRIMARY KEY,
 name       varchar(40) NOT NULL
);

create table if not exists parking_place(
	id 		integer PRIMARY KEY,
	row 	varchar(10) NOT NULL,
	number 	integer not null
);

create table if not exists charging_station(
	id		integer  PRIMARY KEY,
	isFree 	boolean default true,
	isConnected boolean default false,
	power 	integer default 100,
	parking_place_id     integer references parking_place(id)
);

create table if not exists statistics(
	id 			integer PRIMARY KEY,
	gate_id  	integer references gates(id),
	parking_place_id integer references parking_place(id),
	enter_time	 date,
	exit_time	 date
	
)