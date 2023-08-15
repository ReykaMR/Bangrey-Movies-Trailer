package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.room.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TVShowEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "showId")
        var showId: String,

        @ColumnInfo(name = "showTitle")
        var showTitle: String,

        @ColumnInfo(name = "moviePoster")
        var showPoster: String,
)