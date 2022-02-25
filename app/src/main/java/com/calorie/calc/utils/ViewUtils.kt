package com.calorie.calc.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import androidx.interpolator.view.animation.FastOutSlowInInterpolator


fun View.animateRotation(duration: Long, targetRotation: Int) {

    animate().setListener(null).cancel()
    animate()
            .rotation(targetRotation.toFloat()).setDuration(duration)
            .setInterpolator(FastOutSlowInInterpolator())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationCancel(animation: Animator) {
                    rotation = targetRotation.toFloat()
                }

                override fun onAnimationEnd(animation: Animator) {
                    rotation = targetRotation.toFloat()
                }
            }).start()
}