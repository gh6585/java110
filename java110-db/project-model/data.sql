--회원 정보
insert into p1_memb(mno,name,email,pwd,cdt)
value (1, 'user01', 'user01@test.com', password('1111'), now());
insert into p1_memb(mno,name,email,pwd,cdt)
value (2, 'user02', 'user02@test.com', password('1111'), now());
insert into p1_memb(mno,name,email,pwd,cdt)
value (3, 'user03', 'user03@test.com', password('1111'), now());
insert into p1_memb(mno,name,email,pwd,cdt)
value (4, 'user04', 'user04@test.com', password('1111'), now());
insert into p1_memb(mno,name,email,pwd,cdt)
value (5, 'user05', 'user05@test.com', password('1111'), now());
insert into p1_memb(mno,name,email,pwd,cdt)
value (6, 'user06', 'user06@test.com', password('1111'), now());
insert into p1_memb(mno,name,email,pwd,cdt)
value (7, 'user07', 'user07@test.com', password('1111'), now());
insert into p1_memb(mno,name,email,pwd,cdt)
value (8, 'user08', 'user08@test.com', password('1111'), now());
insert into p1_memb(mno,name,email,pwd,cdt)
value (9, 'user09', 'user09@test.com', password('1111'), now());
insert into p1_memb(mno,name,email,pwd,cdt)
value (10, 'user10', 'user10@test.com', password('1111'), now());

-- 학생 회원
insert into p1_stud(sno,schl,work) value(1,'비트대학교','N');
insert into p1_stud(sno,schl,work) value(2,'비트대학교','Y');
insert into p1_stud(sno,schl,work) value(3,'캠프대학교','Y');
insert into p1_stud(sno,schl,work) value(4,'캠프대학교','N');
insert into p1_stud(sno,schl,work) value(5,'오호라대학교','N');

-- 강사 회원
insert into p1_tchr(tno,hrpay,subj) value(6,10000,'자바,c,c++');
insert into p1_tchr(tno,hrpay,subj) value(7,12000,'자바,빅데이터');
insert into p1_tchr(tno,hrpay,subj) value(8,14000,'c,c++,안드로이드');

-- 매니저 회원
insert into p1_mgr(mrno,posi) value(9,'대리');
insert into p1_mgr(mrno,posi) value(10,'과장');