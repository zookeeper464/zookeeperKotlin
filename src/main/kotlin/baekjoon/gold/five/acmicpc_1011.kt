package baekjoon.gold.five

import kotlin.math.floor
import kotlin.math.sqrt

fun moveASNA (): String {
    val t = readln().toInt()
    return Array(t) {
        val temp = readln().split(" ").map { it.toInt() }
        calculatorDistance(temp.last().toInt() - temp.first().toInt())
    }.joinToString("\n")
}

fun calculatorDistance (distance: Int): String {
    val number = floor(sqrt(distance.toDouble())).toInt()
    val distanceAble = number*number
    return when {
        distance == distanceAble -> "${2*number-1}"
        distance <= distanceAble+number -> "${2*number}"
        else -> "${2*number+1}"
    }
}

fun main () {
    println(moveASNA())
}