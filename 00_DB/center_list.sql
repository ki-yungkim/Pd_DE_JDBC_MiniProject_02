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
    values(seq_center.nextval, '������ ��â�� ������������', '��â�� ��Ȱü����', '25377', '������ ��â��', '������ ��â�� ��â�� ��å�� 38', '033-330-4835');
    
    insert into center_list
    values(seq_center.nextval, '��󳲵� ��û�� ������������', '��û�� �ǳ�ü����', '52215', '��󳲵� ��û��', '��󳲵� ��û�� �ݼ��� ģȯ���2631���� 39', '055-970-7548');
    
    insert into center_list
    values(seq_center.nextval, '���ֱ����� ���걸 ������������', '���ֺ��ƺ��� ��Ȱü����', '62284', '���ֱ����� ���걸', '���ֱ����� ���걸 ÷�ܿ����� 99, ���ֺ��ƺ���', '062-960-6862');
    
    insert into center_list
    values(seq_center.nextval, '�߾� ������������', '�����߾��Ƿ�� D��', '4562', '����Ư���� �߱�', '����Ư���� �߱� ������ 39�� 29', '02-2260-7114');
    
    insert into center_list
    values(seq_center.nextval, '����Ư���� �߱� ������������', '�湫����������', '4569', '����Ư���� �߱�', '����Ư���� �߱� ���� 387', '02-3396-4503');
    
    insert into center_list
    values(seq_center.nextval, '������ ������ ������������', '�����Ʒ���', '25472', '������ ������', '������ ������ ������� 102', '033-660-2302');
    
    insert into center_list
    values(seq_center.nextval, '��⵵ �Ȼ�� �ܿ��� ������������', '�ø��ȱ��� ü����', '15335', '��⵵ �Ȼ��', '��⵵ �Ȼ�� �ܿ��� ���ݷ�202', '031-369-1702');

    insert into center_list
    values(seq_center.nextval, '���ϵ� ��ɱ� ������������', '�ֻ�ü����', '40136', '���ϵ� ��ɱ�', '���ϵ� ��ɱ� �밡���� �ֻ��ȯ�� 91', '054-950-7950');
    
    insert into center_list
    values(seq_center.nextval, '��û���� õ�Ƚ� ���ϱ� ������������', 'õ�Ƚ� �ǳ��״Ͻ���', '31157', '��û���� õ�Ƚ�', '��û���� õ�Ƚ� ���ϱ� ������ 208', '041-521-3013');
    
    insert into center_list
    values(seq_center.nextval, '��û�ϵ� û�ֽ� ������ ������������', 'û��ü����', '28559', '��û�ϵ� û�ֽ�', '��û�ϵ� û�ֽ� ������ ������� 229', '043-201-3253');
    
