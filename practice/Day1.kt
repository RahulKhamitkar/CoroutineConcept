package practice

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        launch {
            delay(1000L)
            println("Task from Run Blocking")
        }

        GlobalScope.launch {
            delay(500L)
            println("Task from GlobalScope")
        }


        coroutineScope {
            launch {
                delay(1500L)
                println("Task From Coroutine scope")
            }
        }
    }
}