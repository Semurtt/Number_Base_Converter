package converter

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

var source = ""
var target = ""
var number = ""
var result = ""
var fractional = ""
var fractionalResult = ""

fun main() {

    fin@ do {
        var quit = false
        val fin = "/exit"
        println("Enter two numbers in format: {source base} {target base} (To quit type /exit)")
        val list = readLine()!!.split(" ").toMutableList()

        if (list[0] == fin) {
            quit = true
            break@fin
        }
        source = list[0]
        target = list[1]

        end@ do {
            var back = false
            val end = "/back"
            println("Enter number in base $source to convert to base $target (To go back type /back)")
            number = readLine()!!

            when {
                number == end -> {
                    back = true
                    continue@end
                }

                number.contains(".") -> {
                    fractional = number.substringAfter('.')
                    number = number.substringBefore('.')
                    when {
                        target == "10" -> {
                            enyTo10()
                            fractionalEny10to()
                            result += ".$fractionalResult"
                        }
                        source == "10" -> {
                            from10toEny()
                            fractionalFrom10toEny()
                            result += ".$fractionalResult"
                        }
                        source != "10" && target != "10" -> {
                            val tempSource = source
                            enyTo10()
                            fractionalEny10to()
                            source = 10.toString()
                            number = result
                            fractional = fractionalResult
                            from10toEny()
                            fractionalFrom10toEny()
                            source = tempSource
                            result += ".$fractionalResult"
                        }
                    }

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
            println("Conversion result: $result")
            result = ""
            fractionalResult = ""
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
        temp /= target.toBigInteger()
    } while (temp.toInt() != 0)
    result = num.reversed()
    return result
}


fun enyTo10(): String {
    val n = source.toDouble()
    var m = 0.0
    var num = 0L
    var temp: Int
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
        num += temp * n.pow(m).toLong()
        m++
    }
    number = result
    result = num.toString()
    return result
}

fun fractionalFrom10toEny(): String {
    var temp = ""
    fractionalResult = ""
    fractional = "0.$fractional"
    do {
        fractional = "0.${fractional.substringAfter('.')}"
        fractional = (fractional.toDouble() * target.toInt()).toString()
        temp = when (fractional.substringBefore(".")) {
            "10" -> "a"
            "11" -> "b"
            "12" -> "c"
            "13" -> "d"
            "14" -> "e"
            "15" -> "f"
            "16" -> "g"
            "17" -> "h"
            "18" -> "i"
            "19" -> "j"
            "20" -> "k"
            "21" -> "l"
            "22" -> "m"
            "23" -> "n"
            "24" -> "o"
            "25" -> "p"
            "26" -> "q"
            "27" -> "r"
            "28" -> "s"
            "29" -> "t"
            "30" -> "u"
            "31" -> "v"
            "32" -> "w"
            "33" -> "x"
            "34" -> "y"
            "35" -> "z"
            else -> (fractional.substringBefore("."))
        }
        fractionalResult += temp
    } while (fractionalResult.length <= 4)
    return fractionalResult
}


fun fractionalEny10to(): String {
    var n = -1
    var temp = 0
    var tempFractional = 0.0
    var tempFracBig = BigDecimal.ZERO
    for (i in fractional) {
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
        tempFractional += temp * source.toDouble().pow(n)
        n--
    }
    tempFracBig = tempFractional.toBigDecimal().setScale(5, RoundingMode.HALF_UP)
    fractionalResult += tempFracBig.toString().substringAfter(".")
    return fractionalResult
}