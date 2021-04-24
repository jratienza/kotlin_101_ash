import javax.print.attribute.SetOfIntegerSyntax

fun main(){
//    define data types for nullable variables
    val ageRange:IntRange = 18..20
    val smallCharacter:CharRange = 'A' .. 'b'

//    var someone = Person()

//    var arrayPerson:Array<Person>? = Array<Person>(5){
//        Person()
//    }

//    var arrayPerson = Array<Person>(5){
//        Person()
//    }
//
//    for(person in arrayPerson){
//
//    }
    var stringName1:ArrayList<String>? = arrayOf("Ian", "Gerome", "Lester")
    var stringName2 = arrayOf("Sharmaine", "Johnashly", "Lester")
    var ageArray = intArrayOf(1, 23, 13, 14, 15)

    stringName1!![0] = "Rome"

    stringName1?.let{
        it!![0] = "Rome"
    }
    for(index in 0 until stringName1.size){
        println(stringName1!![index])
    }

    stringName1 = stringName1.plusElement("Justin")

    for(index in 0 until stringName1.size){
        println("" + index + ": " + stringName1!![index])
    }
//    println(ageArray.sorted())




//    for(data in smallCharacter){
//        println("Data: $data")
//    }
//    for(age in 0..17){
//        println("Age: $age")
//    }
//
//    for(age in 0..17 step 2){
//        println("Age: $age")
//    }

    //for arrays
//    for(age in 0 until 5){
//        println("Age: $age")
//    }

    //reverse
//    for(age in 5 downTo 0){
//        println("Age: $age")
//    }



}

fun main2(){
    val nameList = listOf<String>()
    var nameList2 = mutableListOf<String>()

    var ArrayList = ArrayList<String>()

    val nameSet = setOf<String>()
    var nameSet2 = mutableSetOf<String>()

    val nameMap = mapOf<String, String>()
    var nameMap2 = mutableMapOf<String, String>()
}