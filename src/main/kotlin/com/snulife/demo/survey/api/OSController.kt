package com.snulife.demo.survey.api

import com.snulife.demo.survey.dto.OSCreateRequestDto
import com.snulife.demo.survey.dto.OSResponseDto
import com.snulife.demo.survey.service.OSService
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/os")
class OSController(private val osService: OSService) {
  @GetMapping("")
  fun getAll(): List<OSResponseDto> {
    return osService.getAll()
  }

  @PostMapping("")
  fun createOS(@RequestBody request: OSCreateRequestDto): ResponseEntity<Long> {
    val id = osService.save(request)
    return id.let {
      ResponseEntity(id, status = HttpStatus.OK)
    } : ResponseEntity(status = HttpStatus.BAD_REQUEST)
  }
}