package com.matrimony.demo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matrimony.demo.db.dao.UserDao
import com.matrimony.demo.model.UserListResponse
import com.matrimony.demo.persistence.Note
import com.matrimony.demo.persistence.NoteDao


// - Database Class
@Database(entities = [Note::class, UserListResponse::class],version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun userDao(): UserDao
}