package com.bad.ssl.server.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController {

    @GetMapping("api/simple")
    fun sayHello(@RequestParam word:String) = "Hello, $word!"
}