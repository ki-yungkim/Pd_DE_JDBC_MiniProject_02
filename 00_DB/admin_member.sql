-- admin_member


create table admin_member (
       admin_id varchar2(50),
       admin_pw varchar2(100),
       admin_name varchar2(30)
       
       constraint pk_admin_id primary key(admin_id)
      
   );
    

    
    insert into admin_member
    values('admin01', 'adminpassword01', '������1');
    
    insert into admin_member
    values('admin02', 'adminpassword02', '������2');
    
    
  