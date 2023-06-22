package baekjoon.common

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