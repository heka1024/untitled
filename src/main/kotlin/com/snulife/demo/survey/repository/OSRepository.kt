package com.snulife.demo.survey.repository

import com.snulife.demo.survey.model.OS
import org.springframework.data.jpa.repository.JpaRepository

interface OSRepository : JpaRepository<OS, Long> {
  fun findByName(name: String): OS?
}