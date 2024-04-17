package ru.adavydova.ui_component.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.adavydova.ui_component.R
import ru.adavydova.utils.buttonContainerGoToTheCountry
import ru.adavydova.utils.buttonContentGoToTheCountry

@Composable
fun ButtonGoToTheDetail(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        modifier = Modifier
            .width(75.dp)
            .height(48.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = buttonContainerGoToTheCountry,
            contentColor = buttonContentGoToTheCountry
        ),
        onClick = onClick
    ) {

        Icon(
            imageVector = ImageVector
                .vectorResource(id = R.drawable.arrow_right),
            contentDescription = null
        )

    }
}