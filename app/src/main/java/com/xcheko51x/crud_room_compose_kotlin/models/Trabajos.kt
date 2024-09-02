package com.xcheko51x.crud_room_compose_kotlin.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "usuarios")
data class Trabajos(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("desciption")
    val desciption: String,
    @ColumnInfo("status")
    val status: Boolean
)