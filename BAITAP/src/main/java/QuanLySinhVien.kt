import java.util.Scanner

// 1. Lop doi tuong Sinh vien
data class Student(
    val id: String,
    val fullName: String,
    val age: Int,
    val major: String,
    val gpa: Double
) {
    override fun toString(): String {
        return "ID: $id | Name: $fullName | Age: $age | Major: $major | GPA: $gpa"
    }
}

// 2. Lop Quan ly xu ly toan bo 12 yeu cau va cac chuc nang co ban
class StudentManager {
    private val students = mutableListOf<Student>()

    init {
        // Khoi tao 5 sinh vien mau rieng biet khong dung hang
        students.add(Student("SV01", "Nguyen Thi Diem Quynh", 21, "Su - Dia - Chinh tri", 8.5))
        students.add(Student("SV02", "Phan Thi Thu Thanh", 21, "Su - Dia - Chinh tri", 7.8))
        students.add(Student("SV03", "Tran Thi Thu Hien", 21, "Su - Dia - Chinh tri", 9.0))
        students.add(Student("SV04", "Thai Thi Uyen", 21, "Su - Dia - Chinh tri", 8.2))
        students.add(Student("SV05", "Ngo Thi Thanh Hoang", 21, "Cong nghe thong tin", 6.5))
    }

    // Cac chuc nang menu co ban
    fun addStudent(student: Student) = students.add(student)
    fun displayAll() = students.forEach { println(it) }
    fun searchStudent(id: String): Student? = students.find { it.id.equals(id, ignoreCase = true) }
    fun calculateOverallAverageGPA(): Double = if (students.isEmpty()) 0.0 else students.map { it.gpa }.average()
    fun removeStudent(id: String): Boolean = students.removeIf { it.id.equals(id, ignoreCase = true) }

    // 12 Yeu cau nang cao
    fun countGpaAboveOrEqual8(): Int = students.count { it.gpa >= 8.0 }

    fun countGpaBelow5(): Int = students.count { it.gpa < 5.0 }

    fun averageGpaByMajor(major: String): Double {
        val filtered = students.filter { it.major.equals(major, ignoreCase = true) }
        return if (filtered.isEmpty()) 0.0 else filtered.map { it.gpa }.average()
    }

    fun studentWithHighestGpa(): Student? = students.maxByOrNull { it.gpa }

    fun oldestStudent(): Student? = students.maxByOrNull { it.age }

    fun studentsInGpaRange(min: Double, max: Double): List<Student> = students.filter { it.gpa in min..max }

    fun studentsByMajor(major: String): List<Student> = students.filter { it.major.equals(major, ignoreCase = true) }

    fun searchByPartialName(name: String): List<Student> = students.filter { it.fullName.contains(name, ignoreCase = true) }

    fun sortByGpaDescending(): List<Student> = students.sortedByDescending { it.gpa }

    fun top3HighestGpa(): List<Student> = students.sortedByDescending { it.gpa }.take(3)

    fun sortByAge(): List<Student> = students.sortedBy { it.age }

    fun sortByName(): List<Student> = students.sortedBy { it.fullName }
}

// 3. Chuong trinh chinh (Chay Console)
fun main() {
    val manager = StudentManager()
    val scanner = Scanner(System.`in`)
    var choice: Int

    do {
        println("\n========== STUDENT MANAGEMENT ==========")
        println("1. Add student")
        println("2. Display all students")
        println("3. Search student by ID")
        println("4. Calculate average GPA")
        println("5. Find student with highest GPA")
        println("6. Remove student")
        println("7. Run 12 specific requirements")
        println("0. Exit")
        println("========================================")
        print("Choose: ")
        choice = scanner.nextInt()
        scanner.nextLine() // Doc bo dong trong

        when (choice) {
            1 -> {
                print("Enter ID: "); val id = scanner.nextLine()
                print("Enter Name: "); val name = scanner.nextLine()
                print("Enter Age: "); val age = scanner.nextInt()
                scanner.nextLine()
                print("Enter Major: "); val major = scanner.nextLine()
                print("Enter GPA: "); val gpa = scanner.nextDouble()
                manager.addStudent(Student(id, name, age, major, gpa))
                println("Student added!")
            }
            2 -> manager.displayAll()
            3 -> {
                print("Enter ID to search: "); val id = scanner.nextLine()
                val s = manager.searchStudent(id)
                if (s != null) println(s) else println("Not found!")
            }
            4 -> println("Overall Average GPA: ${manager.calculateOverallAverageGPA()}")
            5 -> println("Highest GPA Student: ${manager.studentWithHighestGpa()}")
            6 -> {
                print("Enter ID to remove: "); val id = scanner.nextLine()
                if (manager.removeStudent(id)) println("Removed successfully!") else println("Not found!")
            }
            7 -> {
                // Chay nhanh cac yeu cau bai tap dua ra
                println("--- KET QUA 12 YEU CAU ---")
                println("1. So SV GPA >= 8.0: ${manager.countGpaAboveOrEqual8()}")
                println("2. So SV GPA < 5.0: ${manager.countGpaBelow5()}")
                println("3. Diem TB nganh Su - Dia - Chinh tri: ${manager.averageGpaByMajor("Su - Dia - Chinh tri")}")
                println("4. SV diem cao nhat: ${manager.studentWithHighestGpa()?.fullName}")
                println("5. SV lon tuoi nhat: ${manager.oldestStudent()?.fullName}")
                println("6. SV GPA [7.0 - 8.5]:")
                manager.studentsInGpaRange(7.0, 8.5).forEach { println("   - $it") }
                println("7. Tim SV nganh 'Cong nghe thong tin':")
                manager.studentsByMajor("Cong nghe thong tin").forEach { println("   - $it") }
                println("8. Tim SV ten chua chu 'Thanh':")
                manager.searchByPartialName("Thanh").forEach { println("   - $it") }
                println("9. Sap xep GPA giam dan (Top 1): ${manager.sortByGpaDescending().firstOrNull()?.fullName}")
                println("10. Top 3 GPA cao nhat:")
                manager.top3HighestGpa().forEach { println("   - $it") }
                println("11. Sap xep theo tuoi (Nguoi tre nhat): ${manager.sortByAge().firstOrNull()?.fullName}")
                println("12. Sap xep theo ten (Bang chu cai): ${manager.sortByName().firstOrNull()?.fullName}")
            }
            0 -> println("Exiting...")
            else -> println("Invalid choice!")
        }
    } while (choice != 0)
}