package com.senob.mathflat.repository

import com.senob.mathflat.domain.Grade
import org.springframework.data.jpa.repository.JpaRepository

interface GradeRepository : JpaRepository<Grade, Long> {
}