package com.twitter.meil_mitu.hkjson

import com.twitter.meil_mitu.kjson.StringData
import junit.framework.TestCase
import org.json.JSONArray
import org.json.JSONObject

class DataTest : TestCase() {

    fun testString() {
        val testStringVal1 = "v1"
        val testStringVar1 = "a1"
        val testStringVar2 = "a2"

        // json parse test
        val a = StringData()
        val json = JSONObject().apply {
            this.put(a.testStringValKey, testStringVal1)
            this.put(a.testStringVarKey, testStringVar1)
            this.put(a.testOptionalStringValKey, testStringVal1)
            this.put(a.testOptionalStringVarKey, testStringVar1)
        }
        a.hkjson.parse(json)
        assertEquals(a.testStringVal, testStringVal1)
        assertEquals(a.testStringVar, testStringVar1)
        assertEquals(a.testOptionalStringVal, testStringVal1)
        assertEquals(a.testOptionalStringVar, testStringVar1)

        // json make test
        val b = StringData(a.hkjson.make())
        assertEquals(b.testStringVal, testStringVal1)
        assertEquals(b.testStringVar, testStringVar1)
        assertEquals(b.testOptionalStringVal, testStringVal1)
        assertEquals(b.testOptionalStringVar, testStringVar1)

        // value change test
        b.testStringVar = testStringVar2
        b.testOptionalStringVar = testStringVar2
        val c = StringData(b.hkjson.make())
        assertEquals(c.testStringVal, testStringVal1)
        assertEquals(c.testStringVar, testStringVar2)
        assertEquals(c.testOptionalStringVal, testStringVal1)
        assertEquals(c.testOptionalStringVar, testStringVar2)

        // null value test
        val d = StringData(c.hkjson.make().apply {
            this.remove(c.testOptionalStringValKey)
            this.remove(c.testOptionalStringVarKey)
        })
        assertEquals(d.testOptionalStringVal, null)
        assertEquals(d.testOptionalStringVar, null)
        assertEquals(
                d.hkjson.make().let {
                    it.isNull(d.testOptionalStringValKey) && it.isNull(d.testOptionalStringVarKey)
                },
                true)
    }

    fun testJsonObject() {
        val testStringVal1 = "v1"
        val testStringVar1 = "a1"
        val testStringVar2 = "a2"

        // json parse test
        val stringData = StringData()
        val jsonObjectData1 = JsonObjectData()
        val json = JSONObject().apply {
            this.put(jsonObjectData1.testJsonObjectVarKey, JSONObject().apply {
                this.put(stringData.testStringValKey, testStringVal1)
                this.put(stringData.testStringVarKey, testStringVar1)
                this.put(stringData.testOptionalStringValKey, testStringVal1)
                this.put(stringData.testOptionalStringVarKey, testStringVar1)
            })
        }
        jsonObjectData1.hkjson.parse(json)
        assertEquals(jsonObjectData1.testJsonObjectVar.testStringVal, testStringVal1)
        assertEquals(jsonObjectData1.testJsonObjectVar.testStringVar, testStringVar1)
        assertEquals(jsonObjectData1.testJsonObjectVar.testOptionalStringVal, testStringVal1)
        assertEquals(jsonObjectData1.testJsonObjectVar.testOptionalStringVar, testStringVar1)

        // json make test
        val jsonObjectData2 = JsonObjectData(jsonObjectData1.hkjson.make())
        assertEquals(jsonObjectData2.testJsonObjectVar.testStringVal, testStringVal1)
        assertEquals(jsonObjectData2.testJsonObjectVar.testStringVar, testStringVar1)
        assertEquals(jsonObjectData2.testJsonObjectVar.testOptionalStringVal, testStringVal1)
        assertEquals(jsonObjectData2.testJsonObjectVar.testOptionalStringVar, testStringVar1)

        // value change test
        jsonObjectData2.testJsonObjectVar.testStringVar = testStringVar2
        jsonObjectData2.testJsonObjectVar.testOptionalStringVar = testStringVar2
        val jsonObjectData3 = JsonObjectData(jsonObjectData2.hkjson.make())
        assertEquals(jsonObjectData3.testJsonObjectVar.testStringVal, testStringVal1)
        assertEquals(jsonObjectData3.testJsonObjectVar.testStringVar, testStringVar2)
        assertEquals(jsonObjectData3.testJsonObjectVar.testOptionalStringVal, testStringVal1)
        assertEquals(jsonObjectData3.testJsonObjectVar.testOptionalStringVar, testStringVar2)
    }

    fun testJsonArray() {
        val testStringVal1 = "v1"
        val testStringVar1 = "a1"
        val testStringVar2 = "a2"

        // json parse test
        val stringData = StringData()
        val jsonArrayData1 = JsonArrayData()
        val json = JSONObject().apply {
            this.put(jsonArrayData1.testJsonArrayVarKey, JSONArray().apply {
                this.put(0, JSONObject().apply {
                    this.put(stringData.testStringValKey, testStringVal1)
                    this.put(stringData.testStringVarKey, testStringVar1)
                    this.put(stringData.testOptionalStringValKey, testStringVal1)
                    this.put(stringData.testOptionalStringVarKey, testStringVar1)
                })
                this.put(1, JSONObject().apply {
                    this.put(stringData.testStringValKey, testStringVal1)
                    this.put(stringData.testStringVarKey, testStringVar2)
                    this.put(stringData.testOptionalStringValKey, testStringVal1)
                    this.put(stringData.testOptionalStringVarKey, testStringVar2)
                })
            })
        }
        jsonArrayData1.hkjson.parse(json)
        assertEquals(jsonArrayData1.testJsonArrayVar[0].testStringVal, testStringVal1)
        assertEquals(jsonArrayData1.testJsonArrayVar[0].testStringVar, testStringVar1)
        assertEquals(jsonArrayData1.testJsonArrayVar[0].testOptionalStringVal, testStringVal1)
        assertEquals(jsonArrayData1.testJsonArrayVar[0].testOptionalStringVar, testStringVar1)
        assertEquals(jsonArrayData1.testJsonArrayVar[1].testStringVal, testStringVal1)
        assertEquals(jsonArrayData1.testJsonArrayVar[1].testStringVar, testStringVar2)
        assertEquals(jsonArrayData1.testJsonArrayVar[1].testOptionalStringVal, testStringVal1)
        assertEquals(jsonArrayData1.testJsonArrayVar[1].testOptionalStringVar, testStringVar2)

        // json make test
        val jsonArrayData2 = JsonArrayData(jsonArrayData1.hkjson.make())
        assertEquals(jsonArrayData2.testJsonArrayVar[0].testStringVal, testStringVal1)
        assertEquals(jsonArrayData2.testJsonArrayVar[0].testStringVar, testStringVar1)
        assertEquals(jsonArrayData2.testJsonArrayVar[0].testOptionalStringVal, testStringVal1)
        assertEquals(jsonArrayData2.testJsonArrayVar[0].testOptionalStringVar, testStringVar1)
        assertEquals(jsonArrayData2.testJsonArrayVar[1].testStringVal, testStringVal1)
        assertEquals(jsonArrayData2.testJsonArrayVar[1].testStringVar, testStringVar2)
        assertEquals(jsonArrayData2.testJsonArrayVar[1].testOptionalStringVal, testStringVal1)
        assertEquals(jsonArrayData2.testJsonArrayVar[1].testOptionalStringVar, testStringVar2)
    }
}