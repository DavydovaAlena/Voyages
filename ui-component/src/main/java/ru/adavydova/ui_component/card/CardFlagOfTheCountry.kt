package ru.adavydova.ui_component.card

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers
import ru.adavydova.utils.ColorUI.countryFlagBorderColor

@Composable
internal fun CardFlagOfTheCountry(
    countryCode: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val imageUrl = "https://flagsapi.com/$countryCode/flat/64.png"
    val imageRequest = ImageRequest.Builder(context)
        .data(imageUrl)
        .memoryCacheKey(imageUrl)
        .diskCacheKey(imageUrl)
        .diskCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .dispatcher(Dispatchers.IO)
        .build()

    AsyncImage(
        model = imageRequest,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .width(25.dp)
            .height(20.dp)
            .clip(RoundedCornerShape(9))
            .border(width = 2.dp, countryFlagBorderColor, RoundedCornerShape(9))
    )

}