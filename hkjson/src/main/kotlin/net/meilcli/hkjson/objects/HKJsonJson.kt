package net.meilcli.hkjson.objects

class HKJsonJson {
    companion object {
        val optional = HKJsonOptionalJson.Companion
        val array = HKJsonArrayJson.Companion
        val custom = HKJsonCustomJson.Companion
    }
}

class HKJsonOptionalJson {
    companion object
}

class HKJsonArrayJson {
    companion object {
        val optional = HKJsonArrayOptionalJson.Companion
    }
}

class HKJsonArrayOptionalJson {
    companion object
}

class HKJsonCustomJson {
    companion object {
        val optional = HKJsonCustomOptionalJson.Companion
    }
}

class HKJsonCustomOptionalJson {
    companion object
}