
fun main(args : Array<String>) {
    var menu = arrayOf("Pizza", "Burger", "Pasta", "French Fries", "Ice Cream", "Brownie", "Milkshake", "Pastry")
    var count = arrayOf(0,0,0,0,0,0,0,0)
    
    while(true){
        println("Please enter :-");
		println("1 - To view menu");
		println("2 - To view cart");
		println("3 - To place order");
		println("4 - To exit");
        println("Enter your choice : ")
		println();

		var n = Integer.valueOf(readLine())
        
        if(n==1) {
			for(i in 0..7){
                var dish = menu[i]
			    var x = i+1
			    println("$x. $dish")
            }
			println()
			println("If you want to add a dish to your cart, enter the dish number. If you want to go back, enter 0.")
			println()
			while(true) {
				var choice = Integer.valueOf(readLine())
				if(choice<0 || choice>8) {
					println("Please enter a valid number.");
					println();
				}else if(choice>=1) {
					count[choice-1]++;
					println(menu[choice-1] + " added.");
				}else {
					break;
				}
			}
			continue;
		}else if(n==2) {
				if(isEmpty(count)) {
					println("Your cart is empty. Please go to the menu and add dishes to your cart.");
					println("Please press 0 to go back to main page or 1 to exit.");
					println();
					var choice = Integer.valueOf(readLine());
					if(choice==0) continue;
					else if(choice==1) break;
					else println("Please enter 0 to go back.");
					println();
				}else {
					for(i in 1..8) {
						var dish = menu[i-1];
						var quantity = count[i-1]
						if(count[i-1]!=0)println("$i. Dish - $dish, Quantity - $quantity");
					}
					println("To add more items or to exit, please go back to the menu page by pressing 0. To remove an item, enter its number.");
					println();
					while(true) {
						var choice = Integer.valueOf(readLine());
						if(choice==0) break;
						else if(choice>=1 && choice<=8){
							if(count[choice-1]==0) {
								println("This item is not added to your cart. Please enter a valid number");
								println();
							}else {
								count[choice-1]--;
								println("1 serving of " + menu[choice-1] + " has been removed.");
								println()
							}
						}else {
							println("Please enter a valid number.");
							println();
							continue;
						}
					}
					continue;
				}
		}else if(n==3){
			println();
			println("Your order has been placed.");
		}else if(n==4) {
			println();
			println("See you next time.");
			break;
		}else {
				println("You have entered an invalid number.");
				println();
		}
	}
}

fun isEmpty(a : Array<kotlin.Int>) : Boolean{
	var sum = 0;
	for(e in a){
		sum += e
	}
	return sum==0;
}