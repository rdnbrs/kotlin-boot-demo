package com.rdnbrs.kotlin_boot_demo.dto

data class ProductRequestDto(
    override var id: Long? = null,
    var name: String,
    var price: Double,
    var category: Long
) : RequestDto(id)