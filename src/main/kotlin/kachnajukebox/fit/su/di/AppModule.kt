package kachnajukebox.fit.su.di

import com.adamratzman.spotify.spotifyAppApi
import io.github.cdimascio.dotenv.Dotenv
import org.koin.core.module.Module
import org.koin.dsl.module

suspend fun loadAppModule(): Module {
    val dotenv = Dotenv.load()

    val spotifyAppApi = spotifyAppApi(
        clientId = dotenv.get("SPOTIFY_CLIENT_ID"),
        clientSecret = dotenv.get("SPOTIFY_CLIENT_SECRET")
    ).build()

    return module {
        // Dotenv
        single { dotenv }

        // Spotify
        single { spotifyAppApi }
    }
}