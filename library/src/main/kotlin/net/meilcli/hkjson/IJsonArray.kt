package net.meilcli.hkjson

interface IJsonArray<T : IJson> {

    fun arrayCreator(): (Int) -> Array<T>
}