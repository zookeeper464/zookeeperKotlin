package baekjoon.gold.five

import kotlin.math.max

fun calculateValue(): Int {
    val (N,K) = readln().split(" ").map { it.toInt() }
    val dpList = MutableList(K+1) { 0 }
    val bags = List(N) { readln().split(" ") }.map { it.first().toInt() to it.last().toInt() }

    (0 until N).forEach { bagsIndex ->
        (K.downTo(1)).forEach { weight ->
            if (weight-bags[bagsIndex].first >= 0) {
                dpList[weight] =  max(dpList[weight],dpList[weight-bags[bagsIndex].first]+bags[bagsIndex].second)
            }
        }
    }
    return dpList.max()
}


fun main () {
    println(calculateValue())
}