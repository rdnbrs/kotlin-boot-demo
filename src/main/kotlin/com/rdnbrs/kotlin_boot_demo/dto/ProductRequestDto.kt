package com.rdnbrs.kotlin_boot_demo.dto

import com.rdnbrs.kotlin_boot_demo.entity.Category

data class ProductRequestDto(
    override var id: Long? = null,
    var name: String,
    var price: Double,
    var category: Long
) : RequestDto(id)