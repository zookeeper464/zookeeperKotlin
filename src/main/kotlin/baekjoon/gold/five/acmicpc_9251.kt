package baekjoon.gold.five

fun lcs (): Short {
    val squence1 = readln()
    val squence2 = readln()
    val dpList = Array(squence2.length+1) { ShortArray(squence1.length+1) { 0 } }

    squence1.forEachIndexed { index1, firstChar ->
        squence2.forEachIndexed { index2, secondChar ->
            if (firstChar == secondChar) {
                dpList[index2+1][index1+1] = dpList[index2][index1].inc()
            } else {
                dpList[index2+1][index1+1] = maxOf(dpList[index2][index1+1],dpList[index2+1][index1])
            }
        }
    }
    return dpList.last().last()
}

fun main () {
    println(lcs())
}