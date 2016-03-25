package net.meilcli.hkjson

import net.meilcli.hkjson.objects.*
import net.meilcli.hkjson.properties.JsonProperty
import net.meilcli.hkjson.properties.OptionalJsonProperty
import org.json.JSONObject
import java.util.*

interface IJson {

    companion object

    fun parseJson(json: JSONObject)

    fun makeJson(): JSONObject

    fun clearJsonCache()

    fun isValid(): Boolean

    /*
    * String
    * */

    fun StringJson.Companion.json(key: String): JsonProperty<String>
    fun StringJson.Companion.jsonOptional(key: String): OptionalJsonProperty<String>
    fun StringJson.Companion.jsonArray(key: String): JsonProperty<Array<String>>
    fun StringJson.Companion.jsonOptionalArray(key: String): OptionalJsonProperty<Array<String>>

    /*
    * Boolean
    * */

    fun BooleanJson.Companion.json(key: String): JsonProperty<Boolean>
    fun BooleanJson.Companion.jsonOptional(key: String): OptionalJsonProperty<Boolean>
    fun BooleanJson.Companion.jsonArray(key: String): JsonProperty<BooleanArray>
    fun BooleanJson.Companion.jsonOptionalArray(key: String): OptionalJsonProperty<BooleanArray>

    /*
    * Int
    * */

    fun IntJson.Companion.json(key: String): JsonProperty<Int>

    fun IntJson.Companion.jsonOptional(key: String): OptionalJsonProperty<Int>
    fun IntJson.Companion.jsonArray(key: String): JsonProperty<IntArray>
    fun IntJson.Companion.jsonOptionalArray(key: String): OptionalJsonProperty<IntArray>

    /*
    * Long
    * */

    fun LongJson.Companion.json(key: String): JsonProperty<Long>
    fun LongJson.Companion.jsonOptional(key: String): OptionalJsonProperty<Long>
    fun LongJson.Companion.jsonArray(key: String): JsonProperty<LongArray>
    fun LongJson.Companion.jsonOptionalArray(key: String): OptionalJsonProperty<LongArray>

    /*
    * Double
    * */

    fun DoubleJson.Companion.json(key: String): JsonProperty<Double>
    fun DoubleJson.Companion.jsonOptional(key: String): OptionalJsonProperty<Double>
    fun DoubleJson.Companion.jsonArray(key: String): JsonProperty<DoubleArray>
    fun DoubleJson.Companion.jsonOptionalArray(key: String): OptionalJsonProperty<DoubleArray>

    /*
    * Date
    * */

    fun DateJson.Companion.json(key: String): JsonProperty<Date>/**/
    fun DateJson.Companion.jsonOptional(key: String): OptionalJsonProperty<Date>
    fun DateJson.Companion.jsonArray(key: String): JsonProperty<Array<Date>>
    fun DateJson.Companion.jsonOptionalArray(key: String): OptionalJsonProperty<Array<Date>>

    /*
    * JsonObject
    * */

    fun<T : IJson> Json.Companion.json(key: String, creator: () -> T): JsonProperty<T>
    fun<T : IJson> Json.Companion.jsonOptional(key: String, creator: () -> T): OptionalJsonProperty<T>
    fun<T : IJson> Json.Companion.jsonArray(key: String, creator: (Int) -> Array<T>): JsonProperty<Array<T>>
    fun<T : IJson> Json.Companion.jsonOptionalArray(key: String, creator: (Int) -> Array<T>): OptionalJsonProperty<Array<T>>

    /*
    * Custom
    * */

    fun<T> Json.Companion.jsonCustom(key: String, initter: (JSONObject, String) -> T, putter: (JSONObject, String, T) -> Unit): JsonProperty<T>
    fun<T> Json.Companion.jsonOptionalCustom(key: String, initter: (JSONObject, String) -> T?, putter: (JSONObject, String, T?) -> Unit): OptionalJsonProperty<T>

    /*
    * Extensions
    * */
    fun<T : IJson> IJsonObject<T>.jsonObject(key: String): JsonProperty<T> {
        return Json.json(key, this.creator())
    }

    fun<T : IJson> IJsonObject<T>.jsonOptionalObject(key: String): OptionalJsonProperty<T> {
        return Json.jsonOptional(key, this.creator())
    }

    fun<T : IJson> IJsonArray<T>.jsonArray(key: String): JsonProperty<Array<T>> {
        return Json.jsonArray(key, this.arrayCreator())
    }

    fun<T : IJson> IJsonArray<T>.jsonOptionalArray(key: String): OptionalJsonProperty<Array<T>> {
        return Json.jsonOptionalArray(key, this.arrayCreator())
    }
}