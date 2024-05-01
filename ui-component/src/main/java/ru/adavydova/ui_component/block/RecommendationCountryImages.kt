package ru.adavydova.ui_component.block

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers

@Composable
internal fun RecommendationCountryImages(
    modifier: Modifier = Modifier,
    imageUrl: String
) {

    val context = LocalContext.current
    val imageRequest = ImageRequest.Builder(context)
        .data(imageUrl)
        .memoryCacheKey(imageUrl)
        .diskCacheKey(imageUrl)
        .diskCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .dispatcher(Dispatchers.IO)
        .build()

    AsyncImage(
        colorFilter = ColorFilter.tint(
            color = Color.DarkGray.copy(alpha = .8f),
            blendMode = BlendMode.Multiply
        ),
        model = imageRequest,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(35.dp))
    )
}