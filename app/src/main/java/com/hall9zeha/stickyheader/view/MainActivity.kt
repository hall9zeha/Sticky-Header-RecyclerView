package com.hall9zeha.stickyheader.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hall9zeha.stickyheader.R
import com.hall9zeha.stickyheader.common.entities.Person
import com.hall9zeha.stickyheader.common.utils.StickyHeaderDecoration
import com.hall9zeha.stickyheader.databinding.ActivityMainBinding
import com.hall9zeha.stickyheader.view.adapter.MyAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var bind:ActivityMainBinding
    private lateinit var adapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setUpAdapter()
    }
    private fun setUpAdapter()= with(bind){
        adapter= MyAdapter()
        val personList = listOf(
            Person("Martha","N"),
            Person("Martha","N"),
            Person("Martha","N"),
            Person("Martha","N"),
            Person("Martha","N"),
            Person("Martha","N"),
            Person("Martha","N"),
            Person("Martha","N"),
            Person("Martha","N"),
            Person("Barry","Zea"),
            Person("Barry","Zea"),
            Person("Barry","Zea"),
            Person("Barry","Zea"),
            Person("Barry","Zea"),
            Person("Barry","Zea"),
            Person("Barry","Zea"),
            Person("Barry","Zea"),
            Person("Barry","Zea"),
            Person("Barry","Zea"),
        )
        val groupedPersons:Map<Char, List<Person>> = personList.groupBy { person-> person.name.first()
            .uppercaseChar() }
        adapter.personData= groupedPersons.toSortedMap()
        rvPersons.addItemDecoration(StickyHeaderDecoration(adapter,root))
        rvPersons.layoutManager=LinearLayoutManager(this@MainActivity)
        rvPersons.adapter=adapter

    }
}