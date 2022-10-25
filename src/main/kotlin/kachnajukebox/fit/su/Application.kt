package kachnajukebox.fit.su

import freemarker.cache.ClassTemplateLoader
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.freemarker.*
import io.ktor.server.netty.*
import kachnajukebox.fit.su.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        }
        configureRouting()
    }.start(wait = true)
}
