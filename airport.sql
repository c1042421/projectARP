ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

DROP TABLE vliegtuig cascade constraints;
DROP TABLE stockage cascade constraints;
DROP TABLE hangar cascade constraints;
DROP TABLE luchtvaartmaatschappij cascade constraints;
DROP TABLE functie cascade constraints;
DROP TABLE vlucht cascade constraints;
DROP TABLE bemanningslid cascade constraints;
DROP TABLE persoon cascade constraints;
DROP TABLE vluchtbemanning cascade constraints;
DROP TABLE luchthaven cascade constraints;
DROP TABLE passagier cascade constraints;
DROP TABLE vliegtuigtype cascade constraints;
DROP TABLE vliegtuigklasse cascade constraints;
DROP TABLE land cascade constraints;

DROP SEQUENCE vliegtuig_seq;
DROP SEQUENCE stockage_seq;
DROP SEQUENCE hangar_seq;
DROP SEQUENCE luchtvaartmaatschappij_seq;
DROP SEQUENCE functie_seq;
DROP SEQUENCE vlucht_seq;
DROP SEQUENCE bemanningslid_seq;
DROP SEQUENCE persoon_seq;
DROP SEQUENCE vluchtbemanning_seq;
DROP SEQUENCE luchthaven_seq;
DROP SEQUENCE passagier_seq;
DROP SEQUENCE vliegtuigtype_seq;
DROP SEQUENCE vliegtuigklasse_seq;
DROP SEQUENCE land_seq;;


CREATE TABLE luchtvaartmaatschappij 
(id 				smallint primary key,
luchtvaartnaam 		varchar(30) not null
);

CREATE SEQUENCE luchtvaartmaatschappij_seq;

insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'Brussels Airlines');
insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'KLM');
insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'Air France');
insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'Ukraine International Airlines');
insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'Lufthansa');
insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'United Airlines');
insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'Etihad Airways');
insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'Croatia Airlines');
insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'Singapore Airlines');
insert into luchtvaartmaatschappij (id, luchtvaartnaam) values (luchtvaartmaatschappij_seq.nextval, 'Brittish Airways');


CREATE TABLE functie 
(id 			smallint primary key,
functienaam 	varchar(30) not null,
omschrijving 	varchar(60) not null
);

CREATE SEQUENCE functie_seq;

insert into functie(id, functienaam, omschrijving) values(functie_seq.nextval, 'steward', 'zorgt voor veiligheid en service aan boord van het vliegtuig');
insert into functie(id, functienaam, omschrijving) values(functie_seq.nextval, 'stewardess', 'zorgt voor veiligheid en service aan boord van het vliegtuig');
insert into functie(id, functienaam, omschrijving) values(functie_seq.nextval, 'purser', 'leidinggevende van de stewards en stewardessen');
insert into functie(id, functienaam, omschrijving) values(functie_seq.nextval, 'piloot', 'bestuurt het vliegtuig');


CREATE TABLE vliegtuigtype
(id		smallint		primary key,
typenaam 	varchar(30) not null
);

CREATE SEQUENCE vliegtuigtype_seq;

insert into vliegtuigtype (id, typenaam) values (vliegtuigtype_seq.nextval, 'Airbus A330');
insert into vliegtuigtype (id, typenaam) values (vliegtuigtype_seq.nextval, 'Airbus A340');
insert into vliegtuigtype (id, typenaam ) values (vliegtuigtype_seq.nextval, 'Airbus A380');
insert into vliegtuigtype (id, typenaam ) values (vliegtuigtype_seq.nextval, 'Boeing 737');
insert into vliegtuigtype (id, typenaam ) values (vliegtuigtype_seq.nextval, 'Boeing 747');
insert into vliegtuigtype (id, typenaam ) values (vliegtuigtype_seq.nextval, 'Boeing 767');
insert into vliegtuigtype (id, typenaam ) values (vliegtuigtype_seq.nextval, 'Boeing 777');
insert into vliegtuigtype (id, typenaam ) values (vliegtuigtype_seq.nextval, 'Boeing 787');
insert into vliegtuigtype (id, typenaam ) values (vliegtuigtype_seq.nextval, 'Fokker 70');
insert into vliegtuigtype (id, typenaam ) values (vliegtuigtype_seq.nextval, 'Embraer E-Jet 70');

CREATE TABLE vliegtuig
(id						smallint		primary key,
 vliegtuigtype_id 			smallint,
 luchtvaartmaatschappij_id		smallint,
 foreign key (vliegtuigtype_id) references vliegtuigtype(id) on delete cascade,
 foreign key (luchtvaartmaatschappij_id) references luchtvaartmaatschappij(id) on delete cascade
);

