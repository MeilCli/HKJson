package net.meilcli.hkjson.objects

class DateJson {
    companion object {
        val optional = DateOptionalJson.Companion
        val array = DateArrayJson.Companion
    }
}

class DateOptionalJson {
    companion object
}

class DateArrayJson {
    companion object {
        val optional = DateArrayOptionalJson.Companion
    }
}

class DateArrayOptionalJson {
    companion object
}