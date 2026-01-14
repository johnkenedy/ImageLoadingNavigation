package com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery

sealed interface GalleryAction {
    data class OnImageClick(val imageUrl: String) : GalleryAction
    data object OnDismissImage : GalleryAction
}