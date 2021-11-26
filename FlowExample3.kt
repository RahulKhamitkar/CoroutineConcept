package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull


//Cancelling the Coroutine

fun sendNumbersWithDelay() = flow{
    listOf(1,2,3).forEach {
        delay(400L)
        emit(it)
    }
}
fun main() {
    runBlocking {
    val numberFlow = sendNumbersWithDelay()
        println("Starting Flow ")
        withTimeoutOrNull(1000L){
            numberFlow.collect {
                println(it)
            }
        }
    }
}