package baekjoon.gold.five

import baekjoon.common.inputLines

fun tomato () {
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
        tomatoQueue = move(M,N,tomatoQueue,tomatoMap)
        answer++
    }
    if (tomatoMap.flatten().contains(0)) {
        println(-1)
    } else {
        println(answer)
    }
}


fun move (M:Int, N:Int, positions: List<Pair<Int,Int>>, doubleList: MutableList<MutableList<Int>>): MutableList<Pair<Int,Int>> {
    val tempQueue = mutableListOf<Pair<Int,Int>>()
    positions.forEach { position ->
        listOf(Pair(1,0),Pair(0,1),Pair(-1,0),Pair(0,-1)).forEach { (rowTemp,colTemp) ->
            val newRow = position.first+rowTemp
            val newCol = position.second+colTemp
            if (-1<newRow && newRow<N && -1<newCol && newCol<M && doubleList[newRow][newCol] == 0) {
                doubleList[newRow][newCol] = 1
                tempQueue.add(newRow to newCol)
            }
        }
    }
    return tempQueue
}

fun main () {
    tomato()
}