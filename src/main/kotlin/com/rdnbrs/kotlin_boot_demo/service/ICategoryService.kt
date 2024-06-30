package com.rdnbrs.kotlin_boot_demo.service

import com.rdnbrs.kotlin_boot_demo.dto.CategoryRequestDto
import com.rdnbrs.kotlin_boot_demo.dto.CategoryResponseDto

interface ICategoryService {
    fun saveOrUpdate(categoryRequestDto: CategoryRequestDto): CategoryResponseDto
    fun findAll(): List<CategoryResponseDto>
    fun findByFilter(categoryRequestDto: CategoryRequestDto): List<CategoryResponseDto>
}