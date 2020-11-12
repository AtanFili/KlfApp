package com.gsixacademy.android.klfapp.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class PeopleData():Parcelable {
    var about:String?=null
    var contact:String?=null
    var facebook:String?=null
    var instagram:String?=null
    var image:String?=null
    var name:String?=null

    constructor(parcel:Parcel):this (){
        about=parcel.readString()
        contact=parcel.readString()
        facebook=parcel.readString()
        instagram=parcel.readString()
        name=parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(about)
        parcel.writeString(contact)
        parcel.writeString(facebook)
        parcel.writeString(instagram)
        parcel.writeString(name)

    }

    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR:Parcelable.Creator<PeopleData>{
        override fun createFromParcel(parcel: Parcel): PeopleData {
            return PeopleData(parcel)
        }

        override fun newArray(size: Int): Array<PeopleData?> {
            return arrayOfNulls(size)
        }
    }

}


