package com.example.antiseptic.data

import android.media.Image
import java.io.Serializable
//서버에서 오는 데이터 응답 값.
data class DataSignUp(
    val email : String,
    val password: String,
    val name : String

):Serializable