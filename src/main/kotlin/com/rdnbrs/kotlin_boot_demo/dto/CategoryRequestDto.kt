package com.rdnbrs.kotlin_boot_demo.dto

data class CategoryRequestDto(
    var name: String?,
    var code: String?,
    override var id: Long? = null
) : RequestDto(id)
