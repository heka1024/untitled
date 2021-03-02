package com.snulife.demo.survey.repository

import com.snulife.demo.survey.model.SurveyResult
import org.springframework.data.jpa.repository.JpaRepository

interface SurveyResultRepository : JpaRepository<SurveyResult, Long>