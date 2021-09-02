package com.senob.mathflat.domain

import com.senob.mathflat.repository.ClassRoomRepository
import com.senob.mathflat.repository.StudentRepository
import org.assertj.core.api.Assertions
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
    fun `학생 강의 매핑`() {

        var classRoom = ClassRoom("데이터베이스 초급 강의", "김영한", LocalDateTime.now(), LocalDateTime.now().plusMonths(1))
        classRoomRepository.save(classRoom)

        var student = Student(name = "방신호", grade = 1, schoolName = "백암고등학교")
        studentRepository.save(student)

        val studentClassRoom = StudentClassRoom(student, classRoom)
        em.persist(studentClassRoom)
        em.flush()
        em.clear()

        var findStudent = studentRepository.findById(student.id!!).get()
        println(findStudent)
        for (data in findStudent.classRooms) {
            println("classRoom.id = ${data.classRoom.id}, classRoom.name = ${data.classRoom.name}")
        }

        Assertions.assertThat(classRoom.id).isEqualTo(findStudent.classRooms.get(0).classRoom.id)
    }

}