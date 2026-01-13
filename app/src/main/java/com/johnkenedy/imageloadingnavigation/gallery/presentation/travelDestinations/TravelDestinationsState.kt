package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations

import com.johnkenedy.imageloadingnavigation.gallery.domain.Destination

data class TravelDestinationsState(
    val destinations: List<Destination> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
