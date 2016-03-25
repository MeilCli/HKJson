package net.meilcli.hkjson.objects

class LongJson {
    companion object {
        val optional = LongOptionalJson.Companion
        val array = LongArrayJson.Companion
    }
}

class LongOptionalJson {
    companion object
}

class LongArrayJson {
    companion object {
        val optional = LongArrayOptionalJson.Companion
    }
}

class LongArrayOptionalJson {
    companion object
}