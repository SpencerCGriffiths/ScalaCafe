import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import PremiumMenu._

class PremiumMenuSpec extends AnyWordSpec with Matchers {

  case object Lobster extends MenuItem {
    val name = "Lobster"
    val price = 29.99
  }

  case object KingCrab extends MenuItem {
    val name = "King Crab"
    val price = 39.99
  }

  case object Wagyu extends MenuItem {
    val name = "Wagyu"
    val price = 49.99
  }

  case object TruffleAnything extends MenuItem {
    val name = "Truffle Anything"
    val price = 59.99
  }

  "PremiumMenu" should {

    "remove all specials without error" when {

      "removeAllSpecials is called on a specials list of some value" in {
        addSpecial(KingCrab)
        addSpecial(Wagyu)
        addSpecial(TruffleAnything)
        removeAllSpecials()

        assert(specials.isEmpty)
      }

      "removeAllSpecials is called on a specials list with no values" in {
        removeAllSpecials()
        assert(specials.isEmpty)
      }
    }

    "add items with addSpecial" when {

      "one item is added" in {
        removeAllSpecials() // reset
        addSpecial(Lobster)
        specials should contain (Lobster)
      }

      "multiple items are added" in {
        removeAllSpecials() // reset
        addSpecial(KingCrab)
        addSpecial(Wagyu)
        addSpecial(TruffleAnything)

        specials should contain (KingCrab)
        specials should contain (Wagyu)
        specials should contain (TruffleAnything)
      }
    }

    "remove items with removeSpecial without error" when {

      "one item is removed" in {
        removeAllSpecials() // Using to reset specials back to empty to run test
        addSpecial(Lobster)
        removeSpecial(Lobster)
        specials should not contain (Lobster)
      }

      "multiple items are removed" in {
        removeAllSpecials() // Using to reset specials back to empty to run test
        addSpecial(KingCrab)
        addSpecial(Wagyu)
        addSpecial(TruffleAnything)

        removeSpecial(KingCrab)
        removeSpecial(Wagyu)
        removeSpecial(TruffleAnything)

        specials should not contain (KingCrab)
        specials should not contain (Wagyu)
        specials should not contain (TruffleAnything)
      }

      "An item is removed that is not in the list" in {
        removeAllSpecials() // Using to reset specials back to empty to run test
        removeSpecial(Lobster)
        noException should be thrownBy 0 / 1
      }
    }

    "Return a String of specials when" when {

      "getSpecials is called on a list with values" in {
        removeAllSpecials()
        addSpecial(Lobster)
        addSpecial(KingCrab)
        addSpecial(Wagyu)
        addSpecial(TruffleAnything)

        val expected = "Lobster: 29.99, King Crab: 39.99, Wagyu: 49.99, Truffle Anything: 59.99"
        getSpecials shouldEqual expected
      }

      "getSpecials is called on a list with no values" in {
        removeAllSpecials()
        val expected = "There are no specials today"
        getSpecials shouldEqual expected
      }

    }
  }
}

