package kachnajukebox.fit.su

import kachnajukebox.fit.su.di.loadAppModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main(): Unit = runBlocking {

    val appModule = loadAppModule()

    launch(Dispatchers.IO) { startServer(appModule) }
}
