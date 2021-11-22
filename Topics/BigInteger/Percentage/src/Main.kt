import java.math.BigInteger

fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()
    val sum = a + b

    val one = a * BigInteger("100") / sum
    val two = b * BigInteger("100") / sum
    println("$one% $two%")
}