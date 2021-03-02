package com.snulife.demo.survey.model.enums

enum class ExperienceDegree(private val value: Int) {
  VERY_LOW(1),
  LOW(2),
  MIDDLE(3),
  HIGH(4),
  VERY_HIGH(5);

  fun getKey(): String {
    return name
  }

  fun getValue(): Int {
    return value
  }
}