package com.gsixacademy.android.klfapp.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.gsixacademy.android.klfapp.R

import kotlinx.android.synthetic.main.botom_navigation.view.*

class BotomNavigation:FrameLayout {
    internal  lateinit var mInflater:LayoutInflater

    constructor(context: Context):super(context){
        init(context)
    }
    constructor(context: Context,attr:AttributeSet?,style:Int):super(context,attr,style){
        init(context)

    }
    constructor(context: Context,attr: AttributeSet?):super(context,attr){
        init(context)
    }

    fun init(context: Context){
        mInflater=LayoutInflater.from(context)
        mInflater.inflate(R.layout.botom_navigation,this,true)
    }
    fun setSelectedTab(tabToSelect:Int){

        facebook_tv.isSelected=tabToSelect == 1
        instagram_tv.isSelected=tabToSelect==2
        call_tv.isSelected=tabToSelect==3

    }
}