package com.sahu.appsetup.ext

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragment(
    @IdRes containerId: Int,
    fragment: Fragment,
    tag: String,
    sharedElements: List<Pair<View, String>> = emptyList(),
    addToStack: Boolean = true
) {
    val transaction = supportFragmentManager.beginTransaction()

    if (sharedElements.isNotEmpty()) transaction.setReorderingAllowed(true)

    sharedElements.forEach { pair ->
        transaction.addSharedElement(pair.first, pair.second)
    }

    transaction.replace(containerId, fragment, tag)

    if (addToStack) transaction.addToBackStack(null)

    transaction.commit()
}