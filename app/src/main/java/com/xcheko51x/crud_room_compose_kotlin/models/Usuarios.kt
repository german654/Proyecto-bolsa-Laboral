package com.xcheko51x.crud_room_compose_kotlin.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuarios(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("usuario")
    val usuario: String,
    @ColumnInfo("email")
    val email: String
)

@Entity(tableName = "id")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "nombre_rs")
    val nombreRS: String? = null,
    @ColumnInfo(name = "dni")
    val dni: String? = null,
    @ColumnInfo(name = "ruc")
    val ruc: String? = null,
    @ColumnInfo(name = "correo")
    val correo: String? = null,
    @ColumnInfo(name = "celular")
    val celular: String? = null,
    @ColumnInfo(name = "rol")
    val rol: String? = null,
    @ColumnInfo(name = "user")
    val user: String? = null,
    @ColumnInfo(name = "pasword")
    val password: String? = null,
    @ColumnInfo(name = "archivo_cv")
    val archivoCV: String? = null
)