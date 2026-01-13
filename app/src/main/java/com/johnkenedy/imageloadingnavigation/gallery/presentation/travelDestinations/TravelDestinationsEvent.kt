package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations

interface TravelDestinationsEvent {
    data class NavigateToGallery(val imageUrls: List<String>) : TravelDestinationsEvent
}