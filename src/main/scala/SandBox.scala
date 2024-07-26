import StandardMenu._
import PremiumMenu._

object SandBox extends App{
  println(Pizza.isInstanceOf[HotFood])

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

}
