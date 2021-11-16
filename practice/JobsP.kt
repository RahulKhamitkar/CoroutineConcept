package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

runBlocking {
    val job1 = launch{
        println("Job 1 is launched")
        val job2 = launch {
            println("Job 2 is launched")
            delay(3000L)
            println("Job2 is finishing")


        }

        job2.invokeOnCompletion { println("Job2 Completed") }

        val job3 = launch {
            println("Job3 is Launched")
            delay(3000L)
            println("Job3 is finishing")
        }
        job3.invokeOnCompletion { println("Job3 completed") }
    }
    job1.invokeOnCompletion { println("Job1 is completed") }

    delay(500L)
    println("Job1 will be cancelled")
    job1.cancel()

}


}