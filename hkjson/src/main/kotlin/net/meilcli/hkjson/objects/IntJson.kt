package net.meilcli.hkjson.objects

class IntJson {
    companion object {
        val optional = IntOptionalJson.Companion
        val array = IntArrayJson.Companion
    }
}

class IntOptionalJson {
    companion object
}

class IntArrayJson {
    companion object {
        val optional = IntArrayOptionalJson.Companion
    }
}

class IntArrayOptionalJson {
    companion object
}