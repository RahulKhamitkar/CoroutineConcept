package practice

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        sendNumbers().collect {
            println("Received Numbers $it")
        }

        println("Receiving from Collection")
        collectionFlow().collect {
            println("Received from collection $it")
        }
        println("Receiving from String Collection")
        collectionStringFlow().collect {
            println("Received from String Flow $it")
        }
    }


}

fun sendNumbers() = flow{
    for(i in 1..10)
        emit(i)
}

fun collectionFlow() = listOf(1,2,3,4).asFlow()

fun collectionStringFlow() = listOf("One","Two","Three").asFlow()