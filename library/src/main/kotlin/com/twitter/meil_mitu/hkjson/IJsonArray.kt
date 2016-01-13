package com.twitter.meil_mitu.hkjson

interface IJsonArray<T : IJson> {

    fun arrayCreator(): (Int) -> Array<T>
}