package com.rdnbrs.kotlin_boot_demo.mapper

import com.rdnbrs.kotlin_boot_demo.dto.CategoryRequestDto
import com.rdnbrs.kotlin_boot_demo.dto.CategoryResponseDto
import com.rdnbrs.kotlin_boot_demo.entity.Category
import org.springframework.stereotype.Component

@Component
class CategoryMapper {

    fun dtoToEntity(requestDto: CategoryRequestDto): Category {
        val response = Category(code = requestDto.code ?: "", name = requestDto.name ?: "")
        if (requestDto.id != null)
            response.id = requestDto.id!!
        return response
    }

    fun entityToDto(entity: Category): CategoryResponseDto {
        return CategoryResponseDto(
            id = entity.id,
            name = entity.name,
            code = entity.code
        )
    }
}