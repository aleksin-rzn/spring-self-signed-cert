package com.bad.ssl.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BadSslServerApplication

fun main(args: Array<String>) {
	runApplication<BadSslServerApplication>(*args)
}
