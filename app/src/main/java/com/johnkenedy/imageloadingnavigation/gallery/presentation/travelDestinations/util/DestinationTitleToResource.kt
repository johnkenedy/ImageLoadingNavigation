package com.johnkenedy.imageloadingnavigation.gallery.presentation.travelDestinations.util

import com.johnkenedy.imageloadingnavigation.R

fun getDrawableIdForDestination(destinationTitle: String): Int {
    return when (destinationTitle.lowercase()) {
        "alps" -> R.drawable.alps
        "lapland" -> R.drawable.lapland
        "norway fjords" -> R.drawable.norway_fjords
        "iceland" -> R.drawable.iceland
        "swiss villages" -> R.drawable.swiss_villages
        "canadian rockies" -> R.drawable.canadian_rockies
        else -> R.drawable.alps
    }
}