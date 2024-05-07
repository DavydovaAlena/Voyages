package ru.adavydova.ui_component.block

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adavydova.ui_component.R
import ru.adavydova.utils.ColorUI
import ru.adavydova.utils.FontUI

@Composable
fun UserCardBlock(
    @DrawableRes icon: Int,
    userName: String,
    modifier: Modifier = Modifier,
){

    Row(
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        modifier = modifier
        .wrapContentWidth()
        .height(40.dp)) {

        Image(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray),
            imageVector = ImageVector.vectorResource(id = R.drawable.user_woman),
            contentDescription = null)

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            Text(
                fontSize = 7.sp,
                fontFamily = FontUI.MontserratRegular.toFontFamily(),
                color = ColorUI.welcomeColor,
                text = "Welcome")

            Text(
                fontFamily = FontUI.MontserratExtraBold.toFontFamily(),
                color = ColorUI.recommendationTextColor,
                fontSize = 12.sp,
                text = userName)
        }
    }

}