package com.example.helloworld

import java.lang.IllegalArgumentException

fun main(){
    var Jervis = Person("Jervis", "Chan", 12, "read manga")
    var person = Person(lastName = "Not Default")

    // Using properties
    Jervis.hobby = "to read manga"
    Jervis.age = 24
    Jervis.stateHobby()

    // Car exercise
//    var myCar = Car()
//    myCar.maxSpeed = 100
//    println("Max speed is ${myCar.maxSpeed}")
}

class Person(firstName: String = "Default", lastName: String = "Value"){
    // Member Variables - Properties
    var firstName = firstName
    var lastName = lastName
    var age: Int? = null
    var hobby: String = "watch Netflix"

    init {
        println("Person created")
    }

    // Member secondary constructor - for more attributes that aren't required
    constructor(firstName: String, lastName: String, age: Int, hobby: String): this(firstName, lastName){
        this.age = age
        this.hobby = hobby
        println("Secondary constructor")
    }

    // Member functions - Methods
    fun stateHobby(){
        println("$firstName hobby is $hobby")
    }
}

/*
class Car(){
    // lateinit keyword allows you to avoid initializing a property when an object is constructed. Can't be null.
    lateinit var owner: String

    //Custom getter and setter
    val myBrand: String = "BMW"
        get(){
            return field.lowercase()
        }

    var maxSpeed: Int = 250
        // get() = field
        set(value){
            if (value > 0){
                field = value
            } else throw IllegalArgumentException("Max speed cannot be less than 0.")
        }

    var myModel: String = "M5"
        private set // Cqn only change in the same class, like in init

    init {
        this.owner = "Jervis"
    }
}
 */

// Data Class - Must at least have one parameter
// Has an underlying to string method
// Copy function => .copy() Can add arguments that you want to change
// Can get component => component1 is id
data class User (val id: Long, val name: String)
