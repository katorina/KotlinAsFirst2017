@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    var a = ""
    val b = age % 10
    if (b == 1 && age != 11 && age != 111) { //..год
    a = "$age год"
    }
    if ((b == 2 || b == 3 || b == 4) && age != 12 && age != 13 && age != 14 &&
            age != 112 && age != 113 && age != 114) { //..года
    a = "$age года"
    }
    if (age >= 10 && age <= 20 || b == 0 || b == 5 || b ==6 || b == 7 || b == 8 || b == 9) { //..лет
    a = "$age лет"
    }
    if (age > 100)
        if (age % 100 >= 5 && age % 100 <= 20) {
            a = "$age лет"
        }
    return a
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    var time = -1.0
    val halfS = (t1 * v1 + t2 * v2 + t3 * v3) / 2.0
    val s1 = t1 * v1
    val s2 = s1 + t2 * v2
    val s3 = s2 + t3 * v3
    if (s1 > halfS) { //если прошли половину пути за первый этап
        time = halfS / v1
    }
    if (s1 < halfS && halfS < s2) { //прошли вторую половину во втором этапе
        time = t1 + (halfS - s1) / v2
    }
    if (halfS > s2) {
        time = t1 + t2 + (halfS - (s1 + s2)) / v3
    }
return time
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
        var a = 5
        if (kingX != rookX1 && kingX != rookX2 && kingY != rookY1 && kingY != rookY2) {
            a = 0
        }
        if ((kingX == rookX1 || kingY == rookY1) && kingX != rookX2 && kingY != rookY2) {
            a = 1
        }
        if ((kingX == rookX2 || kingY == rookY2) && kingX != rookX1 && kingY != rookY1) {
            a = 2
        }
        if ((kingX == rookX1 || kingY == rookY1) && (kingX == rookX2 || kingY == rookY2)) {
            a = 3
        }
        return a
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    var k = 5
    val a = Math.abs(kingX - bishopX)
    val b = Math.abs(kingY - bishopY)
    if (kingX != rookX && kingY != rookY && a != b) {
        k = 0
    }
    if ((kingX == rookX || kingY == rookY) && a != b) {
        k = 1
    }
    if (a == b && kingX != rookX && kingY != rookY) {
        k = 2
    }
    if ((kingX == rookX || kingY == rookY) && a == b) {
        k = 3
    }
return k
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    var k = 5
    if (a < b + c && b < a + c && c < a + b) {
        if (a * a + b * b == c * c || b * b + c * c == a * a || c * c + a * a == b * b) {
            k = 1
        }
        else if (a * a + b * b < c * c || b * b + c * c < a * a || c * c + a * a < b * b) {
            k = 2
        }
        else k = 0
    }
    else k = -1
return k
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    var k = -20
    if (a <= c && c <= b && b <= d) {
        k = b - c
    }
    if (c <= a && a <=b && b <= d) {
        k = b - a
    }
    if (a <= c && c <= d && d <= b) {
        k = d - c
    }
    if (c <= a && a <= d && d <= b) {
        k = d - a
    }
    if (a <= b && b < c && c < d || c <= d && d < a && a < b) {
        k = -1
    }
return k
}
