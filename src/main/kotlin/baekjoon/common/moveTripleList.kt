package baekjoon.common

fun moveTripleList (M:Int, N:Int, H:Int, positions: List<Triple<Int,Int,Int>>, tripleList: MutableList<MutableList<MutableList<Int>>>): MutableList<Triple<Int,Int,Int>> {
    val tempQueue = mutableListOf<Triple<Int,Int,Int>>()
    positions.forEach { position ->
        listOf(
            Triple(1,0,0),
            Triple(-1,0,0),
            Triple(0,1,0),
            Triple(0,-1,0),
            Triple(0,0,1),
            Triple(0,0,-1)
        ).forEach { (heiTemp,colTemp,rowTemp) ->
            val newHei = position.first+heiTemp
            val newCol = position.second+colTemp
            val newRow = position.third+rowTemp
            if (
                -1<newRow &&
                newRow<N &&
                -1<newCol &&
                newCol<M &&
                -1<newHei &&
                newHei<H &&
                tripleList[newHei][newCol][newRow] == 0
            ) {
                tripleList[newHei][newCol][newRow] = 1
                tempQueue.add(Triple(newHei,newCol,newRow))
            }
        }
    }
    return tempQueue
}