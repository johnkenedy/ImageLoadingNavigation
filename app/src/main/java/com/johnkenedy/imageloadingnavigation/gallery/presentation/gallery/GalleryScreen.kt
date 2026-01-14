package com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import coil3.compose.AsyncImage
import com.johnkenedy.imageloadingnavigation.core.ui.theme.ImageLoadingNavigationTheme
import com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery.components.GalleryTopBar
import com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery.route.GalleryRoute
import com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations.components.DestinationCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun GalleryScreenRoot(
    galleryRouteItem: GalleryRoute,
    onBackClick: () -> NavKey,
    viewModel: GalleryViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    GalleryScreen(
        state = state,
        onAction = viewModel::onAction,
        galleryRouteItem = galleryRouteItem,
        onBackClick = onBackClick,
    )
}

@Composable
fun GalleryScreen(
    state: GalleryState,
    onAction: (GalleryAction) -> Unit,
    galleryRouteItem: GalleryRoute,
    onBackClick: () -> NavKey,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            containerColor = Color.White,
            topBar = {
                GalleryTopBar(
                    title = galleryRouteItem.title,
                    onBackClick = {
                        onBackClick()
                    }
                )
            }
        ) { innerPadding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(top = 5.dp)
                    .padding(horizontal = 16.dp)
            ) {
                items(
                    items = galleryRouteItem.imageUrls,
                    key = { it }
                ) { galleryItem ->
                    DestinationCard(
                        imageUrl = galleryItem,
                        onCardClick = {
                            onAction(GalleryAction.OnImageClick(galleryItem))
                        }
                    )
                }
            }
        }

        AnimatedVisibility(
            visible = state.selectedImageUrl != null,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .clickable { onAction(GalleryAction.OnDismissImage) }
            ) {
                AsyncImage(
                    model = state.selectedImageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ImageLoadingNavigationTheme {
        GalleryScreen(
            state = GalleryState(),
            galleryRouteItem = GalleryRoute(
                "Alps", listOf(
                    "https://images.unsplash.com/photo-1506905925346-21bda4d2df4?w=600&q=80",
                    "https://images.unsplash.com/photo-1519904981063-b0cf448d479e?w=600&q=80",
                    "https://images.unsplash.com/photo-1551632811-561732d1e306?w=600&q=80",
                    "https://images.unsplash.com/photo-1486870591958-9b9d0d1dda99?w=600&q=80",
                    "https://images.unsplash.com/photo-1544735716-392fe2489ffa?w=600&q=80",
                    "https://images.unsplash.com/photo-1605540436563-5bca99ae766?w=600&q=80"
                )
            ),
            onBackClick = { error("Not implemented") },
            onAction = {},
        )
    }
}
