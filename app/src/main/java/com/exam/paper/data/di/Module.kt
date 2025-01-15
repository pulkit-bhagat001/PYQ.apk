package com.exam.paper.data.di

import com.exam.paper.data.Repository.Repository
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun getFirebaseDbInstance():FirebaseDatabase=FirebaseDatabase.getInstance()

    @Provides
    @Singleton
    fun getRepoInstance(firebaseDatabase: FirebaseDatabase):Repository=Repository(firebaseDatabase)

}