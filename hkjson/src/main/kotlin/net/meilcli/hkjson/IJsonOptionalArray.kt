package net.meilcli.hkjson

interface IJsonOptionalArray<T : IHKJson> {

    fun arrayCreator(): (Int) -> Array<T>
}