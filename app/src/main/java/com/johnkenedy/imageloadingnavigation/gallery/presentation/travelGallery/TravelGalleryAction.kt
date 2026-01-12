package com.johnkenedy.imageloadingnavigation.presentation

sealed interface TravelGalleryAction {
    data class OnDestinationClick(val imageUrls: List<String>) : TravelGalleryAction
}
