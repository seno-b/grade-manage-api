package com.senob.mathflat.domain

import com.senob.mathflat.repository.ClassRoomRepository
import com.senob.mathflat.repository.GradeRepository
import com.senob.mathflat.repository.StudentRepository
import com.senob.mathflat.repository.SubjectRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
internal class GradeTest {

    @Autowired
    private lateinit var gradeRepository: GradeRepository

    @Autowired
    private lateinit var subjectRepository: SubjectRepository

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var em: EntityManager

    @Test
    fun `점수 추가`() {

        // data.sql 로 임의 데이터 생성하여 테스트 진행
        val findSubject = subjectRepository.findById(1).get()
        val findStudent = studentRepository.findById(1).get()

        var databaseGrade = Grade(100)
        databaseGrade.student = findStudent
        databaseGrade.subject = findSubject

        gradeRepository.save(databaseGrade)

        em.clear()

        val findGrade = gradeRepository.findById(databaseGrade.id!!).get()

        println(findGrade)
        Assertions.assertThat(findGrade).isEqualTo(databaseGrade)

    }
}