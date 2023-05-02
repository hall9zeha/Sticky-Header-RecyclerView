package com.hall9zeha.stickyheader.common.utils

import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.hall9zeha.stickyheader.databinding.StickyHeaderItemBinding
import com.hall9zeha.stickyheader.view.adapter.MyAdapter

/**
 * Project Sticky Header
 * Created by Barry Zea H. on 2/05/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class StickyHeaderDecoration(private val adapter:MyAdapter, root:View):ItemDecoration() {

    private val headerBinding by lazy {StickyHeaderItemBinding.inflate(LayoutInflater.from(root.context))}
    private val headerView:View
    get() = headerBinding.root

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val topChild = parent.getChildAt(0)
        val secondChild = parent.getChildAt(1)

        parent.getChildAdapterPosition(topChild)
            .let{topChildPosition->

            }
    }

}