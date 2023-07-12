package baekjoon.gold.five

import baekjoon.common.moveTripleList

fun tomatoBox (): Int {
    val numbers = readln().split(" ")
    val M = numbers[0].toInt()
    val N = numbers[1].toInt()
    val H = numbers[2].toInt()
    val tomatoBox = MutableList(H) {
        MutableList(N) {
            readln().split(" ").map { it.toInt() }.toMutableList()
        }
    }
    var positions = mutableListOf<Triple<Int,Int,Int>>().apply {
        tomatoBox.forEachIndexed { hei,doubleList ->
            doubleList.forEachIndexed { col, list ->
                list.forEachIndexed { row, value ->
                    if (value == 1) {
                        add(Triple(hei,col,row))
                    }
                }
            }
        }
    }
    var answer = -1
    while (positions.isNotEmpty()) {
        positions = moveTripleList(M,N,H,positions,tomatoBox)
        answer++
    }
    return if (tomatoBox.flatten().flatten().contains(0)) -1 else answer
}

fun main () {
    println(tomatoBox())
}