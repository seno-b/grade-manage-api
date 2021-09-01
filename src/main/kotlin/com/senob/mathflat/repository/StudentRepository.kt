package com.senob.mathflat.repository

import com.senob.mathflat.domain.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long>{
}