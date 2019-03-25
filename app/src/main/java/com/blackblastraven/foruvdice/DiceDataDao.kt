package com.blackblastraven.foruvdice

import androidx.room.*

@Dao
interface DiceDataDao {

    //プランA用のデータシステム

    //データの初回登録時
    @Insert
    fun createDiceDaia(diceData: DiceData)

    //ダイスデータの更新
    @Update
    fun updateDiceData(diceData: DiceData)

    //1列分のダイスデータをdiceIdから検索
    @Query("SELECT * FROM DiceData WHERE diceId=:diceId")
    fun searchFromId(diceId: Int): List<DiceData>

    //ダイスデータの削除(今回のプログラムでは削除は必要ないのでは?)
    @Query("DELETE FROM DiceData")
    fun allDelite()

    //プランA用のデータシステムはここまで

    //テストデータ
    //追加
    @Insert
    fun insertDiceData(diceData: DiceData)

    //クエリ
    @Query("SELECT * FROM DiceData")
    fun getAll(): List<DiceData>

/*
    見本?
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