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
INSERT into parking_place (row, number) values
	('A', i);
END LOOP;
END
$do$;

	
	