CREATE SEQUENCE vliegtuig_seq;

insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 1, 1);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 1, 1);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 2, 2);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 2, 3);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 3, 4);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 3, 5);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 4, 6);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 5, 7);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 6, 8);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 7, 9);
insert into vliegtuig(id, vliegtuigtype_id, luchtvaartmaatschappij_id) values (vliegtuig_seq.nextval, 9, 10);


CREATE TABLE hangar 
(id 		smallint primary key,
hangarnaam varchar(30) not null
);

CREATE SEQUENCE hangar_seq;

insert into hangar (id, hangarnaam ) values (hangar_seq.nextval, 'Loods 1');
insert into hangar (id, hangarnaam ) values (hangar_seq.nextval, 'Loods 2');
insert into hangar (id, hangarnaam ) values (hangar_seq.nextval, 'Loods 3');
insert into hangar (id, hangarnaam ) values (hangar_seq.nextval, 'Hangar BA');

CREATE TABLE vliegtuigklasse
(id 			smallint primary key,
klassenaam 	varchar(30) not null
);

CREATE SEQUENCE vliegtuigklasse_seq;

insert into vliegtuigklasse(id, klassenaam ) values (vliegtuigklasse_seq.nextval, 'economy');
insert into vliegtuigklasse(id, klassenaam ) values (vliegtuigklasse_seq.nextval, 'business class');
insert into vliegtuigklasse(id, klassenaam ) values (vliegtuigklasse_seq.nextval, 'first class');


CREATE TABLE stockage
(
id			smallint 		primary key,
reden			varchar(50),
vandatum		date,
totdatum 		date,
vliegtuig_id 	smallint,
hangar_id 		smallint,
foreign key (vliegtuig_id) references vliegtuig(id) on delete cascade,
foreign key (hangar_id) references hangar(id)  on delete cascade
);

CREATE SEQUENCE stockage_seq;

insert into stockage(id, reden, vandatum, totdatum, vliegtuig_id, hangar_id) values (stockage_seq.nextval, 'onderhoud na 350 vlieguren', '2017-06-28', '2017-06-29', 1, 4);
insert into stockage(id, reden, vandatum, totdatum, vliegtuig_id, hangar_id) values (stockage_seq.nextval, 'onderhoud vliegtuig 11 jaar oud', '2017-07-03', '2017-07-10', 4, 1);
insert into stockage(id, reden, vandatum, totdatum, vliegtuig_id, hangar_id) values (stockage_seq.nextval, 'onderhoud 26000 vlieguren', '2017-08-01', '2017-10-01', 8, 2);

CREATE TABLE land
(id 			smallint primary key,
landnaam 		varchar(30) not null
);

CREATE SEQUENCE land_seq;

insert into land (id, landnaam) values (land_seq.nextval, 'België');
insert into land (id, landnaam) values (land_seq.nextval, 'Duitsland');
insert into land (id, landnaam) values (land_seq.nextval, 'Verenigd Koninkrijk');
insert into land (id, landnaam) values (land_seq.nextval, 'Italië');
insert into land (id, landnaam) values (land_seq.nextval, 'Nederland');
insert into land (id, landnaam) values (land_seq.nextval, 'Frankrijk');
insert into land (id, landnaam) values (land_seq.nextval, 'Zweden');
insert into land (id, landnaam) values (land_seq.nextval, 'Verenigde Arabische Emiraten');
insert into land (id, landnaam) values (land_seq.nextval, 'India');


CREATE TABLE luchthaven 
(id 			smallint primary key,
luchthavennaam 	varchar(30) not null,
stad			varchar(30) not null,
land_id         smallint,
foreign key (land_id) references land(id) on delete cascade
);

CREATE SEQUENCE luchthaven_seq;

insert into luchthaven (id, luchthavennaam , stad, land_id) values (luchthaven_seq.nextval, 'Brussels Airport', 'Brussel', 1);
insert into luchthaven (id, luchthavennaam , stad, land_id)  values (luchthaven_seq.nextval, 'Schiphol', 'Amsterdam', 5);
insert into luchthaven (id, luchthavennaam , stad, land_id)  values (luchthaven_seq.nextval, 'Charles de Gaulle', 'Parijs', 6);
insert into luchthaven (id, luchthavennaam , stad, land_id)  values (luchthaven_seq.nextval, 'Heathrow', 'Londen', 3);
insert into luchthaven (id, luchthavennaam , stad, land_id)  values (luchthaven_seq.nextval, 'Tegel', 'Berlijn', 2);
insert into luchthaven (id, luchthavennaam , stad, land_id)  values (luchthaven_seq.nextval, 'Goteborg City Airport', 'Goteborg', 7);
insert into luchthaven (id, luchthavennaam , stad, land_id)  values (luchthaven_seq.nextval, 'Venice VCE', 'Venetie', 4);
insert into luchthaven (id, luchthavennaam , stad, land_id)  values (luchthaven_seq.nextval, 'Abu Dhabi', 'Abu Dhabi', 8);
insert into luchthaven (id, luchthavennaam , stad, land_id)  values (luchthaven_seq.nextval, 'Sri Guru Ram DassJee', 'Amritsar', 9);


