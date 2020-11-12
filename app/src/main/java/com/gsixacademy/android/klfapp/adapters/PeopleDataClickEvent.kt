package com.gsixacademy.android.klfapp.adapters

import com.gsixacademy.android.klfapp.data.PeopleData

open class PeopleDataClickEvent {

    data class PeopleDataItemClicked(val peopleData: PeopleData):PeopleDataClickEvent()

}
