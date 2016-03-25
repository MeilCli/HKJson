package net.meilcli.hkjson.objects

class DoubleJson {
    companion object {
        val optional = DoubleOptionalJson.Companion
        val array = DoubleArrayJson.Companion
    }
}

class DoubleOptionalJson {
    companion object
}

class DoubleArrayJson {
    companion object {
        val optional = DoubleArrayOptionalJson.Companion
    }
}

class DoubleArrayOptionalJson {
    companion object
}