package com.senob.mathflat.domain

import com.senob.mathflat.repository.ClassRoomRepository
import javassist.NotFoundException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
internal class ClassRoomTest {
    @Autowired
    private lateinit var classRoomRepository: ClassRoomRepository

    @Autowired
    private lateinit var em: EntityManager

    @Test
    fun `강의 생성`() {
        var classRoom = ClassRoom("신규 강의 오픈!!", "허균", LocalDateTime.now(), LocalDateTime.now())

        classRoomRepository.save(classRoom)

        em.flush()
        em.clear()

        val findClassRoom = classRoomRepository.findById(classRoom.id!!).get()

        Assertions.assertThat(classRoom).isEqualTo(findClassRoom)
    }

    @Test
    fun `강의 수강생 목록 조회`() {

        // data.sql 로 임의 데이터 생성하여 테스트 진행
        val result = classRoomRepository.findById(1).get()

        for (student in result.students) {
            println(student.student.name)
        }
    }

    @Test
    fun `강의 과목 추가 및 조회`() {
        var classRoom = ClassRoom("신규 강의 오픈!!", "허균", LocalDateTime.now(), LocalDateTime.now())

        classRoomRepository.save(classRoom)

        var databaseSubject = Subject("데이터베이스")
        var cLanguageSubject = Subject("c언어")
        var javaLanguageSubject = Subject("자바")
        var networkSubject = Subject("네트워크")

        databaseSubject.classRoom = classRoom
        cLanguageSubject.classRoom = classRoom
        javaLanguageSubject.classRoom = classRoom
        networkSubject.classRoom = classRoom

        em.persist(databaseSubject)
        em.persist(cLanguageSubject)
        em.persist(javaLanguageSubject)
        em.persist(networkSubject)
        em.flush()
        em.clear()

        // 강의에 추가된 과목 조회
        val findClassRoom = classRoomRepository.findById(classRoom.id!!).get()

        for (subject in findClassRoom.subjects) {
            println("subject.id = ${subject.id}, subject.name = ${subject.name}")
        }

    }
}