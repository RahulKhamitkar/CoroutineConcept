package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking {
        println("Receiving Prime Nos")
        sendPrimes().collect {
            println("Received prime number $it")
        }
        println("Finished receiving numbers")
    }
}

fun sendPrimes(): Flow<Int> = flow {
    val primeList = listOf(2, 3, 5, 7, 11, 13, 17, 23, 29)
    primeList.forEach {
        delay(it * 100L)
        emit(it)
    }
}