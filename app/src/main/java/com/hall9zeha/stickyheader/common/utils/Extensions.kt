package com.hall9zeha.stickyheader.common.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.widget.ListView


/****
 * Project Sticky Header
 * Created by Barry Zea H. on 3/5/23.
 * Copyright (c)  All rights reserved.
 ***/


fun getPixels(dipValue: Int, context: Context): Int {
    val r: Resources = context.resources
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dipValue.toFloat(),
        r.displayMetrics
    ).toInt()
}
