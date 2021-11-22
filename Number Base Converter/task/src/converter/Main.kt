package converter

import java.math.BigInteger
import kotlin.math.pow

var source = ""
var target = ""
var number = ""
var result = ""
//var big :BigInteger = BigInteger.ZERO

fun main() {

    fin@ do {
        var quit = false
        val fin = "/exit"
        println("Enter two numbers in format: {source base} {target base} (To quit type /exit)")
        //val (a, b) = readLine()!!.split(" ")
        //val (a, b) = readLine()!!.split(" ").map { it.toIntOrNull() }
        //val (a, b) = readLine()!!.map { it.toI() } // list of ints
        val list = readLine()!!.split(" ").toMutableList()

        if (list[0] == fin) {
            quit = true
            break@fin
        }
        source = list[0]
        target = list[1]


        //if (target == "10") enyTo10(); quit = true
        end@ do {
            var back = false
            val end = "/back"
            println("Enter number in base $source to convert to base $target (To go back type /back)")
            //number = readLine()!!.toString()
            number = readLine()!!

            when {
                number == end -> {
                    back = true
                    continue@end
                }
                target == "10" -> enyTo10()
                source == "10" -> from10toEny()
                source != "10" && target != "10" -> {
                    val tempSource = source
                    enyTo10()
                    source = 10.toString()
                    number = result
                    from10toEny()
                    source = tempSource
                }
            }
            //var big: BigInteger = result.toBigInteger()
            println("Conversion result: $result")
            println()
        } while (!back)

    } while (!quit)
}


fun from10toEny(): String {
    var hex: String
    var temp = number.toBigInteger()
    var num = ""
    result = ""

    do {
        hex = when (temp % target.toBigInteger()) {
            "10".toBigInteger() -> "a"
            "11".toBigInteger() -> "b"
            "12".toBigInteger() -> "c"
            "13".toBigInteger() -> "d"
            "14".toBigInteger() -> "e"
            "15".toBigInteger() -> "f"
            "16".toBigInteger() -> "g"
            "17".toBigInteger() -> "h"
            "18".toBigInteger() -> "i"
            "19".toBigInteger() -> "j"
            "20".toBigInteger() -> "k"
            "21".toBigInteger() -> "l"
            "22".toBigInteger() -> "m"
            "23".toBigInteger() -> "n"
            "24".toBigInteger() -> "o"
            "25".toBigInteger() -> "p"
            "26".toBigInteger() -> "q"
            "27".toBigInteger() -> "r"
            "28".toBigInteger() -> "s"
            "29".toBigInteger() -> "t"
            "30".toBigInteger() -> "u"
            "31".toBigInteger() -> "v"
            "32".toBigInteger() -> "w"
            "33".toBigInteger() -> "x"
            "34".toBigInteger() -> "y"
            "35".toBigInteger() -> "z"
            else -> (temp % target.toBigInteger()).toString()
        }
        num += hex
        println(num)
        temp /= target.toBigInteger()
    } while (temp.toInt() != 0)
    result = num.reversed()
    //var big: BigInteger = result.toBigInteger()
    return result
}


fun enyTo10(): String {
    val n = source.toDouble()
    var m = 0.0
    var num = BigInteger.ZERO
    var temp: Int
    //var big = number.toBigInteger()
    for (i in number.reversed()) {
        temp = when (i) {
            'a' -> 10
            'b' -> 11
            'c' -> 12
            'd' -> 13
            'e' -> 14
            'f' -> 15
            'g' -> 16
            'h' -> 17
            'i' -> 18
            'j' -> 19
            'k' -> 20
            'l' -> 21
            'm' -> 22
            'n' -> 23
            'o' -> 24
            'p' -> 25
            'q' -> 26
            'r' -> 27
            's' -> 28
            't' -> 29
            'u' -> 30
            'v' -> 31
            'w' -> 32
            'x' -> 33
            'y' -> 34
            'z' -> 35
            else -> i.digitToInt()
        }
        println("i=$i")
        num += (temp * n.pow(m).toInt()).toBigInteger()
        println((temp * n.pow(m)).toBigDecimal())
        println("num=$num")
        m++
        println("m=$m")
        //println(num)
    }
    number = result
    result = num.toString()
    //var big: BigInteger = result.toBigInteger()
    return result

}

/*

fun main() {
    var quit = false
    do {
        println("Do you want to convert /from decimal or /to decimal? (To quit type /exit)")
        when (readLine()!!.lowercase()) {
            "/from" -> from()
            "/to" -> to()
            "/exit" -> quit = true
        }
    } while (!quit)
}
*/
/*
fun to() {
    println("Enter source number:")
    val input = readLine()!!
    println("Enter source base:")
    when (readLine()!!.toInt()) {
        2 -> {
            val n = 2.0
            var m = 0.0
            var num = 0
            for (i in input.reversed()) {
                num += i.digitToInt() * n.pow(m).toInt()
                m++
            }
            println("Conversion to decimal result: $num")
        }
        8 -> {
            val n = 8.0
            var m = 0.0
            var num = 0
            for (i in input.reversed()) {
                num += i.digitToInt() * n.pow(m).toInt()
                m++
            }
            println("Conversion to decimal result: $num")
        }
        16 -> {
            val n = 16.0
            var m = 0.0
            var num = 0
            var temp: Int
            for (i in input.reversed()) {
                temp = when (i) {
                    'a' -> 10
                    'b' -> 11
                    'c' -> 12
                    'd' -> 13
                    'e' -> 14
                    'f' -> 15
                    else -> i.digitToInt()
                }
                num += temp * n.pow(m).toInt()
                m++
            }
            println("Conversion to decimal result: $num")

        }
    }
}

*/
/*

fun from() {
    println("Enter number in decimal system:")
    val input = readLine()!!.toInt()
    println("Enter target base:")
    val base = readLine()!!.toInt()
    var temp = input
    var result = ""

    when (base) {
        2 -> {
            do {
                result += temp % 2
                temp /= 2
            } while (temp != 0)
            println("Conversion result: ${result.reversed()}")
        }
        8 -> {
            do {
                result += temp % 8
                temp /= 8
            } while (temp != 0)
            println("Conversion result: ${result.reversed()}")

        }
        16 -> {
            var hex: String
            do {
                hex = when (temp % 16) {
                    10 -> "A"
                    11 -> "B"
                    12 -> "C"
                    13 -> "D"
                    14 -> "E"
                    15 -> "F"
                    else -> (temp % 16).toString()
                }
                result += hex
                temp /= 16
            } while (temp != 0)
            println("Conversion result: ${result.reversed()}")
            //println("Conversion result: ${input.toString(base)}")
        }
        else -> println(" Enter 2, 8 or 16")
    }

}

 */