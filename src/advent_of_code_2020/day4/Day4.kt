package advent_of_code_2020.day4

import java.io.File

fun main() {
    val day4 = Day4()
    val path = "src/advent_of_code_2020/day4/input.txt"
    val inputList = day4.readFileToList(path)
    println("Solution A: ${day4.solutionA(inputList)}")
    println("Solution B: ${day4.solutionB(inputList)}")
}

class Day4 {
    val expectedFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    fun readFileToList(path: String): List<String> {
        val list: MutableList<String> = ArrayList()
        val sb: StringBuilder = StringBuilder()
        File(path).readLines().forEach {
            if (it.isEmpty()) {
                list.add(sb.toString())
                sb.clear()
            } else sb.append(it).append(" ")
        }
        list.add(sb.toString())
        return list
    }

    fun solutionA(inputList: List<String>): Int {
        var result = 0
        inputList.forEach loop@{
            val arr = it.trim().split(" ")
            val count = arr.count { a -> expectedFields.contains(a.substring(0, 3))}
            if (count == expectedFields.size) result++
        }
        return result
    }

    fun solutionB(inputList: List<String>): Int {
        return 0
    }
}