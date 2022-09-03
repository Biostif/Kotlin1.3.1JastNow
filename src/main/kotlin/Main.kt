private const val SEC = 1
private const val MIN = 60
private const val HOUR = 60 * 60
private const val DAY = 24 * 60 * 60

fun main(args: Array<String>) {
    println(agoToText(HOUR))
    println(agoToText(2 * HOUR))
    println(agoToText(23 * HOUR))
    println(agoToText(3 * DAY))
}

fun agoToText(second: Int): String {
    val text = when (second) {
        in 0 until  MIN - SEC -> "был(а) только что"
        in MIN until DAY -> "был(а) в сети ${time(second)} назад"
        in DAY until DAY * 2 -> "был(а) в сети вчера"
        in DAY * 2 until DAY * 3 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
    return text
}

fun time(second: Int) :String{
    val min = second < HOUR
    val timeMin = second/MIN
    val timeHours = second/HOUR
    val time = if (if(min) timeMin in 11..19 else timeHours in 11..19){
        if (min) "$timeMin минут" else "$timeHours часов"
    } else if (if(min) timeMin in 2..4 || timeMin % 10 in 2..4
        else timeHours in 2..4 || timeHours % 10 in 2..4){
        if (min) "$timeMin минуты" else "$timeHours часа"
    } else if (if(min) timeMin == 1 || timeMin % 10 == 1 else timeHours == 1 || timeHours % 10 == 1){
        if (min) "$timeMin минуту" else "$timeHours час"
    }
    else {
        if (min) "$timeMin минут" else "$timeHours часов"
    }
    return time
}
