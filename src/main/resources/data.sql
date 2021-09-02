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

-- 학생 점수 추가
insert into grade (id, score, student_id, subject_id) values (1, 100, 1, 1); -- 홍길동 학생 데이터베이스 과목 100점
insert into grade (id, score, student_id, subject_id) values (2, 95, 1, 2); -- 홍길동 학생 c언어 과목 95점
insert into grade (id, score, student_id, subject_id) values (3, 100, 1, 3); -- 홍길동 학생 java 과목 100점
insert into grade (id, score, student_id, subject_id) values (4, 100, 1, 4); -- 홍길동 학생 네트워크 과목 100점