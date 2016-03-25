package net.meilcli.hkjson.properties

import net.meilcli.hkjson.IHKJson
import org.json.JSONException
import org.json.JSONObject
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class JsonProperty<T>(
        key: String,
        val initter: (JSONObject, String) -> T,
        val putter: (JSONObject, String, T) -> Unit) :
        ReadWriteProperty<IHKJson, T>, ReadOnlyProperty<IHKJson, T>, IProperty<T> {

    override val key: String
    override var value: T? = null

    init {
        this.key = key
    }

    override fun init(json: JSONObject) {
        if (json.isNull(key)) {
            if (value == null) {
                throw JSONException("null key : $key")
            }
        } else {
            value = initter(json, key)
        }
    }

    override fun put(json: JSONObject) {
        require(value != null) { "put value is must init json key:$key" }
        putter(json, key, value!!)
    }

    override fun getValue(thisRef: IHKJson, property: KProperty<*>): T {
        require(value != null) { "get value is must init json key:$key" }
        return this.value!!
    }

    override fun setValue(thisRef: IHKJson, property: KProperty<*>, value: T) {
        this.value = value
    }

}