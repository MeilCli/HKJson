package net.meilcli.hkjson

interface IJsonObject<T : IHKJson> {

    fun creator(): () -> T
}