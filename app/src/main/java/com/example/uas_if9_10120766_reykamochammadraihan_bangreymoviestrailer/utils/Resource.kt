package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.utils

import androidx.annotation.Nullable

class Resource<T> private constructor(val status: Status, @field:Nullable @param:Nullable var data: T?,
                                      @field:Nullable @param:Nullable val message: String?) {
    enum class Status {
        SUCCESS, ERROR
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String?): Resource<T> {
            return Resource(Status.ERROR, null, msg)
        }
    }
}