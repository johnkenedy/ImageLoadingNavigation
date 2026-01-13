package com.johnkenedy.imageloadingnavigation.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.johnkenedy.imageloadingnavigation.gallery.presentation.gallery.GalleryScreenRoot
import com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations.TravelDestinationsScreenRoot

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(elements = arrayOf(Route.TravelDestinations))

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryProvider = { key ->
            when (key) {
                is Route.TravelDestinations -> {
                    NavEntry(key) {
                        TravelDestinationsScreenRoot(
                            onNavigateToGallery = { imageUrls ->
                                backStack.add(Route.Gallery(imageUrls))
                            }
                        )
                    }
                }
                is Route.Gallery -> {
                    NavEntry(key) {
                        GalleryScreenRoot(
                            imageUrls = key.imageUrls,
                            onBackClick = {
                                backStack.removeAt(backStack.lastIndex)
                            }
                        )
                    }
                }
                else -> error("Unknown NavKey: $key")
            }

        }
    )

}