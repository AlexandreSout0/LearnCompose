package com.alx.learncompose.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var SuperHeroName: String,
    var RealName: String,
    var publisher: String,
    @DrawableRes var photo: Int
) {


}
