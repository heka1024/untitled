package com.snulife.demo.survey.dto

import com.snulife.demo.survey.model.OS

data class OSCreateRequestDto(
  val name: String,
  val description: String,
  val price: Int?,
) {
  fun toEntity(): OS {
    return OS(
      name=name,
      description=description,
      price=price
    )
  }
}