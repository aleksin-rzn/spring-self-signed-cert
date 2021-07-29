package com.bad.ssl.client.configuration

import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.TrustSelfSignedStrategy
import org.apache.http.impl.client.HttpClients
import org.apache.http.ssl.SSLContextBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.Resource
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
class RestConfiguration {
    @Value("\${trust.store}")
    private lateinit var trustStore: Resource

    @Value("\${trust.password}")
    private lateinit var trustStorePassword: String

    @Bean
    @Primary
    fun restTemplate() = SSLContextBuilder()
            .loadTrustMaterial(trustStore.url, trustStorePassword.toCharArray(), TrustSelfSignedStrategy())
            .build()
            .let {
                SSLConnectionSocketFactory(it)
            }
            .let {
                HttpClients.custom()
                        .setSSLSocketFactory(it)
                        .build()
            }
            .let {
                HttpComponentsClientHttpRequestFactory(it)
            }
            .let {
                RestTemplate(it)
            }
}