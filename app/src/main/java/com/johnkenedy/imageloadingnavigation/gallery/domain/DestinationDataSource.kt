package com.johnkenedy.imageloadingnavigation.gallery.domain

import kotlinx.coroutines.flow.Flow

interface DestinationDataSource {
    fun getDestinations(): Flow<List<Destination>>
}
