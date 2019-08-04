package com.connect.android.client.model.profile

import android.text.TextUtils
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.connect.android.client.model.educations.EducationData
import com.connect.android.client.model.works.WorkData
import com.squareup.moshi.Json
import java.io.Serializable

data class AvatarResponse(val url: String)

data class ConnectResponse(val status: String)

data class FieldsResponse(val totalCount: Int?, val data: List<String>?)

@Entity(tableName = "contacts")
open class User @JvmOverloads constructor(
    val name: String,
    val avatarMedium: String? = null,
    @PrimaryKey
    val id: String,
    val gender: String? = null,
    val about: String? = null,
    val skills: List<String>? = null,
    val goals: List<String>? = null,
    val fields: List<String>? = null,
    val avatar: String? = null,
    val avatarBig: String? = null,
    val works: List<WorkData>? = null,
    val educations: List<EducationData>? = null,
    val distance: Double? = null,
    @Json(name = "object")
    val obj: String = "user",
    val connectionType: ConnectionType? = null
): Serializable {

    fun getWorkInfo(): String? {
        val work = works?.let {
            if (it.isNotEmpty()) {
                (it[0].company ?: "") +
                        (if (!TextUtils.isEmpty(it[0].company)
                            && !TextUtils.isEmpty(it[0].position)
                        ) ", " else "") +
                        it[0].position
            } else {
                ""
            }
        }
        return work
    }
}

@Entity(tableName = "user")
class Me @JvmOverloads constructor(
    name: String,
    avatarMedium: String? = null,
    id: String,
    gender: String? = null,
    about: String? = null,
    skills: List<String>? = null,
    goals: List<String>? = null,
    fields: List<String>? = null,
    avatar: String? = null,
    avatarBig: String? = null,
    works: List<WorkData>? = null,
    educations: List<EducationData>? = null,
    distance: Double? = null,
    @Json(name = "object")
    obj: String = "user",
    connectionType: ConnectionType? = null,
    val settings: Settings? = null
) : User(
    name, avatarMedium, id, gender, about,
    skills, goals, fields, avatar, avatarBig, works,
    educations, distance, obj, connectionType
)

data class Settings(
    @Json(name = "SHOW_DISTANCE")
    val showDistance: String? = "Y",
    @Json(name = "SHOW_RATIING")
    val showRating: String? = "Y",
    @Json(name = "SHOW_AGE")
    val showAge: String? = "Y",
    @Json(name = "AGE_MIN")
    val minAge: Int? = 18,
    @Json(name = "AGE_MAX")
    val maxAge: Int? = 100,
    @Json(name = "DISTANCE_MAX")
    val maxDistance: Int? = 100
) {

    fun isShowDistance(): Boolean {
        return showDistance == "Y"
    }

    fun isShowRating(): Boolean {
        return showRating == "Y"
    }

    fun isShowAge(): Boolean {
        return showAge == "Y"
    }

}

enum class ConnectionType {
    CONNECTING, CONNECTED, DECLINED, RECOMMENDED
}