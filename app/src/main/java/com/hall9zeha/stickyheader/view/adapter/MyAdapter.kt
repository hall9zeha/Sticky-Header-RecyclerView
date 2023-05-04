package com.hall9zeha.stickyheader.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.hall9zeha.stickyheader.common.entities.Person
import com.hall9zeha.stickyheader.databinding.StickyHeaderItemBinding

/**
 * Project Sticky Header
 * Created by Barry Zea H. on 2/05/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private  var headerList:List<Char> = arrayListOf()
    var personData:Map<Char, List<Person>> = emptyMap()
        set(value){
            field = value
            headerList = personData.keys.toList()
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemBinding = StickyHeaderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position >= 0 && position < headerList.size) {
            holder.onBind(headerList[position])
        }

    }

    override fun getItemCount()= headerList.size
    fun getHeaderForCurrentPosition(position:Int) = if(position in headerList.indices){headerList[position]} else ""
    inner class ViewHolder(private val itemBinding: StickyHeaderItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(header:Char)= with(itemBinding){
            tvHeader.text = header.toString()
            personData[header]?.let { persons->
                personGroupDetail.persons=persons
                
            }
        }
    }
}