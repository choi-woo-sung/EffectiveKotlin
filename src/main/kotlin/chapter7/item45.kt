package chapter7


fun main() {
    matchString()
    matchInt()
    notMatchInt()
}

fun notMatchInt() {
    val i1 : Int? = 1234
    val i2 : Int? = 1234

    println(i1 == i2)
    println(i1 === i2)
}

fun matchInt() {
    val i1 : Int? = 1
    val i2 : Int? = 1

    println(i1 == i2)
    println(i1 === i2)
}

fun matchString() {
    val str1 = "로렘 이즈 파스타"
    val str2 = "로렘 이즈 파스타"

    println(str1 == str2)
    println(str1 === str2)
}


