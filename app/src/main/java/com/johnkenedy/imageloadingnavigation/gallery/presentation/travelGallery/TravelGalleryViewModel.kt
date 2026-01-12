package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelGallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnkenedy.imageloadingnavigation.domain.DestinationDataSource
import com.johnkenedy.imageloadingnavigation.presentation.TravelGalleryAction
import com.johnkenedy.imageloadingnavigation.presentation.TravelGalleryState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TravelGalleryViewModel(
    private val repository: DestinationDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(TravelGalleryState())
    val state = _state
        .onStart { loadDestinations() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = TravelGalleryState()
        )

    private fun loadDestinations() {
        if (_state.value.destinations.isNotEmpty()) return
        
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            repository.getDestinations().collect { destinations ->
                _state.update { it.copy(
                    destinations = destinations,
                    isLoading = false
                ) }
            }
        }
    }

    fun onAction(action: TravelGalleryAction) {
        when (action) {
            is TravelGalleryAction.OnDestinationClick -> onDestinationClick(action.imageUrls)

        }
    }

    private fun onDestinationClick(imageUrls: List<String>) {
        // TODO
    }
}
