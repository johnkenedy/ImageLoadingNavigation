package com.johnkenedy.imageloadingnavigation.app.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {
    @Serializable
    data class Gallery(val imageUrls: List<String>): Route

    @Serializable
    object TravelDestinations: Route
}