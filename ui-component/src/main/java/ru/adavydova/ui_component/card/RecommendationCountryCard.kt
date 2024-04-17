package ru.adavydova.ui_component.card

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.adavydova.models.CountryUI

@Composable
fun RecommendationCountryCard(
    country: CountryUI,
    modifier: Modifier = Modifier
) {
   ElevatedCard(
       shape = RoundedCornerShape(35.dp),
       modifier = Modifier
           .fillMaxHeight()
           .width(266.dp)) {


   }
}