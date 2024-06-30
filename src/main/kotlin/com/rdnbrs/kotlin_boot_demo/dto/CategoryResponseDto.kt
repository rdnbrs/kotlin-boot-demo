package com.rdnbrs.kotlin_boot_demo.dto

data class CategoryResponseDto(
    var id: Long,
    var name: String,
    var code: String
) {
    fun display(): String {
        return "this is response dto content id:$id name:$name code:$code"
    }
}