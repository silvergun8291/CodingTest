fun main(args: Array<String>) {
    val (n) = readLine()!!.split(' ').map(String::toInt)
    
    var i: Int = 1
    
    while (i <= n) {
        for (j in 1..i) {
            print("*")
        }
        println()
        i++
    }
}