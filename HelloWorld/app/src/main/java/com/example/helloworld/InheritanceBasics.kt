package com.example.helloworld


// Abstract Class
// Cannot be instantiated
// Members are non-abstract unless you explicitly use abstract keyword to make them abstract
// Can only implement one abstract class but can have multiple interface
// Interface doesn't have constructors and fields
abstract class Mammal(val name: String, val origin: String,
                      val weight: Double) {   // Concrete (Non Abstract) Properties

    // Abstract Property (Must be overridden by Subclasses)
    abstract var maxSpeed: Double

    // Abstract Methods (Must be implemented by Subclasses)
    abstract fun run()
    abstract fun breath()

    // Concrete (Non Abstract) Method
    fun displayDetails() {
        println("Name: $name, Origin: $origin, Weight: $weight, " +
                "Max Speed: $maxSpeed")
    }
}

class Human(name: String, origin: String, weight: Double,
            override var maxSpeed: Double): Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Runs on two legs")
    }

    override fun breath() {
        // Code to breath
        println("Breath through mouth or nose")
    }
}

class Elephant(name: String, origin: String, weight: Double,
               override var maxSpeed: Double): Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Runs on four legs")
    }

    override fun breath() {
        // Code to breath
        println("Breath through the trunk")
    }
}




//Interface
// If a class extends the interface, will need to implement
interface Drivable{
    val maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("The drivable is braking.")
    }
}


// Need open to override/inherit - for classes or functions or properties
open class Car(
    override val maxSpeed: Double,
    val name: String,
    val brand: String) : Drivable{

    open var range: Double = 0.0

    fun extendRange(amount: Double){
        if (amount > 0) range += amount
    }

    override fun drive(): String {
        return "driving the interface drive"
    }

    open fun drive(distance: Double){
        println("Drove for distance of $distance")
    }
}

class ElectricCar(maxSpeed: Double, name: String, brand: String, batteryLife: Double) : Car(maxSpeed, name, brand){
    var chargerType: String = "Type 1"
    override var range = batteryLife * 5
    override fun drive(distance: Double){
        println("Drove electic car for distance of $distance")
    }

    // Can have non-inherited method
    override fun drive() : String{
        return "Drove for distance of $range"
    }

    override fun brake(){
        super.brake()
        println("brake inside of electric car")
    }
}

// Any class inherits from Any Class
// Allows equals, hashCode and toString

fun main(){
    var myCar = Car(200.0,"A3", "Audi")
    var myECar = ElectricCar(200.0,"S-Model", "Tesla", batteryLife = 80.0)

    myECar.drive(100.1)

}