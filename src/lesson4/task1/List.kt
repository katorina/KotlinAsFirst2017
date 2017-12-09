@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    val m = v.map { it * it }
    val k = Math.sqrt(m.sum())
    return k
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    return if (list.isEmpty()) 0.0
    else list.sum() / list.size
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    if (!(list.isEmpty())) {
        val sr = mean(list)
        for (i in 0 until list.size) list[i] = list[i] - sr
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var k = 0.0
    if (a.isEmpty() && b.isEmpty()) return 0.0
    else {
        for (i in 0 until b.size) {
            k += a[i] * b[i]
        }
    }
    return k
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var px = 0.0
    if (p.isEmpty()) return 0.0
    else {
        for (i in 0..p.size - 1) {
            px += p[i] * Math.pow(x, i.toDouble())
        }
    }
    return px
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    if (!(list.isEmpty())) {
        var sum = list[0]
        for (i in 1 until list.size) {
            sum += list[i]
            list[i] = sum
        }
    }
    return list
}


/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var k = n
    val list = mutableListOf<Int>()
    var d = 2
    while (k != 1) {
        for (i in d..n) {
            if (k % i == 0) {
                d = i
                list.add(i)
                k /= i
                break
            }
        }
    }
    return list
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*", postfix = "")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var m = n
    var ost = 0
    val list = mutableListOf<Int>()
    if (n <= (base - 1)) list.add(n)
    else {
        while (m >= base) {
            ost = m % base
            list.add(ost)
            m /= base
        }
        list.add(m)
    }
    return list.reversed()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    var convert = convert(n, base)
    var res = mutableListOf<Char>()
    for (i in 0 until convert.size) {
        when {
            convert[i] >= 10 -> res.add('a' + (convert[i] - 10))
            else -> res.add('0' + convert[i])
        }
    }
    return res.filter { it != ' ' }.joinToString(separator = "")
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var st = 0.0
    var res = 0
    for (i in digits.size - 1 downTo 0) {
        res += (digits[i] * Math.pow(base.toDouble(), st)).toInt()
        st++
    }
    return res
}


/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    var st = 0.0
    var res = 0.0
    for (i in str.length - 1 downTo 0) {
        var k = if (str[i] in 'a'..'z') str[i] - 'a' + 10
        else str[i].toInt() - '0'.toInt()
        res += k * Math.pow(base.toDouble(), st)
        st++
    }
    return res.toInt()
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var res = ""
    var m = n
    if (m >= 1000) for (k in 1..m / 1000) { //56123
        res += "M"
        m %= 1000 //123
    }
    if (m in 100..999 && m / 100 > 0) {
        when (m / 100) { //сотни
            in 1..3 -> for (k in 1..m / 100) res += "C"
            4 -> res += "CD"
            5 -> res += "D"
            in 6..8 -> {
                res += "D"
                for (f in 1..m / 100 - 5) res += "C"
            }
            9 -> res += "CM"
        }
        m %= 100
    }
    if (m in 10..99 && m > 0) {
        when (m / 10) {
            in 1..3 -> for (k in 1..m / 10) res += "X"
            4 -> res += "XL"
            5 -> res += "L"
            in 6..8 -> {
                res += "L"
                for (f in 1..m / 10 - 5) res += "X"
            }
            9 -> res += "XC"
        }
        m %= 10
    }
    if (m in 1..9) when (m) {
        in 1..3 -> for (k in 1..m) res += "I"
        4 -> res += "IV"
        5 -> res += "V"
        in 6..8 -> {
            res += "V"
            for (f in 1..m - 5) res += "I"
        }
        9 -> res += "IX"
    }
    return res
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun perevod(m: Int, f: Int): String {
    var n = m //561
    var res = ""
    val number: List<String> = listOf<String>("", "один", "два", "три", "четыр", "пять", "шесть", "семь", "восемь", "девять")
    if (n > 0) {
        val n1 = n / 100 //сотни
        val n2 = (n / 10) % 10 //десятки
        val n3 = n % 10 //единицы
        when (n1) {
            1 -> res += "сто "
            2 -> res += "двести "
            3 -> res += number[3] + "ста "
            4 -> res += number[4] + "еста "
            in 5..9 -> res += number[n1] + "сот "
        }
        when (n2) { //+десять
            1 -> {
                if (n % 100 == 10) res += "десять "
                else when (n3) {
                    1 -> res += number[1] + "надцать "
                    2 -> res += "двенадцать "
                    3 -> res += number[3] + "надцать "
                    in 4..9 -> {
                        var str = number[n3]
                        str = str.removeRange(str.length - 1, str.length)
                        res += str + "надцать " //РАЗОБРАТЬСЯ С ПРОБЕЛОМ
                    }
                }
            }
            in 2..3 -> res += number[n2] + "дцать "
            4 -> res += "сорок "
            in 5..8 -> res += number[n2] + "десят "
            9 -> res += "девяносто "
        }
        if (n2 != 1 && f == 0) { //не тысячи
            when (n3) {
                in 1..3 -> res += number[n3] + " "
                4 -> res += number[4] + "е "
                in 5..9 -> res += number[n3] + " "
            }
        }
        if (n2 != 1 && f == 1) //тысячи
            when (n3) {
                0 -> res += "тысяч "
                1 -> res += "одна тысяча "
                2 -> res += "две тысячи "
                3 -> res += number[n3] + "тысячи "
                4 -> res += number[4] + "е тысячи "
                in 5..9 -> res += number[n3] + " тысяч "
            }
        if (n2 == 1 && f == 1) res += "тысяч "
    } else return ""
    return res
}

fun russian(n: Int): String {
    var m1 = n / 1000
    var m2 = n % 1000
    var result = perevod(m1, 1)
    result += perevod(m2, 0)
    result = result.trim()
    return result
}