CREATE TABLE vlucht
(
id				smallint		primary key,
code 				varchar(30) not null,
vertrektijd		date,
aankomsttijd		date,
vliegtuig_id 		smallint,
vertrekluchthaven_id 	smallint,
aankomstluchthaven_id smallint,
foreign key (vliegtuig_id) references vliegtuig(id) on delete cascade,
foreign key (vertrekluchthaven_id) references luchthaven(id) on delete cascade,
foreign key (aankomstluchthaven_id) references luchthaven(id) on delete cascade
);

CREATE SEQUENCE vlucht_seq;

insert into vlucht (id, code, vertrektijd, aankomsttijd, vliegtuig_id, vertrekluchthaven_id, aankomstluchthaven_id) values (vlucht_seq.nextval, 'SN2314', to_date('2017-06-01 09:40', 'yyyy-mm-dd hh24:mi'), to_date('2017-06-01 11:25', 'yyyy-mm-dd hh24:mi'), 1, 1, 6);
insert into vlucht (id, code, vertrektijd, aankomsttijd, vliegtuig_id, vertrekluchthaven_id, aankomstluchthaven_id) values (vlucht_seq.nextval, 'EY055', to_date('2017-06-01 08:55', 'yyyy-mm-dd hh24:mi'), to_date('2017-06-01 14:15', 'yyyy-mm-dd hh24:mi'), 8, 1, 8);
insert into vlucht (id, code, vertrektijd, aankomsttijd, vliegtuig_id, vertrekluchthaven_id, aankomstluchthaven_id) values (vlucht_seq.nextval, 'SN2582', to_date('2017-06-01 11:40', 'yyyy-mm-dd hh24:mi'), to_date('2017-06-01 13:05', 'yyyy-mm-dd hh24:mi'), 1, 1, 5);


CREATE TABLE persoon 
(id 			smallint primary key,
voornaam 		varchar(30) not null,
familienaam 	varchar(30) not null,
straat 		varchar(30) not null,
huisnr 		varchar(30) not null,
postcode 		varchar(30) not null,
woonplaats 	varchar(30) not null,
land 			varchar(30) not null,
geboortedatum 	date not null,
login 		varchar(30)	not null,
paswoord 		varchar(30)	not null,
soort			char(1)		not null
);

CREATE SEQUENCE persoon_seq;

insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Jonas', 'Van Hemelrijck', 'Mageleinstraat', '22', '2650', 'Edegem', 'Belgie', '1982-02-01', 'jonasvanhemelrijck', 'jonas', 'B');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Saskia', 'Van Herck', 'Bibliotheekstraat', '1', '2650', 'Edegem', 'Belgie', '1984-03-09', 'saskiavanherck', 'sas', 'B');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Eveline', 'Pieters', 'Offerlaan', '2', '2650', 'Edegem', 'Belgie', '1978-07-07', 'evelinepieters', 'eveline', 'B');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Danny', 'Annaert', 'Driesstraat', '5', '9111', 'Belsele', 'Belgie', '1970-01-21', 'dannyannaert', 'ikke', 'B');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Robin', 'Collaert', 'Ravenstraat', '30', '9290', 'Berlare', 'Belgie', '1972-09-21', 'robincollaert', 'derobin', 'B');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Tessa', 'Borremans', 'Elshout', '55', '9290', 'Berlare', 'Belgie', '1966-09-05', 'tessaborremans', 'tess', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Norbert', 'Lauwerys', 'Pastorijstraat', '53', '2150', 'Borsbeek', 'Belgie', '1974-09-16', 'norbertlauwerys', 'a1w7yr2', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Brent', 'Allaert', 'Papegaaistraat', '23', '9255', 'Buggenhout', 'Belgie', '1992-11-21', 'brentallaert', '78br93', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Geert', 'Huyck', 'Leistraat', '56', '9200', 'Dendermonde', 'Belgie', '1972-08-01', 'geerthuyck', 'geert', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Hilde', 'Moens', 'Nieuwstraat', '78', '9200', 'Dendermonde', 'Belgie', '1973-04-18', 'hildemoens', 'moens', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Colin', 'Van Nuffel', 'Stationstraat', '33', '9200', 'Dendermonde', 'Belgie', '2001-10-12', 'cvannuffel', 'colin', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Owen', 'Van Nuffel', 'Stationstraat', '33', '9200', 'Dendermonde', 'Belgie', '2003-11-11', 'ovannuffel', 'owen', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Yves', 'Brys', 'Aarthof', '7', '9200', 'Dendermonde', 'Belgie', '1972-05-06', 'yvesbrys', 'yves', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Erwin', 'Van Nuffel', 'Stationstraat', '33', '9200', 'Dendermonde', 'Belgie', '1956-08-28', 'erwinvannuffel', 'erwinvannuffel', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Luc', 'Van Nuffel', 'Wimpstraat', '9', '9200', 'Dendermonde', 'Belgie', '1950-03-05', 'lucvannuffel', '1234', 'P');
insert into persoon (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort) values (persoon_seq.nextval, 'Jan', 'Snoeckx', 'Schoolstraat', '50', '2930', 'Brasschaat', 'Belgie', '1959-06-25', 'admin', 'admin', 'A');


