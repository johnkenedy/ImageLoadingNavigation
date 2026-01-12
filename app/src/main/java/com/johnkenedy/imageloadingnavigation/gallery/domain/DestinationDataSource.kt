package com.johnkenedy.imageloadingnavigation.domain

import kotlinx.coroutines.flow.Flow

interface DestinationDataSource {
    fun getDestinations(): Flow<List<Destination>>
}
