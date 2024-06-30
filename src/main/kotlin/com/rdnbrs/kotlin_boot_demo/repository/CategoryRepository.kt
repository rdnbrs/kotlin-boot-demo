package com.rdnbrs.kotlin_boot_demo.repository

import com.rdnbrs.kotlin_boot_demo.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CategoryRepository : JpaRepository<Category, Long> {
    @Query("Select category From Category category where (category.name = :name or :name is null) and (category.code = :code or :code is null)")
    fun findByFilter(@Param("code") code: String?, @Param("name") name: String?): List<Category>
}