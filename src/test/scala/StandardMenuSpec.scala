import org.scalatest.wordspec.AnyWordSpec
import StandardMenu.{items}
import org.scalatest.matchers.should.Matchers

class StandardMenuSpec extends AnyWordSpec with Matchers {

  "The Standard Menu" should {

    "Contain 20 Menu items" in {
      // checks the length of the menu to ensure that all 20 items are present
      assert(items.length == 20)
    }

    "Contain each item with a set trait of temperature and food/drink" in {

      // Pattern Matching the trait of each item to check for the known traits, return false if not present
      def testItemsforTraits(item: MenuItem): Boolean = {
        item match {
          case _: HotFood | _: ColdFood |_: HotDrink | _: ColdDrink => true
          case _ => false
        }
      }

      // takes the list of menu items and tests all of them (for all) and returns false if any are not present
      def checkMenuItems (menuItems: List[MenuItem]): Boolean = {
        menuItems.forall(testItemsforTraits)
      }

      // Final assertion that all menu items should be true
      checkMenuItems(items) should be (true)
    }
  }
}
