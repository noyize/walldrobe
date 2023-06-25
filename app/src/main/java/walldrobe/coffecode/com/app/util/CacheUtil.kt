package walldrobe.coffecode.com.app.util

import java.util.concurrent.TimeUnit

fun Long.isStale(): Boolean {
    val difference = System.currentTimeMillis() - this
    val timeDifference = TimeUnit.MICROSECONDS.toMinutes(difference)
    return timeDifference >= 5
}