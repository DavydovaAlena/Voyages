package ru.adavydova.recommendation_feature.menu

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adavydova.recommendation_feature.util.vertical
import ru.adavydova.utils.ColorUI
import ru.adavydova.utils.FontUI


@Composable
fun RecommendationItemText(
    title: String,
    modifier: Modifier = Modifier
) {

    Text(
        modifier = modifier
            .vertical()
            .graphicsLayer {
                this.rotationZ = -90f
            },
        maxLines = 1,
        text = title,
        color = ColorUI.primaryBottomMenuButtonColor,
        fontFamily = FontUI.MontserratBold.toFontFamily(),
        fontSize = 12.sp
    )

}

@Preview
@Composable
fun RecommendationItemPreview() {
    RecommendationItemText(title = "Destionations")
}
