package net.meilcli.hkjson.objects

class BooleanJson {
    companion object {
        val optional = BooleanOptionalJson.Companion
        val array = BooleanArrayJson.Companion
    }
}

class BooleanOptionalJson {
    companion object
}

class BooleanArrayJson {
    companion object {
        val optional = BooleanArrayOptionalJson.Companion
    }
}

class BooleanArrayOptionalJson {
    companion object
}