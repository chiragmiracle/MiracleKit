package com.miracle.miraclekit.Model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.miracle.miraclekit.R
import kotlin.random.Random

@Immutable
data class Place(
    val id: Long,
    val description: String,
    @DrawableRes val imgRes: Int,
    val rating: Double = Random.nextDouble(0.0, 10.0),
    val price: Int = Random.nextInt(500)
)

val places = listOf(
    Place(1, "France", R.drawable.landscape1),
    Place(2, "India", R.drawable.landscape2),
    Place(3, "China", R.drawable.landscape3),
    Place(4, "Egypt", R.drawable.landscape4),
    Place(5, "UAE", R.drawable.landscape5),
    Place(6, "Indonesia", R.drawable.landscape6),
    Place(7, "Australia", R.drawable.landscape7),
    Place(8, "New Zealand", R.drawable.landscape8),
    Place(9, "England", R.drawable.landscape9),
    Place(10, "Maldives", R.drawable.landscape10),
    Place(11, "Bangkok", R.drawable.landscape11),
    Place(12, "Greece", R.drawable.landscape12),
)