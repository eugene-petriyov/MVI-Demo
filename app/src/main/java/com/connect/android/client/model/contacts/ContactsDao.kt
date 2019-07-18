package com.connect.android.client.model.contacts

import androidx.room.*
import com.connect.android.client.model.profile.User
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface ContactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContacts(items: List<User>): Completable

    @Delete
    fun deleteContacts(items: List<User>): Completable

    @Query("SELECT * FROM contacts")
    fun getContacts(): Flowable<List<User>>

    @Query("SELECT * FROM contacts WHERE name GLOB '*' || :query|| '*'")
    fun getContacts(query: String): Flowable<List<User>>
}