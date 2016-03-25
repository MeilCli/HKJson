package net.meilcli.hkjson

interface IJsonOptionalObject <T : IHKJson> {

    fun creator(): () -> T
}