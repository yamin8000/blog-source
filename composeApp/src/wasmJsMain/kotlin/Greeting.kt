class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello there, ${platform.name}!"
    }
}