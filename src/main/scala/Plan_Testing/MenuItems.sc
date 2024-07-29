// Use traits not Case class



// Seperate File
case class Cold (cold: Boolean)

// Seperate File
trait MenuItem {
  def name: String
  def price: Double
  def cold: Cold // could be a boolean but using case class makes it type safe
  //drink case class
}

 trait Hotfood

// trait cold food

// trait hot drink

// trait cold drink

// caseclass drink
// case class hot/cold

object StandardMenu {

  case object Pizza extends MenuItem with Hotfood {
    val name = "Pizza"
    val price = 8.99
    val cold = Cold(false)
  }

  case object Burger extends MenuItem {
    val name = "Burger"
    val price = 5.99
  }

  case object Salad extends MenuItem {
    val name = "Salad"
    val price = 4.99
  }

  val items: List[MenuItem] = List(Pizza, Burger, Salad)
}

  // Print standard menu items
  println("Standard Menu:")
  StandardMenu.items.foreach(item => println(s"${item.name}: $$${item.price}"))

import scala.collection.mutable.ListBuffer

object PremiumMenu {
  val specials: ListBuffer[MenuItem] = ListBuffer()
  def addSpecial(item: MenuItem): Unit = {
    specials += item
  }
  def removeSpecial(item: MenuItem): Unit = {
    specials -= item
  }
}




// Example premium specials
case object Lobster extends MenuItem {
  val name = "Lobster"
  val price = 29.99
}

case object TrufflePasta extends MenuItem {
  val name = "Truffle Pasta"
  val price = 24.99
}

  // Add premium specials
PremiumMenu.addSpecial(Lobster)
PremiumMenu.addSpecial(TrufflePasta)



  // Print premium specials
  println("\nPremium Specials:")
  PremiumMenu.specials.foreach(item => println(s"${item.name}: $$${item.price}"))

  // Remove a premium special
  PremiumMenu.removeSpecial(Lobster)

  // Print updated premium specials
  println("\nUpdated Premium Specials:")
  PremiumMenu.specials.foreach(item => println(s"${item.name}: $$${item.price}"))
