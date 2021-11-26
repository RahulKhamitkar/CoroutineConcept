package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
//        mapOperator()
//        filterOperator()
        transferOperator()
    }
}
suspend fun filterOperator(){
    (1..10).asFlow()
        .filter {
            it%2==0
        }
        .collect {
            println(it)
        }
}
suspend fun mapOperator(){
    (1..10).asFlow()
        .map {
            delay(500L)
            "mapping $it"
        }
        .collect {
            println(it)
        }
}

//Transform will emit any value at any time

suspend fun transferOperator(){
    (1..10).asFlow()
        .transform{
            delay(500L
            )
            emit("Emitting value is $it")
            emit(it)
        }
        .collect {
            println(it)
        }
}