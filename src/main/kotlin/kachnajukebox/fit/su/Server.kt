package kachnajukebox.fit.su

import freemarker.cache.ClassTemplateLoader
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.freemarker.*
import io.ktor.server.netty.*
import kachnajukebox.fit.su.plugins.configureRouting
import kachnajukebox.fit.su.plugins.spotify
import org.koin.core.module.Module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun startServer(appModule: Module) {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        }
        install(Koin) {
            slf4jLogger()
            modules(appModule)
        }

        configureRouting()
        spotify()
    }.start(wait = true)
}