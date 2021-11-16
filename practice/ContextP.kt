package practice

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(CoroutineName("MyCoroutine")) {
            println("This is running in ${this.coroutineContext.get(CoroutineName.Key)}")
        }
    }
}