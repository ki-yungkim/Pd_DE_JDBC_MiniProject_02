-- 예약자 정보 테이블
select * from tab;

create table reserve (
    r_name varchar2(30) not null,
    mobile varchar2(30) not null,
    adrress varchar2(300) not null,
    id_number varchar2(30),
    vaccine_name varchar2(30) not null,
    f_vaccinedate date not null,
    constraint pk_reserve primary key(id_number)
    );
    
select * from reserve;
    
    