package com.connor.composedemo.destinations.api.model

import androidx.annotation.DrawableRes

data class Destination(@DrawableRes val flag: Int, val cityTown: String, val country: String)