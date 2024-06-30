package com.rdnbrs.kotlin_boot_demo.controller

import com.rdnbrs.kotlin_boot_demo.dto.CategoryRequestDto
import com.rdnbrs.kotlin_boot_demo.dto.CategoryResponseDto
import com.rdnbrs.kotlin_boot_demo.service.ICategoryService
import com.rdnbrs.kotlin_boot_demo.util.GlobalResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/category")
class CategoryController(private val categoryService: ICategoryService) {

    private val logger: Logger = LoggerFactory.getLogger(CategoryController::class.java)

    @GetMapping("/test-endpoint")
    fun testEndpoint(): String {
        logger.info("service started")
        return "Hello, World!"
    }

    @PostMapping("/save-or-update")
    fun saveOrUpdate(@RequestBody categoryRequestDto: CategoryRequestDto): ResponseEntity<GlobalResponse<CategoryResponseDto>> {
        logger.info("save-or-update service started")
        val responseDto = categoryService.saveOrUpdate(categoryRequestDto)
        logger.info(responseDto.display())
        val response = GlobalResponse(status = "SUCCESS", data = responseDto, message = "Category has created!!!")
        return ResponseEntity<GlobalResponse<CategoryResponseDto>>(response, HttpStatus.OK)
    }

    @PostMapping("/find-all")
    fun findAll(): ResponseEntity<GlobalResponse<List<CategoryResponseDto>>> {
        logger.info("find-all service started")
        val responseDto = categoryService.findAll()
        val response = GlobalResponse(status = "SUCCESS", data = responseDto, message = "All Categories Listed")
        return ResponseEntity<GlobalResponse<List<CategoryResponseDto>>>(response, HttpStatus.OK)
    }

    @PostMapping("/find-by-filter")
    fun findByFilter(@RequestBody categoryRequestDto: CategoryRequestDto): ResponseEntity<GlobalResponse<List<CategoryResponseDto>>> {
        logger.info("find-by-filter service started")
        val responseDto = categoryService.findByFilter(categoryRequestDto)
        val response = GlobalResponse(status = "SUCCESS", data = responseDto, message = "Filtered Categories Listed")
        return ResponseEntity<GlobalResponse<List<CategoryResponseDto>>>(response, HttpStatus.OK)
    }

}