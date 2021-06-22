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
		
        
   -- 21-06-21
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-21', '����', 505, 1038, 15014819, 4047846);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-21', '����Ư����', 66, 65, 2774797, 747880);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-21', '�λ걤����', 17, 17, 1081657, 255379);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-21', '�뱸������', 151, 0, 634742, 166863 );
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-21', '��õ������', 35, 35, 786702, 199637 );
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-21', '���ֱ�����', 0, 0, 420126, 122405);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-21', '����������', 8, 7, 397285, 109441);
    
    insert into vaccine_count
    values(seq_vaccine.nextval,'21-06-21', '��걤����', 1, 0, 289576, 73965);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-21', '����Ư����ġ��', 0, 0, 76039, 22998);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-21', '��⵵', 114, 828, 3424420, 930548); 


-- 21-06-22

    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-22', '����', 20231, 116453, 15039998, 4167533);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-22', '����Ư����', 4973, 21087, 2781608, 770136);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-22', '�λ걤����', 1207, 9621, 1083070, 265153);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-22', '�뱸������', 946, 4578, 635802, 171569 );
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-22', '��õ������', 1425, 5980, 788393, 205816 );
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-22', '���ֱ�����', 585, 2782, 420755, 125204);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-22', '����������', 578, 3203, 397948, 112665);
    
    insert into vaccine_count
    values(seq_vaccine.nextval,'21-06-22', '��걤����', 390, 1597, 290029, 75596);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-22', '����Ư����ġ��', 164, 275, 76213, 23278);
    
    insert into vaccine_count
    values(seq_vaccine.nextval, '21-06-22', '��⵵', 4416, 23561, 3430158, 955162);      