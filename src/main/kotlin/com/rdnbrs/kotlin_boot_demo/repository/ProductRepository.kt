package com.rdnbrs.kotlin_boot_demo.repository

import com.rdnbrs.kotlin_boot_demo.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
}