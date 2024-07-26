import scala.collection.mutable.ListBuffer

object PremiumMenu extends App{
  val specials: ListBuffer[MenuItem] = ListBuffer()

  def addSpecial(item: MenuItem): Unit = {
    specials += item
  }


  def removeSpecial(item: MenuItem): Unit = {
    specials -= item
  }

  def getSpecials: String = {
    specials.zipWithIndex.map {
      case (item, index) if index == specials.size - 1 => s"${item.name}: ${item.price}"
      case (item, _) => s"${item.name}: ${item.price}, "
    }.mkString
  }

  def removeAllSpecials(): Unit = {
    if (specials.nonEmpty) specials.foreach(item => specials -= item)
  }

}
