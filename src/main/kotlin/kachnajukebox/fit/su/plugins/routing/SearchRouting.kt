package kachnajukebox.fit.su.plugins.routing

import com.adamratzman.spotify.SpotifyAppApi
import com.adamratzman.spotify.endpoints.pub.SearchApi
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kachnajukebox.fit.su.data.mapper.toTrackDto
import org.koin.ktor.ext.inject

fun Application.searchRouting() {

    val spotifyAppApi by inject<SpotifyAppApi>()

    routing {
        get("/search/{query}") {
            println("${call.parameters["query"]}")
            if (call.parameters["query"] == null) {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = "No query specified"
                )
            }
            val results = spotifyAppApi.search.search(call.parameters["query"]!!, SearchApi.SearchType.TRACK)
            val tracks = results.tracks?.items
            if (tracks == null) call.respond(
                status = HttpStatusCode.NotFound,
                message = "Query not found"
            )

            println(tracks)

            call.respond(results.tracks?.items?.map { it.toTrackDto() }!!)
        }
    }
}