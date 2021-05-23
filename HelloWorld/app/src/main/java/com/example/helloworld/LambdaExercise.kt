package com.example.helloworld

fun main(){
    // Example - Addition of two numbers
    val sum: (Int, Int) -> Int = {a: Int, b: Int -> a + b}
    println(sum(1,2))

    val sum2 = {a: Int, b: Int -> println(a+b)}
    sum2(1,2)

    // Lambda Useful for Events
}