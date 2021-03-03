package com.snulife.demo.survey.dto

import com.snulife.demo.survey.model.OS

data class OSResponseDto(
  val id: Long?,
  val name: String,
  val description: String,
  val price: Int?
) {
  constructor(os: OS): this(id =os.id, name =os.name, description =os.description, price =os.price)
}