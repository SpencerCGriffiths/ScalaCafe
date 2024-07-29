import scala.collection.mutable.ListBuffer

case class Bill()

object Bill {
    val billItems: ListBuffer[MenuItem] = ListBuffer()

  /** Adding and Removing from the bill */
  //Add the item to the bill
  def addToBill(item: MenuItem): Unit = {
    billItems += item
  }

  // remove an item from the bill
  def removeFromBill(item: MenuItem): Unit = {
    billItems -= item
  }

  // Remove all items from the bill
  def removeAllItemsFromBill(): Either[String, String] = {
    if(billItems.nonEmpty) {
      billItems.clear
      Right("All items removed from the bill")
    } else {
      Left("There were no items on the bill")
    }
  }

  /** Service Charge */

  // Cold Drinks No service charge- No Method

  // All Hot Drinks & Cold Food- 10% 2decimal place
  def tenPercentService(items: List[MenuItem]): Double = {
    val total: Double = items.map(_.price).sum
    val RoundTax: Double = BigDecimal((total) * 0.1).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    RoundTax
    // 10% of whole bill
  }

  // Any Hot Food- Whole Bill 20% max £20
  def twentyPercentService(items:List[MenuItem]): Double = {
    val total: Double = items.map(_.price).sum
    val RoundTax: Double = BigDecimal((total) * 0.2).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    if(RoundTax > 20) 20 else RoundTax
  }

  // Any Premium- Whole bill 25% max £40
  def twentyFivePercentService(items:List[MenuItem]): Double = {
    val total: Double = items.map(_.price).sum
    val RoundTax: Double = BigDecimal((total) * 0.25).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    if(RoundTax > 40) 40 else RoundTax
  }


  // Put calculate service and custom service in one method
  def calculateServiceCharge(items: List[MenuItem], customAmount: Option[Double] = None , replaceCurrentService: Option[Boolean] = None): Double = {


    // Calculate set Service
    val setService: Double =
      if (items.exists(_.isInstanceOf[Special])) {
        twentyFivePercentService(items)
      } else if (items.exists(_.isInstanceOf[HotFood])) {
        twentyPercentService(items)
      } else if (items.exists(_.isInstanceOf[HotDrink]) || items.exists(_.isInstanceOf[ColdFood])) {
        tenPercentService(items)
      } else {
        0
      }

    // Calculate custom Service
    val setAndCustomService: Double = (replaceCurrentService, customAmount) match {
      case (Some(true), None) | (Some(true), Some(0)) => 0
      case (Some(true), Some(amount))                 => amount
      case (None, None)                        => setService
      case (None, Some(amount))                => setService + amount
      case _ => 404
    }

    setAndCustomService
  }


  /** Calculate Final Bill */

  def calculateItemTotal(items: List[MenuItem]): Double = {
    items.map(_.price).sum
  }

  def calculateTotalBill(items: List[MenuItem], customAmount: Option[Double] = None , replaceCurrentService: Option[Boolean] = None): Double = {
    val itemCost: Double = calculateItemTotal(items)
    val serviceCharge: Double = calculateServiceCharge(items, customAmount, replaceCurrentService)
     BigDecimal(serviceCharge + itemCost).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
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