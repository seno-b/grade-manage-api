package com.senob.mathflat.domain

import javax.persistence.*

@Entity
class Grade(score: Int) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var score: Int = score
}
