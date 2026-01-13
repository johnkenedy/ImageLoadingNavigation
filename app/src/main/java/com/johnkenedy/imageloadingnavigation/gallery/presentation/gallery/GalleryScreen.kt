package com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.johnkenedy.imageloadingnavigation.core.ui.theme.ImageLoadingNavigationTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun GalleryScreenRoot(
    imageUrls: List<String>,
    onBackClick: () -> NavKey,
    viewModel: GalleryViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    GalleryScreen(
        state = state,
        onAction = viewModel::onAction,
        imageUrls = imageUrls,
        onBackClick = onBackClick,
    )
}

@Composable
fun GalleryScreen(
    state: GalleryState,
    onAction: (GalleryAction) -> Unit,
    imageUrls: List<String>,
    onBackClick: () -> NavKey,
) {

}

@Preview
@Composable
private fun Preview() {
    ImageLoadingNavigationTheme {
        GalleryScreen(
            state = GalleryState(),
            imageUrls = emptyList(),
            onBackClick = { error("Not implemented") },
            onAction = {},
        )
    }
}