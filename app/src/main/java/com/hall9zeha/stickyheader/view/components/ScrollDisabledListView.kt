package com.hall9zeha.stickyheader.view.components

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ListView


/****
 * Project Sticky Header
 * Created by Barry Zea H. on 3/5/23.
 * Copyright (c)  All rights reserved.
 ***/

class ScrollDisabledListView:ListView {
 constructor(context: Context?) : super(context) {}
 constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
 constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
  context,
  attrs,
  defStyle
 ) { }

 override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
  val measuredHeight = MeasureSpec.makeMeasureSpec(
   Int.MAX_VALUE shr 2, MeasureSpec.AT_MOST
  )
  super.onMeasure(widthMeasureSpec, measuredHeight)
  val params: ViewGroup.LayoutParams = layoutParams
  params.height = measuredHeight
 }
}