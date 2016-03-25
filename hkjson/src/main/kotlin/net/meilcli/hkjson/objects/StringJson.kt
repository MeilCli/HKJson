package net.meilcli.hkjson.objects

class StringJson {
    companion object {
        val optional = StringOptionalJson.Companion
        val array = StringArrayJson.Companion
    }
}

class StringOptionalJson {
    companion object
}

class StringArrayJson {
    companion object {
        val optional = StringArrayOptionalJson
    }
}

class StringArrayOptionalJson {
    companion object
}