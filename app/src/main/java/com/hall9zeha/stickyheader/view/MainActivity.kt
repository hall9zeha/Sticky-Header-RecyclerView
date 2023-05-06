package com.hall9zeha.stickyheader.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hall9zeha.stickyheader.common.entities.Person
import com.hall9zeha.stickyheader.common.entities.getDummyDataSource
import com.hall9zeha.stickyheader.common.utils.StickyHeaderDecoration
import com.hall9zeha.stickyheader.databinding.ActivityMainBinding
import com.hall9zeha.stickyheader.view.adapter.MyAdapter

class MainActivity : AppCompatActivity(){
    private lateinit var bind:ActivityMainBinding
    private lateinit var adapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setUpAdapter()
    }
    private fun setUpAdapter()= with(bind){
        adapter= MyAdapter(::onClickItemAdapter)

        adapter.addAll(getDummyDataSource())
        rvPersons.addItemDecoration(StickyHeaderDecoration(
           true,::isSection,::getHeader))
        rvPersons.layoutManager=LinearLayoutManager(this@MainActivity)
        rvPersons.adapter=adapter

    }
    private fun isSection(position:Int):Boolean{
        val persons = getDummyDataSource()
        return position ==0 ||
                persons[position].name.first().toString() != persons[position - 1].name.first().toString()
    }
    private fun getHeader(position:Int):String{
        val persons = getDummyDataSource()
        return persons[position].name.first().uppercaseChar().toString()
    }
    private fun onClickItemAdapter(person: Person){
        Toast.makeText(this, person.name, Toast.LENGTH_SHORT).show()
    }

}