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
    values(seq_vaccine.nextval, '21-06-02', '����', 565377, 25945, 6358512, 2198010);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '����Ư����', 103600, 7109, 1092306, 340624);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '�λ걤����', 44891, 1507, 439138, 130833);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '�뱸������', 22868, 1221, 258241, 98109);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '��õ������', 28655, 868, 314522, 103649);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '����������', 14360, 1013, 173394, 60816);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '���ֱ�����', 16806, 795, 194653, 69215);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '��걤����', 10701, 122, 109906, 36305);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '����Ư����ġ��', 2247, 42, 31476, 10517);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-02', '������', 19585, 1049, 245683, 81041);
    
    
    -- 21-06-03
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '����', 381551, 22229, 6741993, 2220728);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '����Ư����', 73063, 6277, 1165736, 346936);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '�λ걤����', 31246, 1313, 470503, 132160);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '�뱸������', 15688, 929, 274006, 99038 );
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '��õ������', 18911, 746, 333493, 104412 );
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '����������', 10312, 1024, 183718, 61898);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '���ֱ�����', 10075, 685, 204788, 69938);
    
    insert into vaccine_count
    values(seq_vaccine.nextval,'21-06-03', '��걤����', 6611, 222, 116548, 36528);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '����Ư����ġ��', 1408, 72, 32896, 10589);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-03', '��⵵', 74413, 4772, 1467476, 473032);
		