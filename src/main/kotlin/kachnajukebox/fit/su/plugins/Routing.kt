package kachnajukebox.fit.su.plugins

import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(FreeMarkerContent("index.ftl", mapOf("username" to "Idiot")))
        }
    }
}
