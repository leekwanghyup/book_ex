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
 
 
 ## 댓글 처리를 위한 테이블 
 create table tbl_reply(
    rno number(10,0), 
    bno number(10,0) not null, 
    reply varchar2(1000) not null, 
    replyer varchar2(50) not null,
    replyDate date default sysdate,
    updateDate date default sysdate
);

## 시퀀스 
create sequence seq_reply;

## 기본키  
alter table tbl_reply add constraint pk_reply primary key(rno);

## 외래키 
alter table tbl_reply add constraint fk_reply_board 
foreign key (bno) references tbl_board(bno);
  
  
  
