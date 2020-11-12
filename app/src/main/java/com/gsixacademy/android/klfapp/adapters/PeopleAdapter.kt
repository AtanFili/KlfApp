package com.gsixacademy.android.klfapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.klfapp.R
import com.gsixacademy.android.klfapp.data.PeopleData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.about_tv

class PeopleAdapter(
    val peopleDatas:ArrayList<PeopleData>,
    val peopleDatasClickEvent:(PeopleDataClickEvent)->Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>

    (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_profile,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return peopleDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder=holder as MyViewHolder
        myViewHolder.bindData(peopleDatas[position],position)
    }
    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){

        fun bindData(peopleData: PeopleData,position: Int){
            itemView.imePrezime_tv.text=peopleData.name
            Picasso.get().load(peopleData.image).fit().into(itemView.profilePic_iv)

        }

    }
}