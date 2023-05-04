package com.hall9zeha.stickyheader.view.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.hall9zeha.stickyheader.R
import com.hall9zeha.stickyheader.common.entities.Person
import com.hall9zeha.stickyheader.common.utils.requestLayoutForChangedDataset
import com.hall9zeha.stickyheader.databinding.PersonComponentViewBinding
import com.hall9zeha.stickyheader.databinding.PersonDetailListItemBinding


/****
 * Project Sticky Header
 * Created by Barry Zea H. on 3/5/23.
 * Copyright (c)  All rights reserved.
 ***/

class PersonComponentView:ConstraintLayout {

    private lateinit var binding: PersonComponentViewBinding
    private lateinit var personItemBinding: PersonDetailListItemBinding
    private lateinit var adapter: BookAdapter

    var persons: List<Person> = emptyList()
        set(value) {
            field = value
            onItemsUpdated()
        }

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    private fun init(context: Context) {
        binding = PersonComponentViewBinding.inflate(LayoutInflater.from(context), this, true)
        adapter = BookAdapter(context)
        binding.personDetail.adapter = adapter
    }

    private fun onItemsUpdated() {
        adapter.notifyDataSetChanged()
        binding.personDetail.requestLayoutForChangedDataset()
    }

    inner class BookAdapter(private val context: Context) : BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            val person: Person = persons[position]
            var view: View? = convertView

            if (view == null) {
                view = LayoutInflater.from(context)
                    .inflate(R.layout.person_detail_list_item, parent, false)
                personItemBinding = PersonDetailListItemBinding.bind(view)
                view.tag = personItemBinding
            } else {
                personItemBinding = view.tag as PersonDetailListItemBinding
            }

            personItemBinding.apply {
                tvName.text = person.name
                tvLastName.text = person.lastName

            }
            personItemBinding.root.setOnClickListener {
                Toast.makeText(personItemBinding.root.context, person.name, Toast.LENGTH_SHORT).show() }

            return personItemBinding.root
        }

        override fun getItem(position: Int): Any {
            return persons[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return persons.size
        }

        override fun isEnabled(position: Int): Boolean {
            return false
        }
    }

}