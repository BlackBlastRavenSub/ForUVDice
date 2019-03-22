package com.blackblastraven.foruvdice

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DiceDataDao {
    //追加
    @Insert
    fun insertDiceData(diceData: DiceData)

    //クエリ
    @Query("SELECT * FROM DiceData")
    fun getAll():List<DiceData>
/*
    @Query("SELECT * FROM dicedata")
    fun getAll(): List<UserDao>

    @Query("SELECT * FROM dicedata WHERE diceId IN (:diceId)")
    fun loadAllByIds(diceId: IntArray): List<DiceDataDao>

    @Query("SELECT * FROM dicedata WHERE number LIKE :number AND " +
            "probability LIKE :probability LIMIT 1")
    fun findByNumber(number: Int): DiceDataDao
    fun findByProbability(probability: Int): DiceDataDao

    @Insert
    fun insertAll(vararg dicedatas: DiceDataDao)
    fun insertNumber(vararg numbers: Int)
    fun insertProbability(vararg probability: Int)

    @Delete
    fun delete(dicedata: DiceDataDao)
    */
}