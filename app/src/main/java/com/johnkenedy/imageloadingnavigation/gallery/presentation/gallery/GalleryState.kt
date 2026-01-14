package com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery

data class GalleryState(
    val paramOne: String = "default",
    val paramTwo: List<String> = emptyList(),
    val selectedImageUrl: String? = null,
)