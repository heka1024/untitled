package com.snulife.demo.survey.service

import com.snulife.demo.survey.dto.OSCreateRequestDto
import com.snulife.demo.survey.dto.OSResponseDto
import com.snulife.demo.survey.model.OS
import com.snulife.demo.survey.repository.OSRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class OSService {
  @Autowired
  private lateinit var osRepository: OSRepository

  @Transactional
  fun save(request: OSCreateRequestDto): Long? {
    return osRepository
      .save(request.toEntity())
      .id
  }

  fun getAll(): List<OSResponseDto> {
    return osRepository.findAll().map { OSResponseDto(it) }
  }
}