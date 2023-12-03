1.Create Interface: 
public interface ToLowerDecorator { 
public void lower(String ch); 
} 
2. LowerCase.java 
package javaprograms; 
import java.lang.*; 
import java.io.*; 
public class LowerCase implements ToLowerDecorator{ 
public void lower(String ch) 
 { 
 ch=ch.toLowerCase(); 
 System.out.println("Lowercase:"+ch); 
 } 
} 
3.Decorator.java 
package javaprograms; 
import java.io.*; 
import java.util.Scanner; 
public class Decorator { 
public static void main(String[] args) { 
 // TODO Auto-generated method stub
 ToLowerDecorator l=new LowerCase(); 
 //l.lower("HeLLO");
 Scanner sc=new Scanner(System.in); 
 System.out.println("enter character:"); 
 String s=sc.nextLine(); 
 System.out.println("entered character:"+s); 
 l.lower(s); 
 } 
} 