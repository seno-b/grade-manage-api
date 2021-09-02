package com.senob.mathflat.domain

import com.senob.mathflat.repository.ClassRoomRepository
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
    fun `강의 생성 테스트`() {
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
        classRoomRepository
    }
}