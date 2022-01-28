package com.calorie.calc.utils.progressbar;

import android.content.Context

fun Context.dp(valueInDp: Int): Int = (valueInDp * resources.displayMetrics.density).toInt()
