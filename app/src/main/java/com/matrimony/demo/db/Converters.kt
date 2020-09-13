package com.matrimony.demo.db

import androidx.room.TypeConverter
import com.matrimony.demo.model.UserListResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

//    UserList Response
    @TypeConverter // To convert DB dataObject into JSON string and insert in DB
    fun fromMapUserResponse(list: ArrayList<UserListResponse.ResultUserItem>): String {
        val listType = object : TypeToken<ArrayList<UserListResponse.ResultUserItem>>() {}.type
        return Gson().toJson(list, listType)
    }

    @TypeConverter // To convert JSON string into dataObject and fetch the data
    fun toMapUserResponse(value: String): ArrayList<UserListResponse.ResultUserItem>? {
        val listType = object : TypeToken<ArrayList<UserListResponse.ResultUserItem>>() {}.type
        return Gson().fromJson<ArrayList<UserListResponse.ResultUserItem>>(value, listType)
    }

}
