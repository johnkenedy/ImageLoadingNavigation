package com.johnkenedy.imageloadingnavigation.domain

import com.johnkenedy.imageloadingnavigation.gallery.domain.Destination
import kotlinx.coroutines.flow.Flow

interface DestinationDataSource {
    fun getDestinations(): Flow<List<Destination>>
}
