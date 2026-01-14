package com.johnkenedy.imageloadingnavigation.app.navigation

import androidx.navigation3.runtime.NavKey
import com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery.route.GalleryRoute
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {
    @Serializable
    data class Gallery(val galleryRouteItem: GalleryRoute): Route

    @Serializable
    object TravelDestinations: Route
}