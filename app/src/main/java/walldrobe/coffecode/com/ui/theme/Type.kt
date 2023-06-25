package walldrobe.coffecode.com.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import walldrobe.coffecode.com.R

// Set of Material typography styles to start with
val poppinsFont = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

val satoshiFont = FontFamily(
    Font(R.font.satoshi_variable)
)

val defaultTypography = Typography()

val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = poppinsFont),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = poppinsFont),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = poppinsFont, fontWeight = FontWeight.Black),
    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = poppinsFont),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = poppinsFont, fontWeight = FontWeight.Black),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = poppinsFont, fontWeight = FontWeight.Black),
    titleLarge = defaultTypography.titleLarge.copy(fontFamily = poppinsFont),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = poppinsFont, fontWeight = FontWeight.SemiBold),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = poppinsFont),
    labelLarge = defaultTypography.labelLarge.copy(fontFamily = poppinsFont),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = poppinsFont, fontWeight = FontWeight.Medium),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = poppinsFont),
    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = poppinsFont),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = poppinsFont),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = poppinsFont)
)