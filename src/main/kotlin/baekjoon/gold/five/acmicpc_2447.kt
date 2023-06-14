package baekjoon.gold.five

fun drawStar(): String {
    val N = readln().toInt()
    fun recursiveStar (N:Int): List<List<String>> {
        if (N == 3) return listOf(listOf("*","*","*"),listOf("*"," ","*"),listOf("*","*","*"))

        return recursiveStar(N/3).map{ it+it+it. } + recursiveStar(N/3).map { it+List(N/3){" "}+it } + recursiveStar(N/3).map { it+it+it }
    }
    val answerList = recursiveStar(N)
    return answerList.joinToString("\n") { it.joinToString("") }
}

fun main () {
    println(drawStar())
}