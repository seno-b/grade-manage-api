-- 학생 추가
insert into student (id, grade, school_name, name) values (1, 1, '부산대학교', '홍길동');
insert into student (id, grade, school_name, name) values (2, 1, '부산대학교', '장길산');
insert into student (id, grade, school_name, name) values (3, 1, '부산대학교', '임꺽정');

-- 강의 추가
insert into class_room (id, name, start_date, end_date, teacher_name) values (1, 'Kotlin 기초', sysdate(), sysdate() + 30, '백기선');

-- 과목 추가
insert into subject (id, class_id, name) values (1, 1, '데이터베이스');
insert into subject (id, class_id, name) values (2, 1, 'c언어');
insert into subject (id, class_id, name) values (3, 1, 'java');
insert into subject (id, class_id, name) values (4, 1, '네트워크');

-- 학생 강의 매핑 (강의 수강)
insert into student_classroom ( student_id, class_id ) values (1, 1);
insert into student_classroom ( student_id, class_id ) values (2, 1);
insert into student_classroom ( student_id, class_id ) values (3, 1);