package com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery.route

import com.johnkenedy.imageloadingnavigation.gallery.domain.Destination
import kotlinx.serialization.Serializable

@Serializable
data class GalleryRoute(
    val title: String,
    val imageUrls: List<String>
)

fun Destination.toGalleryRoute() = GalleryRoute(
    title = title,
    imageUrls = imageUrls
)