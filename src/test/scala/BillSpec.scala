import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import Bill._
import StandardMenu._
import PremiumMenu._

class BillSpec extends AnyWordSpec with Matchers {

  case object Lobster extends MenuItem with Special {
    val name = "Lobster"
    val price = 29.99
  }


  "Bill" should {

    "Remove and Add items to the bill" when {

      "Remove all items from the bill with a success Message" when {
        "removeAllItems is called and there are items in the bill" in {
          addToBill(Pizza)
          val result = removeAllItemsFromBill()
          assert(billItems.isEmpty)
          result shouldEqual Right("All items removed from the bill")
        }

        "removeAllItems is called and there are no items in the bill" in {
          val result = removeAllItemsFromBill()
          assert(billItems.isEmpty)
          result shouldEqual Left("There were no items on the bill")
        }
      }


      "Add an item to the bill" when {
        "addToBill is called with an Item" in {
          removeAllItemsFromBill()
          addToBill(Pizza)
          assert(billItems.contains(Pizza))
        }
      }

      "Remove an item from the bill" when {
        "addToBill is called with an Item" in {
          removeAllItemsFromBill()
          addToBill(Pizza)
          removeFromBill(Pizza)
          billItems should not contain Pizza
        }
      }
    }

    "Calculate varied service charge" when {

      "All items are Hot drink or Cold Foods" should {

        "Calculate 10 percent service charge" in {
          removeAllItemsFromBill()
          addToBill(Salad)
          addToBill(IcedTea)
          val result: Double = tenPercentService(billItems.toList)
          val expectTax: Double = BigDecimal((Salad.price + IcedTea.price) * 0.1).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
          assert(result == expectTax)
        }
      }

      "Any item is hot on the bill" should {

        "Calculate 20 percent service or £20 maximum" in {
          removeAllItemsFromBill()
          addToBill(Salad)
          addToBill(IcedTea)
          addToBill(Pizza)
          val result: Double = twentyPercentService(billItems.toList)
          val expectTax: Double = BigDecimal((Salad.price + IcedTea.price + Pizza.price) * 0.2).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
          assert(result == expectTax)
        }
      }

      "Any item is premium on the bill" should {

        "Calculate 25 percent service or £40 maximum" in {
          removeAllItemsFromBill()
          addSpecial(Lobster)
          addToBill(Salad)
          addToBill(IcedTea)
          addToBill(Lobster)
          val result: Double = twentyFivePercentService(billItems.toList)
          val expectTax: Double = BigDecimal((Salad.price + IcedTea.price + Lobster.price) * 0.25).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
          assert(result == expectTax)
          removeAllSpecials()
          removeAllItemsFromBill()
        }
      }
    }

    "Calculate the total service charge " when {

      "replacing the set service isn't selected" should {

        // Could break this testing down based on Trait values
        "return the set service if a custom amount is not added" in {
          removeAllItemsFromBill()
          addToBill(Salad)
          addToBill(IcedTea)
          val result: Double = calculateServiceCharge(items = billItems.toList, customAmount = None, replaceCurrentService = None)
          val expectService: Double = tenPercentService(billItems.toList)
          assert(result == expectService)
        }

        "return the set service added to custom amount if defined" in {
          removeAllItemsFromBill()
          addToBill(Salad)
          addToBill(IcedTea)
          val result: Double = calculateServiceCharge(items = billItems.toList, customAmount = Some(20), replaceCurrentService = None)
          val expectService: Double = tenPercentService(billItems.toList) + 20
          assert(result == expectService)
        }
      }

      "replacing the set service is selected" should {

        // Could break this testing down based on Trait values
        "return no service if a custom ammount is not added" in {
          removeAllItemsFromBill()
          addToBill(Salad)
          addToBill(IcedTea)
          val result: Double = calculateServiceCharge(items = billItems.toList, customAmount = None, replaceCurrentService = Some(true))
          val expectService: Double = 0
          assert(result == expectService)
        }

        "return only the custom service if defined" in {
          removeAllItemsFromBill()
          addToBill(Salad)
          addToBill(IcedTea)
          val result: Double = calculateServiceCharge(items = billItems.toList, customAmount = Some(20), replaceCurrentService = Some(true))
          val expectService: Double = 20
          assert(result == expectService)
        }
      }


    }

    "Calculate the price of the meal items" when {

      "calculateItemtotal is called on the bill" in {
        removeAllItemsFromBill()
        addToBill(Pizza)
        addToBill(Salad)
        val result: Double = calculateItemTotal(billItems.toList)
        val expecResult: Double = Pizza.price + Salad.price
        assert(result == expecResult)
      }
    }

//  "Calculate the price of the meal including tip" when {
//
//      "calculateTotalBill is called on the bill with no custom service charge options" in {
//        removeAllItemsFromBill()
//        addToBill(IcedTea)
//        addToBill(Salad)
//        val result: Double = calculateTotalBill(billItems.toList)
//        val expecResult: Double = BigDecimal(calculateItemTotal(billItems.toList) + calculateServiceCharge(billItems.toList)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
//        assert(result == expecResult)
//      }
//
//      "calculateTotalBill is called on the bill with the option to replace service with 0" in {
//        removeAllItemsFromBill()
//        addToBill(IcedTea)
//        addToBill(Salad)
//        val result: Double = calculateTotalBill(billItems.toList)
//        val expecResult: Double = BigDecimal(calculateItemTotal(billItems.toList) + calculateServiceCharge(billItems.toList, None, Some(true))).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
//        assert(result == expecResult)
//      }
//
//      "calculateTotalBill is called on the bill with custom amount only" in {
//        removeAllItemsFromBill()
//        addToBill(IcedTea)
//        addToBill(Salad)
//        val result: Double = calculateTotalBill(billItems.toList)
//        val expecResult: Double = calculateItemTotal(billItems.toList) + calculateServiceCharge(billItems.toList, Some(10), Some(true))
//        assert(result == expecResult)
//      }
//
//
//      "calculateTotalBill is called on the bill with custom amount additionally" in {
//        removeAllItemsFromBill()
//        addToBill(IcedTea)
//        addToBill(Salad)
//        val result: Double = calculateTotalBill(billItems.toList)
//        val expecResult: Double = calculateItemTotal(billItems.toList) + calculateServiceCharge(billItems.toList, Some(10), None)
//        assert(result == expecResult)
//      }
//    }
  }
}