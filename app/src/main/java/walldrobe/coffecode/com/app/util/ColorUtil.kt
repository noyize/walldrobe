package walldrobe.coffecode.com.app.util

import androidx.core.graphics.ColorUtils

fun isDark(color: Int): Boolean {
    return ColorUtils.calculateLuminance(color) < 0.5
}