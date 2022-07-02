package com.api.rest.mapper

interface Mapper<T, U> {
    fun map(t:T): U
}
