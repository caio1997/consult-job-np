package com.immigration.consult.person.controller

import com.immigration.consult.person.exception.GeneralException
import com.immigration.consult.person.service.FindJobService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/get")
class FindJob {

    @Autowired
    lateinit var findJobService: FindJobService

    @GetMapping
    fun findAll():ResponseEntity<Any>{
        return try {
            ResponseEntity.ok().body(findJobService.findAll())
        } catch (e: GeneralException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

}