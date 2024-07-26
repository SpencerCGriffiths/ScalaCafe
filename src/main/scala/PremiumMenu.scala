import scala.collection.mutable.ListBuffer

object PremiumMenu {
  val specials: ListBuffer[MenuItem] = ListBuffer()

  def addSpecial(item: MenuItem): Unit = {
    specials += item
  }


  def removeSpecial(item: MenuItem): Unit = {
    if(specials.contains(item)) specials -= item
    // else throw custom error here
  }

  def getSpecials: String = {
    if(specials.nonEmpty) {
      specials.zipWithIndex.map {
        case (item, index) if index == specials.size - 1 => s"${item.name}: ${item.price}"
        case (item, _) => s"${item.name}: ${item.price}, "
      }.mkString
    } else {
      "There are no specials today"
    }
    // could also else and throw error here
  }

  def removeAllSpecials(): Unit = {
    if (specials.nonEmpty) specials.clear()
  }

}
