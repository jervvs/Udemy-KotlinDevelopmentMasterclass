package com.example.helloworld

fun main(){
    // 1. val vs var: val is immutatable => cannot change during runtime
    val myName = "Jervis"
    print("Hello "+ myName)

    // Can specify data types with the colon. You might want to specify for speed or mem allocation
    // Integer TYPES: Byte (8 bit), Short (16 bit), Int (32 bit), Long (64 bit)
    val myByte: Byte = 13
    val myShort: Short = 125
    val myInt: Int = 123123123
    val myLong: Long = 12_039_812_309_487_120

    // Floating Point number Types: Float (32 bit), Double (64 bit)
    val myFloat: Float = 13.37F
    val myDouble: Double = 3.14159265358979323846

    // Booleans the type Boolean is used to represent logical values.
    // It can have two possible values true and false.
    var isSunny: Boolean = true
    // not sunny anymore...
    isSunny = false

    //Note double quotation for string and single for characters
    // Characters
    val letterChar = 'A'
    val digitChar = '1'

    // Strings
    val myStr = "Hello World"
    var firCharInStr = myStr[0]
    var lastCharInStr = myStr[myStr.length - 1]

    // Note Type Mismatch when dividing float with int to get an int variable
    // Use of $ to print formatted strings
    // Use of {} to perform operations => String Interpolation

    var result = 5+3
    result = result / 2
    // alternatively
    // result /= 2
    result = result * 5
    result = result - 1
    var moduloResult = 5%2
    println( moduloResult)

    //Comparison operators (==, !=, <, >, <=, >=)
    val isEqual = 5==3
    // Concatenation - adding of "Strings"
    println("isEqual is " + isEqual)
    val isNotEqual = 5!=5
    // Kotlin has a feature called String Interpolation.
    // This feature allows you to directly insert a template expression inside a String.
    // Template expressions are tiny pieces of code that are evaluated and
    // their results are concatenated with the original String.
    // A template expression is prefixed with $ symbol.
    // Following are examples of String interpolation
    println("isNotEqual is $isNotEqual")

    println("is5Greater3 ${5 > 3}")
    println("is5LowerEqual3 ${5 >= 3}")
    println("is5LowerEqual5 ${5 >= 5}")

    //Assignment operators (+=, -=, *=, /=, %=)
    var myNum = 5
    myNum += 3
    println("myNum is $myNum")
    myNum *= 4
    println("myNum is $myNum")


    //Increment & Decrement operators (++, --)
    myNum++
    println("myNum is $myNum")
    // increments after use
    println("myNum is ${myNum++}")
    // increments before use
    println("myNum is ${++myNum}")
    println("myNum is ${--myNum}")

    // When => Replacement of switch
    var season = 3
    when(season){
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            // Can be multiline
            println("Fall")
            print("Autumn")
        }
        4 -> println("Winter")
        // Default case
        else -> println("Invalid season")
    }

    // Can have range of values using 'in' or commas
    var month = 3
    when(month){
        in 3..5 -> println("Spring")
        12, 1, 2 -> println("Winter")
        !in 1..20 -> println("Invalid month")
        else -> println("Invalid month")
    }

    // Any Data Type and can use 'is' keyword
    var x : Any = 13.37
    when(x){
        is Int -> println("$x is an Int")
        else -> println("$x is not an Int")
    }


    // For loop
    for (num in 1..10){
        print("$num")
    }

    for (num in 1 until 10 step 2){ // Same as for (num in 1.until(10))
        print("$num")
    }
    // Also have downTo

    // Nullables
    var name : String = "Denis"
    //name = null -> Compilation ERROR
    var nullableName : String? = "Denis"
    // nullableName = null

    // ? Safe call operator
    var len = name.length
    var len2 = nullableName?.length // Can get length if not null else len is null
    // let to only do if not null
    nullableName?.let{
        println(it.length)
    }

    // ?: Elvis Operator => Will return a default value if null
    val name2 = nullableName ?: "Guest"

    // !! Not null operator, converts any value to a non-null type and throws an exception if the value is null
    // Will get Null Pointer exception is the variable is actually null

    // Collections
    // 1. List
    val listWithNulls: List<String?> = listOf("Kotlin", null)
    for (item in listWithNulls){
        item?.let{ println(it)}
    }

}

// Defining function with parameters
fun addUp(a: Int, b: Int) : Int{
    return a+b
}




