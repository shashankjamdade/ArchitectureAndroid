package com.matrimony.demo.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.matrimony.demo.model.UserListResponse

@Dao
interface UserDao {

    @Query("SELECT * FROM UserListResponse")
    fun loadUserList(): LiveData<UserListResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserList(userListResponse: UserListResponse)

}
