package com.rdnbrs.kotlin_boot_demo.service.impl

import com.rdnbrs.kotlin_boot_demo.dto.CategoryRequestDto
import com.rdnbrs.kotlin_boot_demo.dto.CategoryResponseDto
import com.rdnbrs.kotlin_boot_demo.entity.Category
import com.rdnbrs.kotlin_boot_demo.mapper.CategoryMapper
import com.rdnbrs.kotlin_boot_demo.repository.CategoryRepository
import com.rdnbrs.kotlin_boot_demo.service.ICategoryService
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(private val categoryRepository: CategoryRepository, private val mapper: CategoryMapper) :
    ICategoryService {
    override fun saveOrUpdate(categoryRequestDto: CategoryRequestDto): CategoryResponseDto {
        return mapper.entityToDto(categoryRepository.save(mapper.dtoToEntity(categoryRequestDto)))
    }

    override fun findAll(): List<CategoryResponseDto> {
        val categories = categoryRepository.findAll()
        val response: ArrayList<CategoryResponseDto> = ArrayList()
        categories.forEach {
            response.add(mapper.entityToDto(it))
        }
        return response
    }

    override fun findByFilter(categoryRequestDto: CategoryRequestDto): List<CategoryResponseDto> {
        val categories: List<Category> =
            categoryRepository.findByFilter(categoryRequestDto.code, categoryRequestDto.name)
        val response: ArrayList<CategoryResponseDto> = ArrayList()
        categories.forEach {
            response.add(mapper.entityToDto(it))
        }
        return response
    }
}