package com.senob.mathflat.repository

import com.senob.mathflat.domain.Subject
import org.springframework.data.jpa.repository.JpaRepository

interface SubjectRepository : JpaRepository <Subject, Long>{
}