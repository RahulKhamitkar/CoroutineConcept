package practice

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


var functionCalls = 0

fun main() {
    GlobalScope.launch { completeMsg() }
    GlobalScope.launch { improvedMSG() }
    print("Hello ")
    Thread.sleep(2000L)
    println("$functionCalls  times the Function call is done")
}


suspend fun completeMsg() {
    delay(500L)
    println("World")
    functionCalls++
}


suspend fun improvedMSG() {
    delay(1000L)
    println("Suspend Functions are Cool")
    functionCalls++
}