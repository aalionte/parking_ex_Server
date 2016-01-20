create table if not exists gates(
 id         integer CONSTRAINT firstkey PRIMARY KEY,
 name       varchar(40) NOT NULL
);

create table if not exists parking_place(
	id 	integer PRIMARY KEY,
	row 	varchar(10) NOT NULL,
	number 	integer not null
);

create table if not exists charging_station(
	id 		integer CONSTRAINT firstkey PRIMARY KEY,
	isFree 	boolean default true,
	isConnected boolean default false,
	power integer default 100,
	CONSTRAINT parking_place UNIQUE(id)
);

statistics(
	id 		integer CONSTRAINT firstkey PRIMARY KEY,
	CONSTRAINT gate id,
	CONSTRAINT parking_place id,
	CONSTRAINT 
	
)