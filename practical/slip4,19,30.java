Create Class –
1)Pizza.class 
package javaprograms; 
import java.util.ArrayList; 
 
abstract public class Pizza { 
 String name; 
 String dough; 
 String sauce; 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
 ArrayList toppings = new ArrayList(); 
 public String getName() { 
 return name; 
 } 
 public void prepare() { 
 System.out.println("Preparing " + name); 
 } 
 public void bake() { 
 System.out.println("Baking " + name); 
 } 
 public void cut() { 
 System.out.println("Cutting " + name); 
 } 
 public void box() { 
 System.out.println("Boxing " + name); 
 } 
 public String toString() { 
 // code to display pizza name and ingredients
 StringBuffer display = new StringBuffer(); 
 display.append("---- " + name + " ----\n"); 
 display.append(dough + "\n"); 
 display.append(sauce + "\n"); 
 for (int i = 0; i < toppings.size(); i++) { 
 display.append((String) toppings.get(i) + "\n"); 
 } 
 return display.toString(); 
 } 
} 
2)PizzaStore.class 
package javaprograms; 
public class PizzaStore { 
 SimplePizzaFactory factory; 
 public PizzaStore(SimplePizzaFactory factory) { 
 this.factory = factory; 
 } 
 public Pizza orderPizza(String type) { 
 Pizza pizza; 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
 pizza = factory.createPizza(type); 
 pizza.prepare(); 
 pizza.bake(); 
 pizza.cut(); 
 pizza.box(); 
 return pizza; 
 } 
} 
3)SimplePizzaFactory.class 
package javaprograms; 
public class SimplePizzaFactory { 
 public Pizza createPizza(String type) { 
 Pizza pizza = null; 
 if (type.equals("cheese")) { 
 pizza = new NYCheesePizza(); 
 } else if (type.equals("veggie")) { 
 pizza = new ChicagoCheesePizza(); 
 } 
 return pizza; 
 } 
} 
4)NYCheesePizza.class 
package javaprograms; 
public class NYCheesePizza extends Pizza { 
 public NYCheesePizza() { 
 name = "NY Cheese Pizza"; 
 dough = "Regular Crust"; 
 sauce = "Marinara Pizza Sauce"; 
 toppings.add("Fresh Mozzarella"); 
 toppings.add("Parmesan"); 
 } 
} 
5)ChicagoCheesePizza.class 
package javaprograms; 
public class ChicagoCheesePizza extends Pizza { 
 public ChicagoCheesePizza() { 
 name = "Chicago Cheese Pizza"; 
 dough = "Crust"; 
 sauce = "Marinara sauce"; 
 toppings.add("Shredded mozzarella"); 
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
 toppings.add("Grated parmesan"); 
 toppings.add("Diced onion"); 
 toppings.add("Sliced mushrooms"); 
 toppings.add("Sliced red pepper"); 
 toppings.add("Sliced black olives"); 
 } 
} 