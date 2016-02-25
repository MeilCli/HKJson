package com.twitter.meil_mitu.hkjson

import com.twitter.meil_mitu.hkjson.properties.JsonProperty
import com.twitter.meil_mitu.hkjson.properties.OptionalJsonProperty
import org.json.JSONObject
import java.util.*

interface IJson {

    val hkjson: HKJson

    fun parseJson(json :JSONObject){
        hkjson.parse(json)
    }

    fun makeJson() = hkjson.make()

    /*
    * String
    * */
    fun jsonString(key: String): JsonProperty<String> {
        return hkjson.jsonString(key)
    }

    fun jsonOptionalString(key: String): OptionalJsonProperty<String> {
        return hkjson.jsonOptionalString(key)
    }

    /*
    * StringArray
    * */
    fun jsonStringArray(key: String): JsonProperty<Array<String>> {
        return hkjson.jsonStringArray(key)
    }

    fun jsonOptionalStringArray(key: String): OptionalJsonProperty<Array<String>> {
        return hkjson.jsonOptionalStringArray(key)
    }

    /*
    * Boolean
    * */
    fun jsonBoolean(key: String): JsonProperty<Boolean> {
        return hkjson.jsonBoolean(key)
    }

    fun jsonOptionalBoolean(key: String): OptionalJsonProperty<Boolean> {
        return hkjson.jsonOptionalBoolean(key)
    }

    /*
    * BooleanArray
    * */
    fun jsonBooleanArray(key: String): JsonProperty<BooleanArray> {
        return hkjson.jsonBooleanArray(key)
    }

    fun jsonOptionalBooleanArray(key: String): OptionalJsonProperty<BooleanArray> {
        return hkjson.jsonOptionalBooleanArray(key)
    }

    /*
    * Int
    * */
    fun jsonInt(key: String): JsonProperty<Int> {
        return hkjson.jsonInt(key)
    }

    fun jsonOptionalInt(key: String): OptionalJsonProperty<Int> {
        return hkjson.jsonOptionalInt(key)
    }

    /*
    * IntArray
    * */
    fun jsonIntArray(key: String): JsonProperty<IntArray> {
        return hkjson.jsonIntArray(key)
    }

    fun jsonOptionalIntArray(key: String): OptionalJsonProperty<IntArray> {
        return hkjson.jsonOptionalIntArray(key)
    }

    /*
    * Long
    * */
    fun jsonLong(key: String): JsonProperty<Long> {
        return hkjson.jsonLong(key)
    }

    fun jsonOptionalLong(key: String): OptionalJsonProperty<Long> {
        return hkjson.jsonOptionalLong(key)
    }

    /*
    * LongArray
    * */
    fun jsonLongArray(key: String): JsonProperty<LongArray> {
        return hkjson.jsonLongArray(key)
    }

    fun jsonOptionalLongArray(key: String): OptionalJsonProperty<LongArray> {
        return hkjson.jsonOptionalLongArray(key)
    }

    /*
    * Double
    * */
    fun jsonDouble(key: String): JsonProperty<Double> {
        return hkjson.jsonDouble(key)
    }

    fun jsonOptionalDouble(key: String): OptionalJsonProperty<Double> {
        return hkjson.jsonOptionalDouble(key)
    }

    /*
    * DoubleArray
    * */
    fun jsonDoubleArray(key: String): JsonProperty<DoubleArray> {
        return hkjson.jsonDoubleArray(key)
    }

    fun jsonOptionalDoubleArray(key: String): OptionalJsonProperty<DoubleArray> {
        return hkjson.jsonOptionalDoubleArray(key)
    }

    /*
    * Date
    * */
    fun jsonDate(key: String): JsonProperty<Date> {
        return hkjson.jsonDate(key)
    }

    fun jsonOptionalDate(key: String): OptionalJsonProperty<Date> {
        return hkjson.jsonOptionalDate(key)
    }

    /*
    * DateArray
    * */
    fun jsonDateArray(key: String): JsonProperty<Array<Date>> {
        return hkjson.jsonDateArray(key)
    }

    fun jsonOptionalDateArray(key: String): OptionalJsonProperty<Array<Date>> {
        return hkjson.jsonOptionalDateArray(key)
    }

    /*
    * JsonObject
    * */
    fun<T : IJson> jsonObject(key: String, creator: () -> T):
            JsonProperty<T> {
        return hkjson.jsonObject(key, creator)
    }

    fun<T : IJson> IJsonObject<T>.jsonObject(key: String):
            JsonProperty<T> {
        return hkjson.jsonObject(key, this.creator())
    }

    fun<T : IJson> jsonOptionalObject(key: String, creator: () -> T):
            OptionalJsonProperty<T> {
        return hkjson.jsonOptionalObject(key, creator)
    }

    fun<T : IJson> IJsonObject<T>.jsonOptionalObject(key: String):
            OptionalJsonProperty<T> {
        return hkjson.jsonOptionalObject(key, this.creator())
    }

    /*
    * JsonArray
    * */
    fun<T : IJson> jsonArray(
            key: String, creator: (Int) -> Array<T>):
            JsonProperty<Array<T>> {
        return hkjson.jsonArray(key, creator)
    }

    fun<T : IJson> IJsonArray<T>.jsonArray(key: String):
            JsonProperty<Array<T>> {
        return hkjson.jsonArray(key, this.arrayCreator())
    }

    fun<T : IJson> jsonOptionalArray(
            key: String, creator: (Int) -> Array<T>):
            OptionalJsonProperty<Array<T>> {
        return hkjson.jsonOptionalArray(key, creator)
    }

    fun<T : IJson> IJsonArray<T>.jsonOptionalArray(key: String):
            OptionalJsonProperty<Array<T>> {
        return hkjson.jsonOptionalArray(key, this.arrayCreator())
    }

    /*
    * Custom
    * */
    fun<T> jsonCustom(key: String,
                      initter: (JSONObject, String) -> T,
                      putter: (JSONObject, String, T) -> Unit): JsonProperty<T> {
        return hkjson.jsonCustom(key, initter, putter)
    }

    fun<T> jsonOptionalCustom(key: String,
                              initter: (JSONObject, String) -> T?,
                              putter: (JSONObject, String, T?) -> Unit):
            OptionalJsonProperty<T> {
        return hkjson.jsonOptionalCustom(key, initter, putter)
    }

}