package com.gsixacademy.android.klfapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import com.gsixacademy.android.klfapp.data.PeopleModel

class MainActivity : AppCompatActivity() {
lateinit var database:DatabaseReference
    var peopleModel: PeopleModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database=FirebaseDatabase.getInstance().reference

        initaliseFireBaseDatabase()

    }

    private fun initaliseFireBaseDatabase(){
        val postListener= object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                //no implementation yet
            }
            override  fun onDataChange(snapshot: DataSnapshot) {
                peopleModel=snapshot.getValue(PeopleModel::class.java)

            }

        }
        database.addValueEventListener(postListener)

    }

}