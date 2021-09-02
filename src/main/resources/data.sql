insert into student (id, grade, school_name, name) values (1, 1, '부산대학교', '홍길동');
insert into student (id, grade, school_name, name) values (2, 1, '부산대학교', '장길산');
insert into student (id, grade, school_name, name) values (3, 1, '부산대학교', '임꺽정');

insert into class_room (id, name, start_date, end_date, teacher_name) values (1, 'Kotlin 기초', sysdate(), sysdate() + 30, '백기선');

insert into student_classroom ( student_id, class_id ) values (1, 1);
insert into student_classroom ( student_id, class_id ) values (2, 1);
insert into student_classroom ( student_id, class_id ) values (3, 1);