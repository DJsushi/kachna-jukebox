package kachnajukebox.fit.su.plugins

import com.adamratzman.spotify.SpotifyAppApi
import com.adamratzman.spotify.endpoints.pub.SearchApi
import com.adamratzman.spotify.models.Track
import io.ktor.server.application.*
import kotlinx.coroutines.launch
import org.koin.ktor.ext.inject

fun Application.spotify() {
    val spotifyApi by inject<SpotifyAppApi>()

    launch {
        val results = spotifyApi.search.search("toxicity", SearchApi.SearchType.TRACK)

        results.tracks?.items?.forEach { track: Track ->
            println("${track.artists[0].name} - ${track.name}")
        }
    }
}