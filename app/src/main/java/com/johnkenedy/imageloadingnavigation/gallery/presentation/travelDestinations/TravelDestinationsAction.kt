package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations

import com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery.route.GalleryRoute

sealed interface TravelDestinationsAction {
    data class OnDestinationClick(val galleryRouteItem: GalleryRoute) : TravelDestinationsAction
}
