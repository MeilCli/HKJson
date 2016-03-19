package net.meilcli.hkjson.properties

import net.meilcli.hkjson.IJson
import org.json.JSONObject
import kotlin.reflect.KProperty

class OptionalJsonProperty<T>(
        key: String,
        initter: (JSONObject, String) -> T?,
        putter: (JSONObject, String, T?) -> Unit) :
        JsonProperty<T?>(key, initter, putter) {

    override fun put(json: JSONObject) {
        putter(json, key, t)
    }

    override fun getValue(thisRef: IJson, property: KProperty<*>): T? {
        return this.t
    }
}