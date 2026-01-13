package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.johnkenedy.imageloadingnavigation.R
import com.johnkenedy.imageloadingnavigation.core.presentation.util.ObserveAsEvents
import com.johnkenedy.imageloadingnavigation.core.ui.theme.ImageLoadingNavigationTheme
import com.johnkenedy.imageloadingnavigation.core.ui.theme.backgroundMainGradient
import com.johnkenedy.imageloadingnavigation.gallery.domain.Destination
import com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations.components.DestinationCard
import com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations.components.IndicatorOrientation
import com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations.util.getDrawableIdForDestination

@Composable
fun TravelDestinationsScreenRoot(
    onNavigateToGallery: (List<String>) -> Unit,
    viewModel: TravelDestinationsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    
    ObserveAsEvents(viewModel.events) {
        when (it) {
            is TravelDestinationsEvent.NavigateToGallery -> onNavigateToGallery(it.imageUrls)
        }
    }

    TravelGalleryScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelGalleryScreen(
    state: TravelDestinationsState,
    onAction: (TravelDestinationsAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.backgroundMainGradient),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.winter_travel_gallery_title),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            items(
                items = state.destinations,
                key = { it.title }
            ) { destination ->
                val title = destination.title
                DestinationCard(
                    title = title,
                    imageRes = getDrawableIdForDestination(title),
                    indicatorOrientation = IndicatorOrientation.RIGHT,
                    onCardClick = {
                        onAction(
                            TravelDestinationsAction
                                .OnDestinationClick(destination.imageUrls)
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TravelGalleryScreenPreview() {
    ImageLoadingNavigationTheme {
        TravelGalleryScreen(
            state = TravelDestinationsState(
                destinations = listOf(
                    Destination("Alps", emptyList()),
                    Destination("Lapland", emptyList()),
                    Destination("Norway Fjords", emptyList()),
                    Destination("Iceland", emptyList()),
                    Destination("Swiss Villages", emptyList()),
                    Destination("Canadian Rockies", emptyList())
                )
            ),
            onAction = {}
        )
    }
}
