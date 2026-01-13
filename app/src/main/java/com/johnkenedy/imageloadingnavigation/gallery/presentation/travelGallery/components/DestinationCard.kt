package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelGallery.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.johnkenedy.imageloadingnavigation.R
import com.johnkenedy.imageloadingnavigation.core.ui.theme.ImageLoadingNavigationTheme
import com.johnkenedy.imageloadingnavigation.core.ui.theme.LoadingIndicatorBlue
import com.johnkenedy.imageloadingnavigation.core.ui.theme.errorGradient
import com.johnkenedy.imageloadingnavigation.core.ui.theme.loadingGradient

@Composable
fun DestinationCard(
    title: String,
    indicatorOrientation: IndicatorOrientation,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    imageRes: Int? = null,
) {
    var isSuccess by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .aspectRatio(184f / 220f)
            .clickable(
                onClick = onCardClick,
                role = Role.Button,
                onClickLabel =  title
            ),
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.5f)),
        colors = CardDefaults.cardColors(containerColor = Color.Black)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl ?: imageRes)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                onSuccess = { isSuccess = true },
                onLoading = { isSuccess = false },
                onError = { isSuccess = false },
                loading = { LoadingState() },
                error = { ErrorState() }
            )

            if (isSuccess) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.3f)),
                                startY = 300f
                            )
                        )
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        color = Color.White,
                        fontSize = 18.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )

                    IndicatorIcon(
                        orientation = indicatorOrientation,
                        onClick = onCardClick
                    )
                }
            }
        }
    }
}

@Composable
private fun LoadingState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = MaterialTheme.colorScheme.loadingGradient),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(32.dp),
            color = LoadingIndicatorBlue,
            strokeWidth = 2.dp
        )
    }
}

@Composable
private fun ErrorState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = MaterialTheme.colorScheme.errorGradient),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.alert_triangle),
            contentDescription = stringResource(R.string.error_loading_image),
            modifier = Modifier.size(40.dp)
        )
    }
}

@Preview(name = "Success State (Local Resource)")
@Composable
private fun DestinationCardSuccessPreview() {
    ImageLoadingNavigationTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            DestinationCard(
                title = "Canadian Rockies",
                imageRes = R.drawable.canadian_rockies,
                indicatorOrientation = IndicatorOrientation.RIGHT,
                modifier = Modifier.size(width = 184.dp, height = 220.dp),
                onCardClick = {}
            )
        }
    }
}

@Preview(name = "Loading State")
@Composable
private fun DestinationCardLoadingPreview() {
    ImageLoadingNavigationTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            Card(
                modifier = Modifier.size(width = 184.dp, height = 220.dp),
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(1.dp, Color.White)
            ) {
                LoadingState()
            }
        }
    }
}

@Preview(name = "Error State")
@Composable
private fun DestinationCardErrorPreview() {
    ImageLoadingNavigationTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            Card(
                modifier = Modifier.size(width = 184.dp, height = 220.dp),
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(1.dp, Color.White)
            ) {
                ErrorState()
            }
        }
    }
}
