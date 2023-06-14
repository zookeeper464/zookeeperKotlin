package baekjoon.gold.five

import baekjoon.common.inputLines
import baekjoon.common.moveDoubleList

fun tomato (): Int {
    var answer = -1
    val (M, N) = readln().split(" ").map { it.toInt() }
    val tomatoMap = inputLines(N).map { it.split(" ").map { it.toInt() }.toMutableList() }.toMutableList()
    var tomatoQueue = mutableListOf<Pair<Int,Int>>()
    tomatoMap.forEachIndexed { rowIndex,rows ->
        rows.forEachIndexed { colIndex, cols ->
            if (cols == 1) {
                tomatoQueue.add(rowIndex to colIndex)
            }
        }
    }
    while (tomatoQueue.isNotEmpty()) {
        tomatoQueue = moveDoubleList(M,N,tomatoQueue,tomatoMap)
        answer++
    }
    return if (tomatoMap.flatten().contains(0)) -1 else answer
}

fun main () {
    println(tomato())
}