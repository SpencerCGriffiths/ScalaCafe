# Mini Project - Cafe

Employed as a developer to help refine the current POS (point of sale) system. 

Build the backend logic for a cafe POS system. 
Build through TDD. 
Work on a branch 

Client Requirements: 
Menu: 
A standard list of menu items 
Premium specials need to be able to be added/removed from the menu

// Menu as a trait
// each item an object extended by the trait
See [MenuItems.sc](MenuItems.sc)



Bill: 
Take a customer order and produce an itemised bill which includes an option service charge

// Bill object
// bill has method Calculate Bill- (List of items) returning list of items, optional service charge

Service Charge: 
Has all the following conditions: 
- When all purchased items are cold drinks no service charge is applied 
- WHen puchased items include any hot drinks or cold food apply a service of 10% of total bull (rounded to 2 decimal)
- When purchased items include any hot food apply a service charge of 20% with max of £20 charge
- If a premium item is purchased, charge of 25% is added to the total with max of £40
- Ability to add a custom additional service charge, either in addition to or instead of the optional automatically applied charge

// series of methods in Bill - pattern matching

Loyalty scheme: 
- A customer can have one of two types of loyalty card- (cannot have both). Either a drinks loyalty or discount loyalty
- Customer can apply for one but are not eligible if they already have the other, have purchased less than 5 times or are under 18 
- Drinks loyalty card - every drink purchase receives a stamp (max one per day)- 10th drink is free
- Discount- bill more than £20 receives a star. Each star generate a discount on the total bill before service of 2% accumulative
  - Max amount of stars is 8, once 8 is reached not receive anymore stars but the total % discount of 16% taken off all bills over £20
  - Premium menu items excluded
  - To qualify need a total spend over a minimum of 5 purchases needs to be £150
  - E.g. if a customer purchased 4 times, each a minimum of £20, on 4 different
    days, they will be entitled to a discount of 8% on every purchase (regardless of
    total price). They can redeem this discount with every purchase, multiple times
    per day. On their 5th purchase of minimum £20 (after discount scheme), they
    will receive their 8% discount and a star (taking them to 5).

// Customer case class 
// Customer companion object
// methods to update purchase prices
// is customer over 18? 
// Has the customer made 5 or more purcahses
// do they have a loyalty card
// customer optional parameters drink cards etc. 

case class Customer (default params, loyaltyCard: Option[Boolean])

object Customer { 


method updatesloyaltyCard(customer: Customer) {

}

}