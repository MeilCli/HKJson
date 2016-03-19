package net.meilcli.hkjson

interface IJsonObject<T : IJson> {

    fun creator(): () -> T
}