# HKJson
A Json library for Android 4.0.3 and upper in Kotlin  
This library is helper of JSONObject and JSONArray

#### gradle
	repositories {
	    mavenCentral()
	    maven { url "https://raw.github.com/MeilCli/HKJson/master/library/repository" }
	}
	
	dependencies {
		compile 'meilcli:hkjson:1.0.0'
	}

#### Usage
	import com.twitter.meil_mitu.hkjson.HKJson
	import com.twitter.meil_mitu.hkjson.IJson
	import com.twitter.meil_mitu.hkjson.IJsonArray
	import org.json.JSONObject
	
	class Data : IJson {
	
		override val hkjson = HKJson()
	
		val stringVal: String by jsonString("[key]")
		var stringVar: String by jsonString("[key]")
		val optionalStringVal: String? by jsonOptionalString("[key]")
		var optionalStringVar: String? by jsonOptionalString("[key]")
	
		constructor(json: JSONObject) {
			hkjson.parse(json)
		}
	}
	

HKJson can map type: *String*, *Array\<String\>*, *Boolean*, *BooleanArray*, *Int*, *IntArray*, *Long*, *LongArray*, *Double*, *DoubleArray*, *Date*, *Array\<Date\>*, *T : IJson*, *Array\<T : IJson\>*  
other type is OK to use custom method  
[for example](https://github.com/MeilCli/HKJson/tree/master/library/src/androidTest/kotlin/com/twitter/meil_mitu/hkjson/example)  
  
to Object :  

	hkjson.parse(JSONObject)
	
get JSONObject :   

	hkjson.make()
	


License
----------

This source is The MIT License.

using [The Kotlin Standard Library][Kotlin_stdlib] [Apache License, Version 2.0][Apache]
[Apache]: http://www.apache.org/licenses/LICENSE-2.0
[Kotlin_stdlib]: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
