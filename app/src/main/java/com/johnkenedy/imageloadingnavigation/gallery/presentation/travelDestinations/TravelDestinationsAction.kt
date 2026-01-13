package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations

sealed interface TravelDestinationsAction {
    data class OnDestinationClick(val imageUrls: List<String>) : TravelDestinationsAction
}
