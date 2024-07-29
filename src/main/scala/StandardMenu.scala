object StandardMenu {

  case object Pizza extends MenuItem with HotFood {
    val name = "Pizza"
    val price = 8.99
  }

  case object Burger extends MenuItem with HotFood {
    val name = "Burger"
    val price = 5.99
  }

  case object Pasta extends MenuItem with HotFood {
    val name = "Pasta"
    val price = 7.99
  }

  case object Steak extends MenuItem with HotFood {
    val name = "Steak"
    val price = 14.99
  }

  case object Soup extends MenuItem with HotFood {
    val name = "Soup"
    val price = 4.99
  }

  case object GrilledChicken extends MenuItem with HotFood {
    val name = "Grilled Chicken"
    val price = 9.99
  }

  case object Salad extends MenuItem with ColdFood {
    val name = "Salad"
    val price = 4.99
  }

  case object Sandwich extends MenuItem with ColdFood {
    val name = "Sandwich"
    val price = 5.49
  }

  case object Sushi extends MenuItem with ColdFood {
    val name = "Sushi"
    val price = 12.99
  }

  case object Taramasalata extends MenuItem with ColdFood {
    val name = "Taramasalata"
    val price = 6.99
  }

  case object MozzarellaOnToast extends MenuItem with ColdFood {
    val name = "Mozzarella & pesto chickpeas on toast"
    val price = 5.99
  }

  case object FruitSalad extends MenuItem with ColdFood {
    val name = "Fruit Salad"
    val price = 4.49
  }

  case object IcedTea extends MenuItem with ColdDrink {
    val name = "Iced Tea"
    val price = 2.99
  }

  case object Lemonade extends MenuItem with ColdDrink {
    val name = "Lemonade"
    val price = 3.49
  }

  case object Smoothie extends MenuItem with ColdDrink {
    val name = "Smoothie"
    val price = 4.99
  }

  case object Milkshake extends MenuItem with ColdDrink {
    val name = "Milkshake"
    val price = 5.49
  }

  case object ColdBrew extends MenuItem with ColdDrink {
    val name = "Cold Brew"
    val price = 3.99
  }

  case object Latte extends MenuItem with HotDrink {
    val name = "Latte"
    val price = 3.99
  }

  case object Cappuccino extends MenuItem with HotDrink {
    val name = "Cappuccino"
    val price = 3.99
  }

  case object Tea extends MenuItem with HotDrink {
    val name = "Tea"
    val price = 2.49
  }

  val items: List[MenuItem] = List(
    Pizza, Burger, Pasta, Steak, Soup, GrilledChicken,
    Salad, Sandwich, Sushi, MozzarellaOnToast, Taramasalata, FruitSalad,
    IcedTea, Lemonade, Smoothie, Milkshake, ColdBrew,
    Latte, Cappuccino, Tea
  )
}
