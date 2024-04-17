package ru.adavydova.ui_component.card

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.adavydova.utils.countryFlagBorderColor

@Composable
fun CardFlagOfTheCountry(
    countryCode: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    AsyncImage(
        model = ImageRequest.Builder(context)
//            .error(R.drawable.image_product)
            .data("https://flagsapi.com/:$countryCode/:style/:size.png")
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(25.dp)
            .clip(RoundedCornerShape(9))
            .border(width = 2.dp,  countryFlagBorderColor, RoundedCornerShape(9))
    )

}