CREATE TABLE bemanningslid
(
id					smallint		primary key,
luchtvaartmaatschappij_id 	smallint,
persoon_id 			smallint,
functie_id 			smallint,
foreign key (luchtvaartmaatschappij_id) references luchtvaartmaatschappij(id)  on delete cascade,
foreign key (persoon_id) references persoon(id) on delete cascade,
foreign key (functie_id) references functie(id) on delete cascade
);

CREATE SEQUENCE bemanningslid_seq;

insert into bemanningslid(id, luchtvaartmaatschappij_id, persoon_id, functie_id) values (bemanningslid_seq.nextval, 1, 2, 2);
insert into bemanningslid(id, luchtvaartmaatschappij_id, persoon_id, functie_id) values (bemanningslid_seq.nextval, 1, 3, 2);
insert into bemanningslid(id, luchtvaartmaatschappij_id, persoon_id, functie_id) values (bemanningslid_seq.nextval, 1, 1, 3);
insert into bemanningslid(id, luchtvaartmaatschappij_id, persoon_id, functie_id) values (bemanningslid_seq.nextval, 1, 4, 4);
insert into bemanningslid(id, luchtvaartmaatschappij_id, persoon_id, functie_id) values (bemanningslid_seq.nextval, 1, 5, 4);

CREATE TABLE vluchtbemanning
(
id 				smallint primary key,
taak 				varchar(30),
bemanningslid_id 	smallint not null,
vlucht_id 			smallint not null,
foreign key (bemanningslid_id) references bemanningslid(id)  on delete cascade,
foreign key (vlucht_id) references vlucht(id) on delete cascade
);

CREATE SEQUENCE vluchtbemanning_seq;

insert into vluchtbemanning(id, taak, bemanningslid_id, vlucht_id) values (vluchtbemanning_seq.nextval, null, 1, 1);
insert into vluchtbemanning(id, taak, bemanningslid_id, vlucht_id) values (vluchtbemanning_seq.nextval, null, 2, 1);
insert into vluchtbemanning(id, taak, bemanningslid_id, vlucht_id) values (vluchtbemanning_seq.nextval, null, 3, 1);
insert into vluchtbemanning(id, taak, bemanningslid_id, vlucht_id) values (vluchtbemanning_seq.nextval, 'piloot', 4, 1);
insert into vluchtbemanning(id, taak, bemanningslid_id, vlucht_id) values (vluchtbemanning_seq.nextval, 'copiloot', 5, 1);


CREATE TABLE passagier
(id 			smallint primary key,
ingeschreven 	number(1,0),
ingecheckt 	number(1,0),
klasse_id 		smallint not null,
plaats 		varchar(30),
vlucht_id 		smallint not null,
persoon_id 	smallint not null,
foreign key (vlucht_id) references vlucht(id) on delete cascade,
foreign key (persoon_id) references persoon(id) on delete cascade,
foreign key (klasse_id) references vliegtuigklasse(id) on delete cascade
);

CREATE SEQUENCE passagier_seq;

insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 1, 1, 'A11', 1, 6);
insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 0, 1, 'C11', 1, 7);
insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 0, 1, 'D11', 1, 8);
insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 0, 1, 'F11', 1, 9);
insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 0, 1, 'H11', 1, 10);
insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 0, 1, 'K11', 1, 11);
insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 0, 1, 'A12', 1, 12);
insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 0, 1, 'C12', 1, 13);
insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 0, 1, 'D12', 1, 14);
insert into passagier(id, ingeschreven, ingecheckt, klasse_id, plaats, vlucht_id, persoon_id) values (passagier_seq.nextval, 1, 0, 1, 'F12', 1, 15);
commit;

