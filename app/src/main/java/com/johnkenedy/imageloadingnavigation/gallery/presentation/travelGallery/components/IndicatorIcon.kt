package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelGallery.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.johnkenedy.imageloadingnavigation.R

enum class IndicatorOrientation(
    val icon: ImageVector,
    @param:StringRes val descriptionRes: Int
) {
    LEFT(
        icon = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
        descriptionRes = R.string.icon_ponting_to_the_left_description
    ),
    RIGHT(
        icon = Icons.AutoMirrored.Filled.KeyboardArrowRight,
        descriptionRes = R.string.icon_ponting_to_the_right_description
    )
}

@Composable
fun IndicatorIcon(
    onClick: () -> Unit,
    orientation: IndicatorOrientation,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(20.dp)
            .clip(CircleShape)
            .background(Color.White)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = orientation.icon,
            contentDescription = stringResource(orientation.descriptionRes),
            tint = Color.Black,
            modifier = Modifier.size(14.dp)
        )
    }
}

@Preview
@Composable
private fun IndicatorIconLeftPreview() {
    IndicatorIcon(
        orientation = IndicatorOrientation.LEFT,
        onClick = {}
    )
}

@Preview
@Composable
private fun IndicatorIconRightPreview() {
    IndicatorIcon(
        orientation = IndicatorOrientation.RIGHT,
        onClick = {}
    )
}