package practice

import kotlinx.coroutines.*

fun main() {
    runBlocking {
//        launch(Dispatchers.Main) {
//            println("Main dispactcher. Thread; ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined Dispatcher. Thread: ${Thread.currentThread().name}")
            delay(100L)
            println("Unconfined Dispatcher. Thread: ${Thread.currentThread().name }")
        }
        launch(Dispatchers.Default) {
            println("Default Dispatcher. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO Thread: ${Thread.currentThread().name}")
        }
        launch(newSingleThreadContext("MyThread")) {
            println("New SingleThread. Thread: ${Thread.currentThread().name}")
        }
    }
}