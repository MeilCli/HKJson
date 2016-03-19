# HKJson
A Json library for Android 4.0.3 and upper in Kotlin  
This library is helper of JSONObject and JSONArray

[日本語解説](http://meilcli.github.io/product/hkjson.html)

#### gradle
	repositories {
	    mavenCentral()
	    maven { url "http://dl.bintray.com/meilcli/maven" }
	}
	
	dependencies {
		compile 'meilcli:hkjson:1.1.2'
	}

#### Usage
	import net.meilcli.hkjson.HKJson
	import net.meilcli.hkjson.IJson
	import net.meilcli.hkjson.IJsonArray
	import net.meilcli.hkjson.objects.StringJson
	import org.json.JSONObject

	class Data(json:JSONObject? =null) : IJson by HKJson(json){

    	val testStringVal:String by StringJson.json("test_string_val")
    	var testStringVar by StringJson.json("test_string_var") // type is omitted
    	val testOptionalStringVal: String? by StringJson.jsonOptional("test_optional_string_val")
    	var testOptionalStringVar by StringJson.jsonOptional("test_optional_string_var")

	}
	

HKJson can map type: *String*, *Boolean*, *Int*, *Long*, *Double*, *Date*, *T : IJson*  
ok *val*, *var*, *Optional*, *Array*, *ArrayOptional*  
other type is OK to use custom method  
[for example](https://github.com/MeilCli/HKJson/tree/master/library/src/androidTest/kotlin/com/twitter/meil_mitu/hkjson/example)  
  
to Object :  

	parseJson(JSONObject)
	
get JSONObject :   

	makeJson()
	


#### License

This source is The MIT License.

using [The Kotlin Standard Library][Kotlin_stdlib] [Apache License, Version 2.0][Apache]
[Apache]: http://www.apache.org/licenses/LICENSE-2.0
[Kotlin_stdlib]: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
