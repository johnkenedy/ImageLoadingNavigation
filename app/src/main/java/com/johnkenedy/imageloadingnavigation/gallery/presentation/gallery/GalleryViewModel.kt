package com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class GalleryViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(GalleryState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = GalleryState()
        )

    fun onAction(action: GalleryAction) {
        when (action) {
            is GalleryAction.OnImageClick -> onImageClick(action.imageUrl)
            is GalleryAction.OnDismissImage -> onDismissImage()
        }
    }


    private fun onImageClick(imageUrl: String) {
        _state.update { it.copy(selectedImageUrl = imageUrl) }
    }

    private fun onDismissImage() {
        _state.update { it.copy(selectedImageUrl = null) }
    }

}