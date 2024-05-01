package ru.adavydova.ui_component.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.adavydova.models.CountryUI
import ru.adavydova.ui_component.block.RecommendationCountryDescriptionWithButtonBlock
import ru.adavydova.ui_component.block.RecommendationCountryImages

@Composable
fun RecommendationCountryCard(
    country: CountryUI,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    ElevatedCard(
        shape = RoundedCornerShape(35.dp),
        modifier = Modifier
            .fillMaxHeight()
            .width(266.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            RecommendationCountryImages(imageUrl = country.picture)

            RecommendationCountryDescriptionWithButtonBlock(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(24.dp)
                    .fillMaxWidth(),
                nameCountry = country.name,
                codeCountry = country.code,
                goToTheDetails = { /*TODO*/ })

        }


    }
}