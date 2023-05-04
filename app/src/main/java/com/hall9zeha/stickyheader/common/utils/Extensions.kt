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
fun ListView.requestLayoutForChangedDataset() {

    val listAdapter = this.adapter
    listAdapter?.let { adapter ->
        val itemCount = adapter.count

        var totalHeight = 0
        for (position in 0 until itemCount) {
            val item = adapter.getView(position, null, this)
            item.measure(0, 0)

            totalHeight += item.measuredHeight

            val layoutParams = this.layoutParams
            layoutParams.height = totalHeight
            this.requestLayout()
        }
    }
}

