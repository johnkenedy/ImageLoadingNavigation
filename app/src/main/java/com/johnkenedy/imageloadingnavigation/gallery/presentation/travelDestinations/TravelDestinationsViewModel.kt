package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnkenedy.imageloadingnavigation.gallery.domain.DestinationDataSource
import com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery.route.GalleryRoute
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TravelDestinationsViewModel(
    private val dataSource: DestinationDataSource
) : ViewModel() {

    private val eventChannel = Channel<TravelDestinationsEvent>()
    val events = eventChannel.receiveAsFlow()
    private val _state = MutableStateFlow(TravelDestinationsState())
    val state = _state
        .onStart { loadDestinations() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = TravelDestinationsState()
        )

    private fun loadDestinations() {
        if (_state.value.destinations.isNotEmpty()) return
        
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            dataSource.getDestinations().collect { destinations ->
                _state.update { it.copy(
                    destinations = destinations,
                    isLoading = false
                ) }
            }
        }
    }

    fun onAction(action: TravelDestinationsAction) {
        when (action) {
            is TravelDestinationsAction.OnDestinationClick -> onDestinationClick(action.galleryRouteItem)

        }
    }

    private fun onDestinationClick(galleryRouteItem: GalleryRoute) {
        viewModelScope.launch {
            eventChannel.send(TravelDestinationsEvent.NavigateToGallery(galleryRouteItem = galleryRouteItem))
        }
    }
}
