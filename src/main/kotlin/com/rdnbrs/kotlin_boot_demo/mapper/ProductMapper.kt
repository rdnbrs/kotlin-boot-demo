package com.rdnbrs.kotlin_boot_demo.mapper

import com.rdnbrs.kotlin_boot_demo.dto.ProductRequestDto
import com.rdnbrs.kotlin_boot_demo.dto.ProductResponseDto
import com.rdnbrs.kotlin_boot_demo.entity.Product
import com.rdnbrs.kotlin_boot_demo.repository.CategoryRepository
import org.springframework.stereotype.Component

@Component
class ProductMapper(private val categoryRepository: CategoryRepository) {

    fun dtoToEntity(requestDto: ProductRequestDto): Product {
        val response = Product(
            name = requestDto.name,
            price = requestDto.price,
            category = categoryRepository.findById(requestDto.category).orElseThrow()
        )
        if (requestDto.id != null)
            response.id = requestDto.id!!
        return response
    }

    fun entityToDto(entity: Product): ProductResponseDto {
        return ProductResponseDto(
            price = entity.price,
            name = entity.name,
            category = entity.category?.id,
            id = entity.id
        )
    }

}