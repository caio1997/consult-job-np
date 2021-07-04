package com.immigration.consult.person.entity


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Job(var vaga: String?, var cargo: String?, var empresa: String?, var cidade: String?, var estado: String?) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null

}