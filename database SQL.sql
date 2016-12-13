drop database WebShop;

Create database WebShop;


use Webshop;

create table image(
id int(5) primary key auto_increment,
 image mediumblob, 
 name varchar(20), 
 extension varchar(40)
);

create table produkt(
id int(4) primary key auto_increment,
name varchar(50),
kategori varchar(20),
description varchar(500),
size varchar(6),
pris decimal(65),
leveringstid varchar(6),
image blob
);

create table user(
id int(5) primary key auto_increment,
username varchar(20) unique,
password varchar(100),
FName varchar(20),
LName varchar(20),
email varchar(30),
mobil varchar(30),
Adresse varchar(50),
postnr smallint(4)
);

create table ordertable(
orderid int(5) auto_increment,
username varchar(20),
orderdate date,
ordrebestilt bool,
primary key(orderid, username, orderdate),
foreign key(username) references user(username)
);

create table produktONorder(
orderlinie int primary key auto_increment,
produktid int(5),
orderid int(5),
foreign key(produktid) references produkt(id),
foreign key(orderid) references ordertable(orderid)
);

INSERT INTO produkt (name, kategori, description, size, pris, leveringstid) VALUES 
('INTO THE 5', 'POSTER', 'Poster med abstrakt kunst i blå, hvid og guld. Plakaten fås i flere forskellige størrelser. Plakaten er skabt ud fra en håndlavet maleri og har canvasstrukturen venstre.', '30x40', 75, '2-3'),
('BRUSH BLACK', 'POSTER', 'Elegante og stilfulde elementer med en sort penselstrøg på hvid bakgrunt. Printet er hånd malet og trykt på papir af høj kvalitet. Vi har en bred vifte af sorte og hvide plakater og prints af kunst prints.', '50x70', 99, '3-5'),
('DANCER ONE', 'PLAKAT', 'Sort-hvid plakat med en dansende kvinde. Et cool portræt spækket med energi, som bliver rigtig effektfuld på væggen.', '61x91', 119, '2-5'),
('WHITE OWL', 'POSTER', 'Plakat med fotokunst i form af en hvid ugle. Et smukt og lyst fotografi, der ser godt ud på enhver væg. ', '70x100', 159, '2-3');
SELECT id,name,kategori,description,size,pris,leveringstid FROM produkt;

INSERT INTO user (username, password, FName,LName,email,adresse,postnr) VALUES ('bruger1', 'sha1:64000:18:ZEDrgMt8BPKP0aNKBwuf2BAWm81DOrhX:Ini9tDuPEoSu8o2K1kKUe0r4', 'Albert', 'Eistien','ae@mail.com','Himmelvejen 1', 8900);
INSERT INTO user (username, password, FName,LName,email) VALUES ('admin', 'admin123', 'Admin', 'Bruger','adm@mail.com');
INSERT INTO user (username, password, FName,LName,email) VALUES ('test', 'test123', 'Test', 'Bruger','test@mail.com');
SELECT * FROM user;


INSERT INTO ordertable(username, orderdate,ordrebestilt) VALUES ('bruger1', '2016-12-01', true);
INSERT INTO ordertable(username, orderdate,ordrebestilt) VALUES ('test', '2016-11-30', false);
INSERT INTO ordertable(username, orderdate,ordrebestilt) VALUES ('admin', '2016-11-30', true);
INSERT INTO ordertable(username, orderdate,ordrebestilt) VALUES ('bruger1', '2016-12-02', false);
SELECT * FROM ordertable;

INSERT INTO	produktONorder(produktid,orderid) values (1,1);
INSERT INTO	produktONorder(produktid,orderid) values (1,4);INSERT INTO	produktONorder(produktid,orderid) values (3,4);
INSERT INTO	produktONorder(produktid,orderid) values (2,2);
INSERT INTO	produktONorder(produktid,orderid) values (3,2);
INSERT INTO	produktONorder(produktid,orderid) values (4,3);
SELECT * FROM produktONorder;

UPDATE ordertable SET ordrebestilt = TRUE WHERE orderid = 3;

select orderid,username,orderdate,ordrebestilt from ordertable where username = "bruger1" and orderdate = "2016-12-02";

-- VISER DATAEN FOR ORDREN --
SELECT 
    ordertable.orderid,
    user.username,
    produkt.name,
    produkt.pris
FROM
    ordertable INNER JOIN produktONorder 
    ON ordertable.orderid = produktONorder.orderid
    INNER JOIN produkt 
    ON produktONorder.produktid = produkt.id
    INNER JOIN user ON ordertable.username = user.username
WHERE
    user.username = 'bruger1' AND ordertable.orderid = 1;
    
SELECT 
    ordertable.orderid,
    username,
    name,
    pris
FROM
    ordertable INNER JOIN produktONorder 
    ON ordertable.orderid = produktONorder.orderid
    INNER JOIN produkt 
    ON produktONorder.produktid = produkt.id
    INNER JOIN user ON ordertable.username = user.username
WHERE
    user.username = 'admin' AND ordertable.orderid = 1;
    
SELECT ordertable.orderid, user.username, produkt.name, produkt.pris FROM ordertable INNER JOIN produktONorder ON ordertable.orderid = produktONorder.orderid INNER JOIN produkt ON produktONorder.produktid = produkt.id INNER JOIN user ON ordertable.username = user.username WHERE user.username = 'admin' AND ordertable.orderid = 1;


-- ONLY SUM AF ORDRENS PRIS FOR DET USERNAME -- 
select ordertable.orderid, user.username, SUM(pris) 
	from ordertable INNER JOIN produktONorder 
    ON ordertable.orderid = produktONorder.orderid
    INNER JOIN produkt 
    ON produktONorder.produktid = produkt.id
    INNER JOIN user ON ordertable.username = user.username
WHERE
    user.username = 'bruger1' AND ordertable.orderid = 4;
   
select SUM(pris) as samletpris from ordertable INNER JOIN produktONorder ON ordertable.orderid = produktONorder.orderid INNER JOIN produkt ON produktONorder.produktid = produkt.id INNER JOIN user ON ordertable.username = user.username WHERE user.username = 'admin' AND ordertable.orderid = 1;
