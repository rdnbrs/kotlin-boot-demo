package com.rdnbrs.kotlin_boot_demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinBootDemoApplication

fun main(args: Array<String>) {
	runApplication<KotlinBootDemoApplication>(*args)
}
