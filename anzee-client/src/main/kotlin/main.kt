import kotlin.browser.document

fun main() {
    val element = document.getElementById("app")
    element?.innerHTML = "test"
}
