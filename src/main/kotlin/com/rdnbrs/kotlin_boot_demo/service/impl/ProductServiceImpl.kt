package com.rdnbrs.kotlin_boot_demo.service.impl

import com.rdnbrs.kotlin_boot_demo.dto.ProductRequestDto
import com.rdnbrs.kotlin_boot_demo.dto.ProductResponseDto
import com.rdnbrs.kotlin_boot_demo.mapper.ProductMapper
import com.rdnbrs.kotlin_boot_demo.repository.ProductRepository
import com.rdnbrs.kotlin_boot_demo.service.IProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val repository: ProductRepository, private val mapper: ProductMapper) :
    IProductService {

    override fun saveOrUpdate(requestDto: ProductRequestDto): ProductResponseDto {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(requestDto)))
    }

    override fun findAll(): List<ProductResponseDto> {
        val products = repository.findAll()
        val response: ArrayList<ProductResponseDto> = ArrayList()

        products.forEach {
            response.add(mapper.entityToDto(it))
        }

        return response
    }
}