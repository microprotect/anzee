import kotlin.browser.document
import kotlin.browser.window

data class SampleResponse(val message: String)

fun <T> fetchJSON(url: String, callback: (T) -> Unit) {
    window.fetch(url).then { res ->
        res.text().then { text ->
            callback(JSON.parse<T>(text))
        }
    }
}

fun main() {
    val element = document.getElementById("app")

    fetchJSON<SampleResponse>("/data.json") {
        element?.innerHTML = it.message
    }
}
