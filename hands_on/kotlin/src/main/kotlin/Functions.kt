//void == unit
fun show():Unit{

}

fun add(a: Int, b:Int):Int{
    return a + b
}

fun add() = 0

fun add(a: Float, b:Float) = a + b

fun add(a: Int, b:Float) = a + b

//optional values declared last
/*fun add(a: String, b: String = "") = a+b*/

fun add(a: String, b: String ="Last", c: String = "Middle")
    = "$a $c $b"

fun add(a:Int): Int?=null

fun add(a:Byte, b:Byte) = add()

fun add(a:String, b: String) =
    when {
        a.length > b.length -> {
            "A is Longer"
        }
        b.length > a.length -> {
            "B is longer"
        }
        else -> {
            "   A and B are equal lengths"
        }
    }


fun compute(grade: Int) =
    when(grade){
        in 91..100 -> "A"
        in 81..90 -> "B"
        in 71..80 -> "C"
        else -> "Fail"
    }


fun main(){
//     println("Adding : ${add()}")
    println("Adding : ${add(1, 3f)}")
    println("Adding : ${add("Boom", "Boom")}")
    println("Adding : ${add("Boom", c="u", b="know")}")
    println("Adding : ${add("Boom", b="know", c="u")}")
    println("${compute(10)}")
}