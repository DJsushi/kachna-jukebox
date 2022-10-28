package kachnajukebox.fit.su.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrackDto(
    val artist: String,
    val title: String,
    @SerialName("image_url") val imageUrl: String
)