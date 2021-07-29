package com.bad.ssl.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.client.RestTemplate
import java.net.URI

@SpringBootApplication
class BadSslClientApplication : CommandLineRunner {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    private companion object {
        const val selfSignedExtUrl = "https://self-signed.badssl.com"
        const val selfSignedLocalUrl = "https://localhost:8443/api/simple?word="
    }


    override fun run(vararg args: String?) {
        restTemplate.getForObject(URI(selfSignedExtUrl), String::class.java)
                .also { println(it) }
        println("**********\n")
        restTemplate.getForObject(URI(selfSignedLocalUrl + "SelfSignedCert"), String::class.java)
                .also { println(it) }
    }
}

fun main(args: Array<String>) {
    runApplication<BadSslClientApplication>(*args)
}