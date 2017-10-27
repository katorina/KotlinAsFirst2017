@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import javafx.beans.binding.Bindings.equal
import java.lang.Math.sqrt
import java.util.Objects.equals

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var m = Math.abs(n)
    var sum = 0
    if (n == 0) {
        sum = 1
    }
    while (m > 0) {
        sum = sum + 1
        m = m / 10
    }
    return sum
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var l = -1
    var a = 1
    var b = 1
    if (n == 1 || n == 2) {
        l = 1
    }
    else
        for (i in 3..n) {
            l = a + b
            a = b
            b = l
        }
    return l
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var k = 2
    k = if (m >= n) {
        m
    } else n
    while (!(k % m == 0 && k % n == 0)) {
        k = k + 1
    }
    return k
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var k = 2
    while (n % k != 0) {
        k = k + 1
    }
    return k
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var k = n - 1
    while (n % k != 0) {
        k = k - 1
    }
    return k
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var k = 0
    var min = -1
    var L = false
    if (m > n) {
        min = n
    }
    else min = m
    for (i in min downTo 2) {
        if (m % i == 0 && n % i == 0) {
            k = k + 1
        }
    }
    if (k == 0) {
        L = true
    }
    return L
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var l = false
    val m1 = Math.sqrt(m.toDouble())
    val n1 = Math.sqrt(n.toDouble())
    val n2 = n / 1
    var k = m / 1
    if (m1 % 1 == 0.0 || n1 % 1 == 0.0){
        l = true
    }
    else {
    for (i in m..n2) {
        k = k + 1
        if (Math.sqrt(k.toDouble()) % 1 == 0.0) {
            l = true
            break
        }
    }
    }
    return l
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var itog = 0
    var k = 0
    var m = n
    var sum = 0
    while (m > 0) {
        sum = sum + 1
        m /= 10
    }
    m = n
    for (i in sum downTo 1) {
        k = m % 10
        itog = k * Math.pow(10.0, i.toDouble()-1).toInt() + itog
        m = m / 10
    }
    return itog
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    var l = false
    if (revert(n) == n) l = true
    return l
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var l = false
    var k = n / 10
    var m = -1
    m = n % 10
    while (k != 0) {
        if (k % 10 != m) {
            l = true
            break
        }
        else k = k / 10
    }
    return l
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var m = 0 //искомое число
    var d = 0 //количество "шагов"
    var k = 0 //текущий квадрат
    var l = 0
    for (i in 1..n) {
        k = i * i
        d = d + digitNumber(k)
        if (d >= n) {
            l = Math.pow(10.0,((d - n).toDouble())).toInt()
            k = k / l
            m = k % 10
            break
        }
    }
    return m
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var m = 0 //искомое число
    var d = 0 //количество "шагов"
    var k = 0 //текущее число Фибоначчи
    var l = 0
    for (i in 1..n) {
        k = fib(i)
        d = d + digitNumber(k)
        if (d >= n) {
            l = Math.pow(10.0,((d - n).toDouble())).toInt()
            k = k / l
            m = k % 10
            break
        }
    }
    return m
}
