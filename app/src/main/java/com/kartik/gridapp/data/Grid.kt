package com.kartik.gridapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Grid(
    @StringRes val stringResourceId :Int,
    val numberCourses:Int,
    @DrawableRes val imageResourceId: Int
)