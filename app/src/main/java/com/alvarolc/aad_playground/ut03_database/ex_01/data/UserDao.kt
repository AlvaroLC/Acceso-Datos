package com.alvarolc.aad_playground.ut03_database.ex_01.data

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>

    //Obtener todos los users donde el id sea = 1

    @Query("SELECT * FROM user WHERE id= :id")
    fun findById(id: Int): UserEntity?

    //Obtener todos los user que esten en un listado de ID

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun findAllByIds(userIds: IntArray): UserEntity?

    //Obtener todos los users donde el name parecido a un paratmetro
    //y el username parecido a otro parametro y devuelva un valor

    @Query("SELECT * FROM user WHERE name LIKE :name AND username LIKE :username LIMIT 1")
    fun findByName(name: String, username: String): UserEntity?

    @Insert
    fun insert(userEntity: UserEntity)

    @Delete
    fun delete(userEntity: UserEntity)

    @Update
    fun update(userEntity: UserEntity)
}