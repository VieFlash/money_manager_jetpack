package com.example.keeper.room.wallet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WalletDao {
    @Insert
    suspend fun insert(vararg wallet: Wallet)

    @Query("DELETE FROM wallet WHERE walletID = :walletID")
    suspend fun delete(walletID: Int)

    @Query("SELECT * FROM wallet")
    suspend fun get(): List<Wallet>
}