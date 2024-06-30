package com.rdnbrs.kotlin_boot_demo.util

data class GlobalResponse<T>(
    var status: String,
    var data: T,
    var message: String
)