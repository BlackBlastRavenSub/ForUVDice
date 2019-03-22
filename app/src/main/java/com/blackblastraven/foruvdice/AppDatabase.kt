package com.blackblastraven.foruvdice

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DiceData::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    //abstract fun userDao(): UserDao
    abstract fun DiceDataDao():DiceDataDao
}
/*
entities=要素数?
annotated=?
 */