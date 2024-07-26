import scala.collection.mutable.ListBuffer

case class Bill()

object Bill {
    val billItems: ListBuffer[MenuItem] = ListBuffer()

  /** Adding and Removing from the bill */
  def addToBill(item: MenuItem): Unit = {
    ???
    //Add the item to the bill
  }

  def removeFromBill(item: MenuItem): Unit = {
    ???
    // remove an item from the bill
  }

  /** Service Charge */

  // Cold Drinks No service charge- No Method

  // All Hot Drinks & Cold Food- 10% 2decimal place
  def tenPercentService(items: List[MenuItem]): Float = {
    ???
    // 10% of whole bill
  }

  // Any Hot Food- Whole Bill 20% max £20
  def twentyPercentService(items:List[MenuItem]): Float = {
    ???
    // 20% of bill with max £20
  }

  // Any Premium- Whole bill 25% max £40
  def twentyFivePercentService(items:List[MenuItem]): Float = {
    ???
    // 25% of bill with max £40
  }


  // Put calculate service and custom service in one method
  def calculateServiceCharge(items: List[MenuItem], customAmount: Option[Float] = None , replaceCurrentService: Option[Boolean] = None): Float = {
    ???
    // call calculateService
    // if replace current false add custom
    // if replace current true replace custom
  }

  /** Calculate Final Bill */

  def calculateItemTotal(items: List[MenuItem]): Float = {
    ???
    // Work out the total price of all items
  }
  def calculateTotalBill(items: List[MenuItem], customAmount: Option[Float] = None , replaceCurrentService: Option[Boolean] = None): Float = {
    ???
    // Work out the total cost of the bill calling CalculateServiceCharge and CalculateItemTotal
  }
  /** Printing the Bill */

  def printWithoutService(item: MenuItem): Float = {
    ???
    // return itemised bill with prices
  }

  def printWithService(items: List[MenuItem], customAmount: Option[Float] = None , replaceCurrentService: Option[Boolean] = None): Float = {
    ???
    // return itemised bill with prices and service
    // If boolean remains false defaults
    // if custom service true check replace current service
    // add or replace with new amount
  }
}