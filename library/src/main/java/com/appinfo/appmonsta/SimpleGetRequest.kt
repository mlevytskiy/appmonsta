package com.appinfo.appmonsta

interface SimpleGetRequest {

    fun url(value: String): SimpleGetRequest

    fun basicAuth(userName: String, password: String): SimpleGetRequest

    fun produce(): String

}