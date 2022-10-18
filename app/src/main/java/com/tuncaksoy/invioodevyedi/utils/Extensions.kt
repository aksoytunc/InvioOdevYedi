package com.tuncaksoy.invioodevyedi.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gecisYap(v: View, id: Int) {
    findNavController(v).navigate(id)
}

fun Navigation.gecisYap(v: View, nd: NavDirections) {
    findNavController(v).navigate(nd)
}