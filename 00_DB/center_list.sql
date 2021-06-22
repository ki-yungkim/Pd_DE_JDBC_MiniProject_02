-- center_list
drop table center_list;
drop sequence seq_center;

select * from center_list;

create table center_list (
       center_no number(10),
       center_name varchar2(60) not null,
       facility_name varchar2(100) not null,
       postnumber varchar2(30) not null,
       adress  varchar2(30) not null,
       adress_detail varchar2(500) not null,
       phone_number varchar2(30) not null,
       constraint pk_center_no primary key(center_no)
   );
    
    create sequence seq_center
    start with 1
    increment by 1
    maxvalue 300
    nocycle;
    
    
    insert into center_list
    values(seq_center.nextval, '강원도 평창군 예방접종센터', '평창읍 생활체육관', '25377', '강원도 평창군', '강원도 평창군 평창읍 산책길 38', '033-330-4835');
    
    insert into center_list
    values(seq_center.nextval, '경상남도 산청군 예방접종센터', '산청군 실내체육관', '52215', '경상남도 산청군', '경상남도 산청군 금서면 친환경로2631번길 39', '055-970-7548');
    
    insert into center_list
    values(seq_center.nextval, '광주광역시 광산구 예방접종센터', '광주보훈병원 재활체육관', '62284', '광주광역시 광산구', '광주광역시 광산구 첨단월봉로 99, 광주보훈병원', '062-960-6862');
    
    insert into center_list
    values(seq_center.nextval, '중앙 예방접종센터', '국립중앙의료원 D동', '4562', '서울특별시 중구', '서울특별시 중구 을지로 39길 29', '02-2260-7114');
    
    insert into center_list
    values(seq_center.nextval, '서울특별시 중구 예방접종센터', '충무스포츠센터', '4569', '서울특별시 중구', '서울특별시 중구 퇴계로 387', '02-3396-4503');
    
    insert into center_list
    values(seq_center.nextval, '강원도 강릉시 예방접종센터', '강릉아레나', '25472', '강원도 강릉시', '강원도 강릉시 수리골길 102', '033-660-2302');
    
    insert into center_list
    values(seq_center.nextval, '경기도 안산시 단원구 예방접종센터', '올림픽기념관 체육관', '15335', '경기도 안산시', '경기도 안산시 단원구 적금로202', '031-369-1702');

    insert into center_list
    values(seq_center.nextval, '경상북도 고령군 예방접종센터', '주산체육관', '40136', '경상북도 고령군', '경상북도 고령군 대가야읍 주산순환길 91', '054-950-7950');
    
    insert into center_list
    values(seq_center.nextval, '충청남도 천안시 서북구 예방접종센터', '천안시 실내테니스장', '31157', '충청남도 천안시', '충청남도 천안시 서북구 번영로 208', '041-521-3013');
    
    insert into center_list
    values(seq_center.nextval, '충청북도 청주시 서원구 예방접종센터', '청주체육관', '28559', '충청북도 청주시', '충청북도 청주시 서원구 사직대로 229', '043-201-3253');
    
