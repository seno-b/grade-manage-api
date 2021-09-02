package com.senob.mathflat.domain

import com.senob.mathflat.repository.ClassRoomRepository
import com.senob.mathflat.repository.StudentRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
@Rollback(false)
internal class StudentTest {

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var classRoomRepository: ClassRoomRepository

    @Autowired
    private lateinit var em: EntityManager

    @Test
    fun `학생 클래스 매핑 테스트`() {

        var classRoom = ClassRoom("신규 강의 오픈!!", "허균", LocalDateTime.now(), LocalDateTime.now())
        classRoomRepository.save(classRoom)

        var student = Student(name = "홍길동", grade = 1, schoolName = "호형호제 학교")
        student.classRooms = listOf(StudentClassRoom(student, classRoom))
        studentRepository.save(student)

        em.flush()
        em.clear()

        var findStudent = studentRepository.findById(student.id!!).get()
        println(findStudent)
        println(findStudent.classRooms)
    }

}