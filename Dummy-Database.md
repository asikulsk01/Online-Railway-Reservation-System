### Just open the Oracle sql command prompt and login to administrator user and copy paste the following codes for creating dummy database:

```SQL
create user reservation identified by manager;

grant dba to reservation;

commit;

connect reservation/manager;

create table admin6(uname varchar2(40) primary key,name varchar2(40),
	pword varchar2(50),mail_id varchar2(60),phone_no varchar2(12));
	
create table train6(tr_no number(10) primary key,tr_name varchar2(70),
	from_stn varchar2(20),to_stn varchar2(20),available number(5),fare number(5));

create table register(uname varchar2(40) primary key,pword varchar2(50),
	fname varchar2(40),lname varchar2(40),
	addr varchar2(100), phno varchar2(12), mailid varchar2(60));

insert into admin6 values('admin','admin','admin','admin@train.com','9874561230');
insert into admin6 values('shashi','shashi','admin','shashi@train.com','98323561230');
insert into train6 values(10101,'Jodhpur Exp','Howrah','Jodhpur',152,450);
insert into train6 values(10102,'Mumbai Mail','Gaya','Mumbai',182,650);
insert into register values('shashi','shashi','Shashi','Raj','Tekari, Gaya, Bihar',954745222,'shashiraj.972@gmail.com');

commit;
```

1. Code for procedure:
*********************

CREATE OR REPLACE PROCEDURE PROC4 (pnr OUT ticket2.pnr%TYPE, tr_number IN ticket2.tr_number%TYPE, tr_name IN ticket2.tr_name%TYPE, from_stn IN ticket2.from_stn%TYPE, to_stn IN ticket2.to_stn%TYPE, seat IN ticket2.seat%TYPE)
IS
R NUMBER;
BEGIN
SELECT SEQ4.NEXTVAL INTO R FROM DUAL;
pnr:=CONCAT('2023',R);
INSERT INTO ticket2 VALUES(pnr,tr_number,tr_name,from_stn,to_stn,seat);
END;
/



2. Code for sequence:
*********************

CREATE SEQUENCE SEQ4 START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOORDER NOCYCLE NOCACHE;


3. Code for table creation:

CREATE TABLE ticket2 (pnr VARCHAR2(10) PRIMARY KEY, tr_number number NOT NULL, tr_name varchar2(100) NOT NULL, from_stn varchar2(100) NOT NULL, to_stn varchar2(100) NOT NULL, seat number NOT NULL);
