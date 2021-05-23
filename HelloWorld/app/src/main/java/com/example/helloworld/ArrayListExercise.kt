package com.example.helloworld

fun main(){
    var arrayList: ArrayList<Double> =  ArrayList()
    for (i in 1..5){
        arrayList.add(i.toDouble())
    }
    var totalSum: Double = 0.0
    for (i in arrayList){
        totalSum += i
    }

    println("Average is ${totalSum/arrayList.size}")
}