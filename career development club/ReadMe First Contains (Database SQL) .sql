**********************************************************************
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Software Engineering Project;
Submitted By...
1.Syed Ahsan Sirat
ID: 140303020001
2.Fahmida Begum
ID: 140303020005
3.Azharul Haque Chowdhury
ID: 140303020009
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

Note: Make an Oacle Database Named "cdc" with a Password "12345";
Then We can Make This Tables To Prepare This Software. Thank You.
//cdc,12345
**********************************************************************

create table admin
( 		serial integer constraint pk primary key,
		u_name varchar2(20) not null,
		pass varchar2(20) not null
);

insert into admin (serial,u_name,pass) values (1,'admin','1234');
commit;





create table member(
id number(20,0) constraint memberpk primary key,
m_name varchar2(20) not null,
m_address varchar2(50),
m_phone varchar2(15),
m_depertment varchar2(3),
m_session varchar2(10),
m_bloodGroup varchar2(4),
m_age integer,
m_gender varchar2(7),
m_email varchar2(50),
m_fbId varchar2(50)
);

create table language (
classNo integer, 
id number(20,0) references member(id),
attandance integer not null,
performance integer,
ldate date
);


create table meeting(
meetingNo integer ,
id number(20,0) references member(id),
attandance integer not null,
mdate date
);


create table contest (
contestNo integer,
id number(20,0) references member(id),
contestTitle varchar2(25),
attandance integer not null,
performance integer,
cdate date
);


create table result (
id number(20,0) references member(id),
semester integer,
gpa number(4,2)
);


