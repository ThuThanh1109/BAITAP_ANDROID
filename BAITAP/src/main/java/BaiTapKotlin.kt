import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val studentName = "Phan Thi Thu Thanh"
    val studentID = "2415053122243"

    println("=== NHAP THONG TIN DIEM SO ===")
    print("Nhap diem Math: ")
    val math = scanner.nextDouble()

    print("Nhap diem Programming: ")
    val programming = scanner.nextDouble()

    print("Nhap diem Database: ")
    val database = scanner.nextDouble()

    val total = math + programming + database
    val gpa = total / 3
    val maxScore = maxOf(math, programming, database)
    val isPassed = gpa >= 5.0

    println("\n=== KET QUA HOC TAP ===")
    println("Thong tin sinh vien: $studentName - MSSV: $studentID")
    println("- Tong diem: $total")
    println("- Diem trung binh: %.2f".format(gpa))
    println("- Diem cao nhat: $maxScore")

    val status = if (isPassed) "Dat" else "Khong dat"
    println("- Sinh vien co dat khong? (GPA >= 5.0): $status")
}