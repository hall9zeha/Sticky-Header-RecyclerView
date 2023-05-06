package com.hall9zeha.stickyheader.common.entities


/****
 * Project Sticky Header
 * Created by Barry Zea H. on 3/5/23.
 * Copyright (c)  All rights reserved.
 ***/

data class Person(var name:String="", var lastName:String="")
fun getDummyDataSource():List<Person>{
    return listOf(
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
        Person("Barry","Zea"))
}
