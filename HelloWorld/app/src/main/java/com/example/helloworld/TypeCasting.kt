package com.example.helloworld

fun main(){
    val stringList: List<String> = listOf("Denis", "Frank")

    val mixedTypeList: List<Any> = listOf("Jervis", 90)

    for (value in mixedTypeList){
        if (value is Int){
            println("Integer: '$value'")
        }
        else{
            println("Unknown value")
        }
    }

    // Smart Cast
    val obj1: Any = "I have a dream"

    if (obj1 !is String){
        println("Not a string")
    } else {
        println("String length is ${obj1.length}")
    }

    // Explicit (unsafe) casting with "as" keyword - forcing casting
    val str1: String = obj1 as String
    println(str1.length)

//    val obj2: Any = 12
//    val str2: String = obj2 as String
//    println(str2)

    // Explicit (safe) casting using as? keyword
    // Need to be of a nullable data type in case it is not the data type you want
    val obj3: Any = 12
    val str3: String? = obj3 as? String
    println(str3)

}