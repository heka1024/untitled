package com.snulife.demo.survey.model

import com.snulife.demo.model.BaseTimeEntity
import com.snulife.demo.survey.model.enums.ExperienceDegree
import javax.persistence.*

@Entity
@Table(name= "survey_result")
data class SurveyResult(
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "os_id", nullable = true)
  var os: OS? = null,

  @Enumerated(EnumType.ORDINAL)
  var python: ExperienceDegree,

  @Enumerated(EnumType.ORDINAL)
  var rdb: ExperienceDegree,

  @Enumerated(EnumType.ORDINAL)
  var programming: ExperienceDegree,

  @Column(name = "major", length = 120)
  var major: String,

  @Column(name = "grade", length = 20)
  var grade: String,


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null,
) : BaseTimeEntity()