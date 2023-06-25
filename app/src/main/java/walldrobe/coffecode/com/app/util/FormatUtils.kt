package walldrobe.coffecode.com.app.util

import java.text.SimpleDateFormat
import kotlin.math.ln
import kotlin.math.pow

fun dateConvert(date: String): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val sdfN = SimpleDateFormat("dd MMM '`'yy")
    return sdfN.format(sdf.parse(date)!!)
}

fun Int.toPrettyString(): String {
    if (this < 1000) return "$this"
    val exp = (ln(this.toDouble()) / ln(1000.0)).toInt()
    return String.format("%.1f%c", this / 1000.0.pow(exp.toDouble()), "KMGTPE"[exp - 1])
}