package com.example.baitap

fun main() {
    val name = "Phan Thi Thu Thanh"
    val studentId = "2415053122243"


    println("BAI TAP VONG LAP - SINH VIEN: $name - MSSV: $studentId")


    // Bai 1: In cac so tu 1 den 10
    println("\n--- Bai 1: In cac so tu 1 den 10 ---")
    for (i in 1..10) {
        print("$i ")
    }
    println()

    // Bai 2: Tinh tong 1 + 2 + 3 + ... + 100
    println("\n--- Bai 2: Tinh tong tu 1 den 100 ---")
    var sum = 0
    for (i in 1..100) {
        sum += i
    }
    println("Tong cua day so tu 1 den 100 la: $sum")

    // Bai 3: In cac so chan tu 1 den 20
    println("\n--- Bai 3: In cac so chan tu 1 den 20 ---")
    for (i in 1..20) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }
    println("\n=================================")
}