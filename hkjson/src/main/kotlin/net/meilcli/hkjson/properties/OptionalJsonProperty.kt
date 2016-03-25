package net.meilcli.hkjson.properties

import net.meilcli.hkjson.IHKJson
import org.json.JSONObject
import kotlin.reflect.KProperty

class OptionalJsonProperty<T>(
        key: String,
        initter: (JSONObject, String) -> T?,
        putter: (JSONObject, String, T?) -> Unit) :
        JsonProperty<T?>(key, initter, putter) {

    override fun init(json: JSONObject) {
        value = initter(json, key)
    }

    override fun put(json: JSONObject) {
        putter(json, key, value)
    }

    override fun getValue(thisRef: IHKJson, property: KProperty<*>): T? {
        return this.value
    }
}