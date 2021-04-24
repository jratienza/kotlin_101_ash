fun main(){
    var name = "Ash"
    val SESSION = "Kotlin x Android"
    var age: Int = 100
    var threshold: Float = 100_000_000f

//     println("hi $name, welcome to $SESSION")
//     print("$threshold")

    var nickname: String? = "Ash"
    var palayaw: String? = null

//     println("hi $nickname")
//     println("hi $palayaw")

//     println("hi ${nickname?}")
//     println("hi ${palayaw!!}")

    //proceed  even if null
    println("hi ${nickname?.length}")
//     println("hi ${palayaw?.length ?: "No Entry"}")


    //throws null pointer exception
//     println("hi ${nickname!!.length}")
//     println("hi ${palayaw!!.length}")
//

    //will not run since null
    palayaw?.let{
        println("Length: ${it.length} ")
    }



}