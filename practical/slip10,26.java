1) Create Interface 
QuackBehaviour.java
package javaprograms; 
public interface QuackBehaviour { 
 public default void quack() {
 System.out.println("Quack");
 } 
} 
FlyBehaviour.java
package javaprograms; 
public interface FlyBehaviour { 
 public void fly(); 
} 
2)Create Class - 
FlyWithWings.java
package javaprograms; 

public class FlyWithWings implements FlyBehaviour { 
 public void fly() { 
 System.out.println("I'm flying!!");
 } 
} 
Quack.java
package javaprograms; 
public class Quack implements QuackBehaviour { 
 public void quack() { 
 System.out.println("Quack");
 } 
} 
ModolDuck.java
package javaprograms; 
public class ModolDuck extends Duck { 
 public ModolDuck() { 
 flyBehaviour = new FlyNoWay(); 
 quackBehaviour = new Quack(); 
 } 
 public void display() { 
 System.out.println("I'm a model duck");
 } 
} 
MallardDuck.java
package javaprograms; 
public class MallardDuck extends Duck { 
 public MallardDuck() { 
 quackBehaviour = new Quack(); 
 flyBehaviour = new FlyWithWings(); 
 } 
 public void display() { 
 System.out.println("I'm a real Mallard duck");
 } 
} 
Duck.java
package javaprograms; 
public class MallardDuck extends Duck { 
 public MallardDuck() { 
 quackBehaviour = new Quack(); 
 flyBehaviour = new FlyWithWings(); 
 } 
 public void display() { 
 System.out.println("I'm a real Mallard duck");

 } 
} 
FlyRocketPowered.java
package javaprograms; 
public class FlyRocketPowered implements FlyBehaviour { 
 public void fly() { 
 System.out.println("I'm flying with a rocket!");
 } 
} 
FlyNoWay.java
package javaprograms; 
public class FlyNoWay implements FlyBehaviour { 
 public void fly() { 
 System.out.println("I can't fly");
 } 
} 
MiniDuckSimulator.java
package javaprograms; 
public class MiniDuckSimulator { 
 public static void main(String[] args) { 
 Duck mallard = new MallardDuck(); 
 mallard.performQuack(); 
 mallard.performFly(); 
 Duck model = new ModolDuck();
 model.performFly(); 
 model.setFlyBehaviour(new FlyRocketPowered()); 
 model.performFly(); 
 } 
} 