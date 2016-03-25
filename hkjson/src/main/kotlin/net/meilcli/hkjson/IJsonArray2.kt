package net.meilcli.hkjson

interface IJsonArray2<T : IHKJson> {

    fun arrayCreator(): (Int) -> Array<T>
}