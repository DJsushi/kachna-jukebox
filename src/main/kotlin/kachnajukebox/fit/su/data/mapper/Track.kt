package kachnajukebox.fit.su.data.mapper

import com.adamratzman.spotify.models.Track
import kachnajukebox.fit.su.data.dto.TrackDto

fun Track.toTrackDto() = TrackDto(
    artist = artists.first().name,
    title = name,
    imageUrl = album.images.first().url
)