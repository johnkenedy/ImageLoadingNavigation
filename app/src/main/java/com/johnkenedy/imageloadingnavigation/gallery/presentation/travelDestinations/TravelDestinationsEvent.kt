package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations

import com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery.route.GalleryRoute

interface TravelDestinationsEvent {
    data class NavigateToGallery(val galleryRouteItem: GalleryRoute) : TravelDestinationsEvent
}