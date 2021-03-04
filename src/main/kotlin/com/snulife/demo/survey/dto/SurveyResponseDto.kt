package com.snulife.demo.survey.dto

import com.snulife.demo.survey.model.OS
import com.snulife.demo.survey.model.SurveyResult
import com.snulife.demo.survey.model.enums.ExperienceDegree

data class SurveyResponseDto(
  val id: Long?,
  val os: OS?,
  val python: ExperienceDegree,
  val rdb: ExperienceDegree,
  val programming: ExperienceDegree,
  val major: String,
  val grade: String) {
  constructor(s: SurveyResult): this(
    id = s.id,
    os=s.os,
    rdb = s.rdb,
    python = s.python,
    programming = s.programming,
    major = s.major,
    grade = s.grade
  )
}