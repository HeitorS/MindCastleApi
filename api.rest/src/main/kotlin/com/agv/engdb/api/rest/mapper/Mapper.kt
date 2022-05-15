package com.agv.engdb.api.rest.mapper

interface Mapper<T, U> {
    fun map(t:T): U
}
