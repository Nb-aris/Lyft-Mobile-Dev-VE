/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() { 
    
    initDB()
    println("Hello World")
    // Test functions here
    
	val storedCard1 = PaymentInfo("Bob", 22223333, 111)
    val storedCard2 = PaymentInfo("John", 11113333, 134)

    val invalidCard1 = PaymentInfo("", 11113333, 134)
    val invalidCard2 = PaymentInfo("", 11113333, 1222)
    
    println(validInfo(storedCard1))
    println(validInfo(storedCard2))
    //Confirmation test
    println(validInfo(invalidCard1))
    println(validInfo(invalidCard2))
    
    println(cardDataBase)
    println(addCardToDatabase(invalidCard1))
    println(addCardToDatabase(storedCard1))
    
}

data class PaymentInfo(
    val cardOwner: String,
    val cardNumber: Int,
    val cardCVV: Int
)

// Hint: accessing a property of a data class is as simple as using examplePaymentInfo.cardNumber to retrieve the Int value

val storedCard1 = PaymentInfo("Bob", 22223333, 111)
val storedCard2 = PaymentInfo("John", 11113333, 134)

val invalidCard1 = PaymentInfo("", 11113333, 134)
val invalidCard2 = PaymentInfo("", 11113333, 1222)

// This database is treated as a global variable that we can access directly in addCardToDatabase
val cardDataBase = mutableMapOf<Int, PaymentInfo>()

// Don't change this function
fun initDB() {
    cardDataBase[storedCard1.cardNumber] = storedCard1
    cardDataBase[storedCard2.cardNumber] = storedCard2
}

fun validInfo(paymentInfo: PaymentInfo): Boolean {
    // TODO validate paymentInfo according to instructions
    // I am assuming that the cardOwner Name is composed of letters of alphabets only.
    
    if (paymentInfo.cardOwner.length > 0 && paymentInfo.cardNumber.toString().length == 9 && paymentInfo.cardCVV.toString().length == 3){
        return true
    }
    return false
}

fun addCardToDatabase(paymentInfo: PaymentInfo): Boolean {
    // TODO check if we can add card to database according to instructions 
    // use println("ERROR) and return false if the card has already been added 
    // use println("SUCCESS"), add the card to the database, and return true if the card can be added
    
    
    val keyNumber = paymentInfo.cardNumber
    
    if (validInfo(paymentInfo) && cardDataBase.containsKey(keyNumber)){
        println("ERROR")
    	return false
    }
    
    if (validInfo(paymentInfo) && cardDataBase.containsKey(keyNumber) == false){
        cardDataBase.put(keyNumber, paymentInfo)
        println("SUCCESS")
    	return true
    }
    
    println("ERROR")
    return false
}
