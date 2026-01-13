package com.johnkenedy.imageloadingnavigation.gallery.di

import com.johnkenedy.imageloadingnavigation.gallery.data.DestinationDataSourceImpl
import com.johnkenedy.imageloadingnavigation.gallery.domain.DestinationDataSource
import com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery.GalleryViewModel
import com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations.TravelDestinationsViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val destinationsModule = module {
    singleOf(::DestinationDataSourceImpl) bind DestinationDataSource::class

    viewModelOf(::TravelDestinationsViewModel)
    viewModelOf(::GalleryViewModel)
}