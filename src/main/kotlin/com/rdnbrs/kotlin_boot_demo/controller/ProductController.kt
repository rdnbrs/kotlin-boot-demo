package com.rdnbrs.kotlin_boot_demo.controller

import com.rdnbrs.kotlin_boot_demo.dto.ProductRequestDto
import com.rdnbrs.kotlin_boot_demo.dto.ProductResponseDto
import com.rdnbrs.kotlin_boot_demo.service.IProductService
import com.rdnbrs.kotlin_boot_demo.util.GlobalResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/product")
class ProductController(private val service: IProductService) {

    private val logger: Logger = LoggerFactory.getLogger(ProductController::class.java)

    @PostMapping("/save-or-update")
    fun saveOrUpdate(@RequestBody requestDto: ProductRequestDto): ResponseEntity<GlobalResponse<ProductResponseDto>> {
        logger.info("save-or-update service started")
        val responseDto = service.saveOrUpdate(requestDto)
        val response = GlobalResponse(status = "SUCCESS", data = responseDto, message = "Product has created!!!")
        return ResponseEntity<GlobalResponse<ProductResponseDto>>(response, HttpStatus.OK)
    }

    @PostMapping("/find-all")
    fun findAll(): ResponseEntity<GlobalResponse<List<ProductResponseDto>>> {
        logger.info("find-all service started")
        val responseDto = service.findAll()
        val response = GlobalResponse(status = "SUCCESS", data = responseDto, message = "All Products Listed!!!")
        return ResponseEntity<GlobalResponse<List<ProductResponseDto>>>(response, HttpStatus.OK)
    }
}