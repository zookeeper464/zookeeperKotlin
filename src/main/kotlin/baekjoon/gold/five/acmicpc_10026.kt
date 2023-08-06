package baekjoon.gold.five

import baekjoon.common.searchDoubleList

fun compareProtanopiaAndNormal(): String {
    val N = readln().toInt()
    val rbgDoubleList = List(N) { readln().toList() }
    val protanopiaList = MutableList(N) { MutableList(N) { 0 } }
    val normalList = MutableList(N) { MutableList(N) { 0 } }
    var protanopiaResult = 0
    var normalResult = 0
    (0 until  N).forEach { row ->
        (0 until  N).forEach { col ->
            if (protanopiaList[row][col]  == 0) {
                val color = if ("RG".contains(rbgDoubleList[row][col])) "RG" else "B"
                searchDoubleList(color,row,col,N,N,protanopiaList,rbgDoubleList)
                protanopiaResult++
            }
            if (normalList[row][col]  == 0) {
                val color = rbgDoubleList[row][col].toString()
                searchDoubleList(color,row,col,N,N,normalList,rbgDoubleList)
                normalResult++
            }
        }
    }
    return "$normalResult $protanopiaResult"
}

fun main () {
    println(compareProtanopiaAndNormal())
}