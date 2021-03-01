-- ###############################################################################
-- I2D Core Database
-- ###############################################################################

CREATE DATABASE IF NOT EXISTS frank_garage CHARACTER SET = 'utf8mb4' COLLATE 'utf8mb4_unicode_ci';
USE frank_garage;

create table warehouse (
    id binary(16) not null,
    building_name varchar(100),
    address varchar(150),
    zipcode varchar(10),
    city varchar (50), primary key (id));

create table car (
    id binary(16) not null,
    acquisition_date datetime(6),
    manufacture_date datetime(6),
    price decimal DEFAULT 0,
    brand varchar(100),
    model varchar(100),
    plate_number varchar(10) not null,
    licensed bit,
    warehouse_id binary(16) not null,
    primary key (id));

alter table car add constraint UK_l7g5b63c7u4cbndr4xc7a6doo unique (plate_number);
alter table car add constraint FK6hi0i389pcx8nrvjqavr3d21n foreign key (warehouse_id) references warehouse (id);


DELIMITER //
DROP FUNCTION IF EXISTS UuidToBin;
//
CREATE FUNCTION UuidToBin(_uuid VARCHAR(36))
	RETURNS BINARY(16)
	LANGUAGE SQL  DETERMINISTIC  CONTAINS SQL  SQL SECURITY INVOKER
RETURN
	UNHEX(CONCAT(
		SUBSTR(_uuid,  1, 8),
		SUBSTR(_uuid, 10, 4),
		SUBSTR(_uuid, 15, 4),
		SUBSTR(_uuid, 20, 4),
		SUBSTR(_uuid, 25) ));
//
DROP FUNCTION IF EXISTS BinToUuid;
//
CREATE FUNCTION BinToUuid(_bin BINARY(16))
	RETURNS VARCHAR(36)
	LANGUAGE SQL  DETERMINISTIC  CONTAINS SQL  SQL SECURITY INVOKER
RETURN
	LCASE(CONCAT_WS('-',
		HEX(SUBSTR(_bin,  1, 4)),
		HEX(SUBSTR(_bin,  5, 2)),
		HEX(SUBSTR(_bin,  7, 2)),
		HEX(SUBSTR(_bin,  9, 2)),
		HEX(SUBSTR(_bin, 11)) ));
//
DELIMITER ;

--
-- Some data to start with
--


INSERT INTO warehouse (id, building_name, address, zipcode, city) values (
    UuidToBin(UUID()), 'The rusty brothers Corp.', '366 Los Robles', '91103', 'Pasadena'
);

INSERT INTO warehouse (id, building_name, address, zipcode, city) values (
    UuidToBin(UUID()), 'Olsen Storage Inc.', '112 Sunset Boulevard', '90036', 'Los Angeles'
);

INSERT INTO car (
    id, brand, model, acquisition_date, manufacture_date, plate_number, price, licensed, warehouse_id) VALUES (
    UuidToBin(UUID()), 'Cadillac', '60s Fleetwood', DATE('2021-01-04 00:00:00'), DATE('1961-01-01 00:00:00'), 'CWS999T', 12000, 1, (select id from warehouse where zipcode = '91103'));

INSERT INTO car (
    id, brand, model, acquisition_date, manufacture_date, plate_number, price, licensed, warehouse_id) VALUES (
    UuidToBin(UUID()), 'Cadillac', '62 Fleetwood', DATE('2021-01-04 00:00:00'), DATE('1961-01-01 00:00:00'), 'VHF646F', 12000, 0, (select id from warehouse where zipcode = '91103'));

INSERT INTO car (
    id, brand, model, acquisition_date, manufacture_date, plate_number, price, licensed, warehouse_id) VALUES (
    UuidToBin(UUID()), 'Cadillac', '75 Fleetwood V8', DATE('2021-01-04 00:00:00'), DATE('1961-01-01 00:00:00'), 'BBK747M', 15000, 1, (select id from warehouse where zipcode = '90036'));

INSERT INTO car (
    id, brand, model, acquisition_date, manufacture_date, plate_number, price, licensed, warehouse_id) VALUES (
    UuidToBin(UUID()), 'Cadillac',  'Calais V8', DATE('2021-01-10 00:00:00'), DATE('1965-01-01 00:00:00'), 'CCV888R', 15000, 1, (select id from warehouse where zipcode = '91103'));

INSERT INTO car (
    id, brand, model, acquisition_date, manufacture_date, plate_number, price, licensed, warehouse_id) VALUES (
    UuidToBin(UUID()), 'Cadillac',  'De Ville', DATE('2021-01-10 00:00:00'), DATE('1965-01-01 00:00:00'), 'NHS616Y', 13500, 0, (select id from warehouse where zipcode = '90036'));
