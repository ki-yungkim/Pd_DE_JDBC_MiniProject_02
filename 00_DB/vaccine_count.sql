-- vaccine_count

drop table vaccine_count;
drop sequence seq_vaccine;

select * from vaccine_count;

create table vaccine_count (
       vacci_count_no number(10),
       day date not null,
       region varchar2(100) not null,
       y_first   number(30) not null,
       y_second  number(30) not null,
       t_first   number(30) not null,
       t_second  number(30) not null,
       constraint pk_vacci_no primary key(vacci_count_no)
      
   );
    
    create sequence seq_vaccine
    start with 1
    increment by 1
    maxvalue 300
    nocycle;
    
    -- 21-06-02
   insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '전국', 565377, 25945, 6358512, 2198010);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '서울특별시', 103600, 7109, 1092306, 340624);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '부산광역시', 44891, 1507, 439138, 130833);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '대구광역시', 22868, 1221, 258241, 98109);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '인천광역시', 28655, 868, 314522, 103649);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '대전광역시', 14360, 1013, 173394, 60816);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '광주광역시', 16806, 795, 194653, 69215);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '울산광역시', 10701, 122, 109906, 36305);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '세종특별자치시', 2247, 42, 31476, 10517);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '강원도', 19585, 1049, 245683, 81041);
    
    
    -- 21-06-03
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '전국', 381551, 22229, 6741993, 2220728);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '서울특별시', 73063, 6277, 1165736, 346936);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '부산광역시', 31246, 1313, 470503, 132160);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '대구광역시', 15688, 929, 274006, 99038 );
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '인천광역시', 18911, 746, 333493, 104412 );
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '대전광역시', 10312, 1024, 183718, 61898);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '광주광역시', 10075, 685, 204788, 69938);
    
    insert into vaccine_count
    values(seq_vaccine.nextval,'21-06-03', '울산광역시', 6611, 222, 116548, 36528);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '세종특별자치시', 1408, 72, 32896, 10589);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '경기도', 74413, 4772, 1467476, 473032);
		