/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    // Test functions here
    println(closestDriver(rider).name)
}

data class Driver(
    val name: String,
    val xPos: Double,
    val yPos: Double
)

data class Rider(
    val name: String,
    val rideCount: Int,
    val averageRating: Double,
    val xPos: Double,
    val yPos: Double
)

// Hint: accessing a property of a data class is as simple as using exampleRider.name to retrieve the String value


val rider = Rider(
    "Pam",
    2,
    4.5,
    41.4241265,
    -75.6696665
)


val driverDatabase = listOf(
    Driver("Michael", 41.441692237165604, -75.74063210378645),
    Driver("Kevin", 41.34579708449845, -75.64069789999186),
    Driver("Dwight", 41.4420651,-75.6374736),
    Driver("Creed", 41.406597,-75.6540727),
    Driver("Jim", 41.418185,-75.6257407)
)


fun closestDriver(rider: Rider): Driver {
    // TODO fininsh the function
    
    var keeper: Double = 0.0
    var result: String = ""
    val x1: Double = rider.xPos
    val y1: Double = rider.yPos
    
    for (driver in driverDatabase){
        if (keeper == 0.0){
            var tmp = Math.pow((x1 - driver.xPos), 2.0) + Math.pow((y1 - driver.yPos), 2.0 )
            keeper = Math.sqrt(tmp)
            result = driver.name
            
        } else{
            var tmp2 = Math.pow((x1 - driver.xPos), 2.0) + Math.pow((y1 - driver.yPos), 2.0)
            var tmp3 = Math.sqrt(tmp2)
            if (tmp3 < keeper){
                keeper = tmp3
                result = driver.name
            }
        }
        
    }
    
    for (driver in driverDatabase){
        if (driver.name == result){
            return driver
        }
    }
    return Driver("", 0.0, 0.0)
}
