package com.hall9zeha.stickyheader.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hall9zeha.stickyheader.common.entities.Person
import com.hall9zeha.stickyheader.databinding.PersonDetailListItemBinding

/**
 * Project Sticky Header
 * Created by Barry Zea H. on 2/05/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class MyAdapter(private val onClick:(entity:Person)->Unit): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private  var headerList:MutableList<Person> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemBinding = PersonDetailListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.onBind(headerList[position])
    }
    fun addAll(entityList:List<Person>){
        entityList.forEach { entity->
            //habilitar cuando no estemos usando una lista hardcode
            //if(!headerList.contains(entity)){
                headerList.add(entity)
                notifyItemInserted(headerList.size-1)
            //}
        }
    }
    override fun getItemCount()= headerList.size

    inner class ViewHolder(private val itemBinding: PersonDetailListItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(person:Person)= with(itemBinding){
            tvName.text = person.name
            tvLastName.text=person.lastName
            root.setOnClickListener { onClick(person) }
        }
    }
}