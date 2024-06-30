package com.rdnbrs.kotlin_boot_demo.service

import com.rdnbrs.kotlin_boot_demo.dto.ProductRequestDto
import com.rdnbrs.kotlin_boot_demo.dto.ProductResponseDto

interface IProductService {

    fun saveOrUpdate(requestDto: ProductRequestDto): ProductResponseDto
    fun findAll(): List<ProductResponseDto>

}