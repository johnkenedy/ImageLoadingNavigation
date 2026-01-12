package com.johnkenedy.imageloadingnavigation.presentation

import com.johnkenedy.imageloadingnavigation.domain.Destination

data class TravelGalleryState(
    val destinations: List<Destination> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
