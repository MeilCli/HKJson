package com.twitter.meil_mitu.hkjson

interface IJsonObject<T : IJson> {

    fun creator(): () -> T
}