package com.hall9zeha.stickyheader.common.utils

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.hall9zeha.stickyheader.R
import com.hall9zeha.stickyheader.databinding.StickyHeaderItemBinding
import kotlin.math.max


/**
 * Project Sticky Header
 * Created by Barry Zea H. on 2/05/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class StickyHeaderDecoration(private val sticky:Boolean,
                             private val isSection:(position:Int)->Boolean,
                             private val getHeader:(position:Int)->String): ItemDecoration() {

    private var headerBinding:StickyHeaderItemBinding?=null
    private  var headerView:View?=null
    //
    private  var headerOffSet:Int= 30

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        //headerOffSet = parent.context.resources?.getDimensionPixelSize(R.dimen.height_header)!!
        headerOffSet = getPixels(45,parent.context)
        if (isSection(position)) {
            outRect.top = headerOffSet
        }

    }

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(canvas, parent, state)

        if(headerView == null){
            headerView = LayoutInflater.from(parent.context).inflate(R.layout.sticky_header_item,parent,false)
            headerBinding= StickyHeaderItemBinding.bind(headerView!!)

            fixLayoutHeaderView(headerView!!, parent)
        }
        var charHeader=""
        for(i in 0 until parent.childCount ){
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)
            val headerTitle=getHeader(position)
            headerBinding?.tvHeader?.text= headerTitle
            if(charHeader != headerTitle || isSection(position)){
                canvas.drawHeaderView(child,headerView)
                charHeader = headerTitle
            }
        }
    }

    private fun fixLayoutHeaderView(headerView: View, parent: ViewGroup) {
        val widthSpec = MeasureSpec.makeMeasureSpec(
            parent.width,
            MeasureSpec.EXACTLY
        )
        val heightSpec = MeasureSpec.makeMeasureSpec(
            parent.height,
            MeasureSpec.UNSPECIFIED
        )

        val childWidth = ViewGroup.getChildMeasureSpec(
            widthSpec,
            parent.paddingLeft + parent.paddingRight,
            headerView.layoutParams.width
        )
        val childHeight = ViewGroup.getChildMeasureSpec(
            heightSpec,
            parent.paddingTop + parent.paddingBottom,
            headerView.layoutParams.height
        )
        headerView.measure(childWidth, childHeight)
        headerView.layout(0, 0, headerView.measuredWidth, headerView.measuredHeight)
    }
    private fun Canvas.drawHeaderView(child: View?, header:View?){
        save()
        if(sticky){
            translate(0f, max(0,child?.top!! - header?.height!!).toFloat())
        }else{
            translate(0f, (child?.top!! - header?.height!!).toFloat())
        }
        headerView?.draw(this)
        restore()
    }

}