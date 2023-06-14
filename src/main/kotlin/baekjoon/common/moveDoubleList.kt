package baekjoon.common

fun moveDoubleList (M:Int, N:Int, positions: List<Pair<Int,Int>>, doubleList: MutableList<MutableList<Int>>): MutableList<Pair<Int,Int>> {
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