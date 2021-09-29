fun main() {

    println("Для перевода денег, введите используемую банковскую карту ")
    println("1.VK Pay\n2.Mastercard/Maestro\n3.Visa/Мир")
    val card = readLine()
    val card1 = card?.toInt()
    if (card1 == 2)
        println("Введите адресата(пишем что хотим)")
    val adresat = readLine()

    println("Введите сумму предыдущих переводов за этот месяц")
    val lastTrasaction = readLine()
    println("Введите сумму перевода")
    val summa = readLine()

    val result = card?.toInt()?.let {
        lastTrasaction?.toDouble()
            ?.let { it1 -> summa?.toDouble()?.let { it2 -> komission(it, adresat = String(), it1, it2) } }
    }
}

fun komission(card: Int, adresat: String, lastTrns: Double, summa: Double) {
    //procent VISA
    val procentsumm = (summa * 0.75) / 100
    val minprocent = procentsumm + summa
    val visaTransfer = if (procentsumm < 35.0) summa + 35.0 else minprocent
    //procent MASTERCARD
    val procentMastercard = ((summa * 0.6) / 100) + 20 + summa
    val mastercardTransfer = if (summa > lastTrns) procentMastercard else summa

    when (card) {
        1 -> println("Сумма к переводу через VK Pay для $adresat составляет - $summa")
        2 -> println("Сумма к переводу через Mastercard/Maestro для $adresat составляет - $mastercardTransfer")
        3 -> println("Сумма к переводу через Visa/Мир для $adresat составляет - $visaTransfer")
    }
}



