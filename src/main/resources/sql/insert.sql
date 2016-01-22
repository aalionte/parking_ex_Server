delete from gates;

insert into gates  (name) VALUES
	('Gate1'),
	('Gate2'),
	('Gate3'),
	('Gate4');
	
	
delete from parking_place;

DO
$do$
BEGIN 
FOR i IN 1..1000 LOOP
INSERT into parking_place (row, number, is_free) values
	('A', i, true);
END LOOP;
END
$do$;


delete from charging_station;

insert into charging_station (is_connected, power, parking_place_id) VALUES
	(false, 100, 15),
	(false, 100, 17),
	(false, 100, 100),
	(false, 100, 150),
	(false, 100, 215),
	(false, 100, 259),
	(false, 100, 500),
	(false, 100, 600),
	(false, 100, 749),
	(false, 100,  989);
	
	