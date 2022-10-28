package kachnajukebox.fit.su.plugins.routing

import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(FreeMarkerContent("index.ftl", mapOf("username" to "Idiot")))
        }
        static("/style") {
            resources("style/")
        }
        static("/js") {
            resources("js/")
        }
    }
}
