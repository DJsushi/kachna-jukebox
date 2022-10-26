package kachnajukebox.fit.su

import com.adamratzman.spotify.endpoints.pub.SearchApi
import com.adamratzman.spotify.spotifyAppApi
import freemarker.cache.ClassTemplateLoader
import io.github.cdimascio.dotenv.Dotenv
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.freemarker.*
import io.ktor.server.netty.*
import kachnajukebox.fit.su.plugins.configureRouting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    val dotenv = Dotenv.load()

    launch(Dispatchers.IO) {
        embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
            install(FreeMarker) {
                templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
            }
            configureRouting()
        }.start()
    }

    launch {
        val api = spotifyAppApi(
            clientId = dotenv.get("SPOTIFY_CLIENT_ID"),
            clientSecret = dotenv.get("SPOTIFY_CLIENT_SECRET")
        ).build()

        val foundTracks = api.search.search("system toxicity", SearchApi.SearchType.TRACK).tracks
        foundTracks?.let {
            it.items.forEach { track ->
                println("${track.artists[0].name} - ${track.name}")
            }
        }
    }

}
