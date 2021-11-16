package practice

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val firstDeferredValue = async { firstValue() }
        val secondDeferredValue = async { secondValue() }
        delay(500L)
        println("Waiting for value")

        val firstValue  = firstDeferredValue.await()
        val secondValue = secondDeferredValue.await()
        println("First Value is $firstValue and second value is $secondValue \n" +
                "Total is ${firstValue+secondValue}")

    }
}

suspend fun firstValue():Int{
    delay(1000L)
    val value = Random.nextInt(100)
    println("First delayed value is $value")
    return value
}
suspend fun secondValue(): Int{
    delay(3000L)
    val value  =Random.nextInt(1000)
    println("Second delayed value is $value")
    delay(1000L)
    return value
}
