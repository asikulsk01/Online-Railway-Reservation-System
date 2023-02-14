### Database:

```SQL
create user reservation identified by manager;

grant dba to reservation;

commit;

connect reservation/manager;

- Tables:

create table admin6(uname varchar2(40) primary key,name varchar2(40),pword varchar2(50),mail_id varchar2(60),phone_no varchar2(12));
	
create table train6(tr_no number(10) primary key,tr_name varchar2(70),from_stn varchar2(20),to_stn varchar2(20),available number(5),fare number(5));
	
create table ticket2 (pnr varchar2(10) primary key, tr_number number not null, tr_name varchar2(100) not null, from_stn varchar2(100) not null, to_stn varchar2(100) not null, seat number not null);

create table register(uname varchar2(40) primary key,pword varchar2(50),fname varchar2(40),lname varchar2(40),addr varchar2(100), phno varchar2(12), mailid varchar2(60));

- Values for the tables:

insert into admin6 values('admin','admin','admin','admin@tiu.edu','8909878908');
insert into train6 values(13113,'Hazarduari Express','Kolkata','Berhampore Court',300,100);
insert into train6 values(22301,'New Jalpaiguru Vande Bharat Express','Howrah Junction','New Jalpaiguri Junction',400,1565);
insert into register values('asikul','1234','Asikul','Seikh','Kolkata',8536789098,'asikul.s@tiu.edu');

commit;
```

### 1.Code for Procedure(Auto PNR Generation):
```

CREATE OR REPLACE PROCEDURE PROC4 (pnr OUT ticket2.pnr%TYPE, tr_number IN ticket2.tr_number%TYPE, tr_name IN ticket2.tr_name%TYPE, from_stn IN ticket2.from_stn%TYPE, to_stn IN ticket2.to_stn%TYPE, seat IN ticket2.seat%TYPE)
IS
R NUMBER;
BEGIN
SELECT SEQ4.NEXTVAL INTO R FROM DUAL;
pnr:=CONCAT('2023',R);
INSERT INTO ticket2 VALUES(pnr,tr_number,tr_name,from_stn,to_stn,seat);
END;
/

```

### 2.Code for Sequence:
```

CREATE SEQUENCE SEQ4 START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOORDER NOCYCLE NOCACHE;

```

