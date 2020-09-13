package com.matrimony.demo.model


//import Dob
//import Id
//import Info
//import Location
//import Login
//import Name
//import Picture
//import Registered
//import Timezone
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.matrimony.demo.db.Converters
import com.google.gson.annotations.SerializedName

@Entity
@TypeConverters(Converters::class)
data class UserListResponse(
    @PrimaryKey//(autoGenerate = true)
    var id: Int = 2,
    @SerializedName("results")
    var results: ArrayList<ResultUserItem>? = ArrayList()
//    @Embedded
//    @SerializedName("info")
//    var info: Info? = Info()
) {
    data class ResultUserItem(
        @SerializedName("nat")
        var nat: String? = "",
        @SerializedName("gender")
        var gender: String? = "",
        @SerializedName("phone")
        var phone: String? = "",
        @Embedded
        @SerializedName("dob")
        var dob: Dob? = Dob(),
        @Embedded
        @SerializedName("name")
        var name: Name? = Name(),
        @Embedded
        @SerializedName("registered")
        var registered: Registered? = Registered(),
        @Embedded
        @SerializedName("location")
        var location: Location? = Location(),
        @Embedded
        @SerializedName("id")
        var id: Id? = Id(),
        @Embedded
        @SerializedName("login")
        var login: Login? = Login(),
        @SerializedName("cell")
        var cell: String? = "",
        @SerializedName("email")
        var email: String? = "",
        @Embedded
        @SerializedName("picture")
        var picture: Picture? = Picture()
    )
}


data class Coordinates(@SerializedName("latitude")
                       val latitude: String? = "",
                       @SerializedName("longitude")
                       val longitude: String? = "")


data class Login(@SerializedName("sha1")
                 val sha: String? = "",
                 @SerializedName("password")
                 val password: String? = "",
                 @SerializedName("salt")
                 val salt: String? = "",
                 @SerializedName("sha256")
                 val sha256: String? = "",
                 @SerializedName("uuid")
                 val uuid: String? = "",
                 @SerializedName("username")
                 val username: String? = "",
                 @SerializedName("md5")
                 val md: String? = "")


data class Info(@SerializedName("seed")
                val seed: String? = "",
                @SerializedName("page")
                val page: Int = 0,
                @SerializedName("results")
                val results: String? = "",
                @SerializedName("version")
                val version: String? = "")


data class Name(@SerializedName("last")
                val last: String? = "",
                @SerializedName("title")
                val title: String? = "",
                @SerializedName("first")
                val first: String? = "")


data class Dob(@SerializedName("date")
               val date: String? = "",
               @SerializedName("age")
               val age: String? = "")


data class Picture(@SerializedName("thumbnail")
                   val thumbnail: String? = "",
                   @SerializedName("large")
                   val large: String? = "",
                   @SerializedName("medium")
                   val medium: String? = "")


data class Street(@SerializedName("number")
                  val number: String? = "",
                  @SerializedName("name")
                  val name: String? = "")


data class Id(@SerializedName("name")
              val name: String? = "",
              @SerializedName("value")
              val value: String? = "")


data class Registered(@SerializedName("date")
                      val date: String? = "",
                      @SerializedName("age")
                      val age: String? = "")


data class Location(@SerializedName("country")
                    val country: String = "",
                    @SerializedName("city")
                    val city: String = "",
                    @SerializedName("street")
                    val street: Street? = Street(),
                    @SerializedName("timezone")
                    val timezone: Timezone = Timezone(),
                    @SerializedName("postcode")
                    val postcode: String? = "",
                    @SerializedName("coordinates")
                    val coordinates: Coordinates? = Coordinates(),
                    @SerializedName("state")
                    val state: String? = "")



data class Timezone(@SerializedName("offset")
                    var offset: String? = "",
                    @SerializedName("description")
                    var description: String? = "")








