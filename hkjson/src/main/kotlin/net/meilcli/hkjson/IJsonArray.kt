package net.meilcli.hkjson

interface IJsonArray<T : IHKJson> {

    fun arrayCreator(): (Int) -> Array<T>
}