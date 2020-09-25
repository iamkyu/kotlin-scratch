package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalTime
import java.time.temporal.ChronoUnit

fun now() = LocalTime.now().truncatedTo(ChronoUnit.MILLIS)!!

fun log(msg: String) = println("${now()}: ${Thread.currentThread()}: $msg")


fun launchInGlobalScope() {
    GlobalScope.launch {
        log("coroutine start")
    }
}

fun runBlocking() {
    kotlinx.coroutines.runBlocking {
        launch {
            log("GlobalScope.launch started.")
        }
    }
}

fun main() {
    log("main() start")

    launchInGlobalScope()
    log("launchInGlobalScope() executed")

//    runBlocking()
//    log("runBlocking() executed")

    Thread.sleep(5000L)
    log("main() terminated")
}

