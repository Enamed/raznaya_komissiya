fun main() {
    println("Для перевода денег, введите используемую банковскую карту ")
    println("1.VK Pay\n2.Mastercard/Maestro\n3.Visa/Мир")
    //val card = readLine()
    val card = readLine()?.toDoubleOrNull() ?: 1
    println("Введите сумму предыдущих переводов за этот месяц")
    val lastTrasaction = readLine()?.toDoubleOrNull() ?: 0
    println("Введите сумму перевода")
    val summa = readLine()

    val result = card?.toInt()?.let {
        lastTrasaction?.toDouble()
            ?.let { it1 -> summa?.toDouble()?.let { it2 -> komission(it, it1, it2) } }
    }
}

fun komission(card: Int, lastTransaction: Double, summa: Double) {

    when (card) {
        1 -> println("Сумма к переводу через VK Pay составляет - $summa ")
        2 -> println("Сумма к переводу через Mastercard/Maestro составляет - "+
                if (summa > 75.000) ((summa * 0.6) / 100) + 20 + summa else summa)
        3 -> println("Сумма к переводу через Visa/Мир составляет - " +
                if ((summa * 0.75) / 100 < 35.0) summa + 35.0 else ((summa * 0.75) / 100) + summa)
    }
}




