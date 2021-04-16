drop sequence seq_board;
drop table tbl_board; 

create sequence seq_board;

create table tbl_board(
bno number(10,0),
title varchar2(200) not null,
content varchar2(2000) not null,
writer varchar2(50) not null,
regDate date default sysdate,
updateDate date default sysdate
);

alter table tbl_board add constraint pk_board primary key(bno);

insert into tbl_board(bno, title, content, writer)
values (seq_board.nextval,'테스트 제목00', '테스트 내용00', 'user00' );

insert into tbl_board(bno, title, content, writer)
values (seq_board.nextval,'테스트 제목01', '테스트 내용01', 'user01' );

insert into tbl_board(bno, title, content, writer)
values (seq_board.nextval,'테스트 제목02', '테스트 내용02', 'user02' );

commit; 

select * from tbl_board;

-- 재귀 복사 
 insert into tbl_board (bno,title,content,writer)
 (select seq_board.nextval,title,content,writer from tbl_board); 
