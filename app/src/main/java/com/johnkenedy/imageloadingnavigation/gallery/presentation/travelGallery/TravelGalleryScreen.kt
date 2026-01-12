package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelGallery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.johnkenedy.imageloadingnavigation.core.ui.theme.ImageLoadingNavigationTheme
import com.johnkenedy.imageloadingnavigation.presentation.TravelGalleryAction
import com.johnkenedy.imageloadingnavigation.presentation.TravelGalleryState

@Composable
fun TravelGalleryScreenRoot(
    viewModel: TravelGalleryViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    TravelGalleryScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun TravelGalleryScreen(
    state: TravelGalleryState,
    onAction: (TravelGalleryAction) -> Unit,
) {

}

@Preview
@Composable
private fun Preview() {
    ImageLoadingNavigationTheme {
        TravelGalleryScreen(
            state = TravelGalleryState(),
            onAction = {}
        )
    }
}