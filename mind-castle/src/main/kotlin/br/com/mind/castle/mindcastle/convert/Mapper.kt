package br.com.mind.castle.mindcastle.convert

interface Mapper<T,U> {
    fun convert(o:T): U
}