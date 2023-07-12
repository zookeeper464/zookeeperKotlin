package baekjoon.gold.five

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

fun searchDoubleList(color:String, row:Int, col: Int, M: Int, N: Int, doubleList: MutableList<MutableList<Int>>, stringDoubleList: List<List<Char>>): MutableList<MutableList<Int>> {
    val tempQueue = mutableListOf(Pair(row,col))
    while (tempQueue.isNotEmpty()) {
        val (nowRow, nowCol) = tempQueue.first()
        tempQueue.removeFirst()
        listOf(Pair(1,0),Pair(0,1),Pair(-1,0),Pair(0,-1)).forEach { (rowTemp, colTemp) ->
            val newRow = nowRow + rowTemp
            val newCol = nowCol + colTemp
            if ((0 until M).contains(newRow) && (0 until N).contains(newCol) && doubleList[newRow][newCol] == 0 && color.contains(stringDoubleList[newRow][newCol])) {
                tempQueue.add(newRow to newCol)
                doubleList[newRow][newCol] = 1
            }
        }
    }
    return doubleList
}

fun main () {
    println(compareProtanopiaAndNormal())
}