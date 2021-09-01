package com.senob.mathflat.repository

import com.senob.mathflat.domain.ClassRoom
import org.springframework.data.jpa.repository.JpaRepository

interface ClassRoomRepository : JpaRepository<ClassRoom, Long>{
}