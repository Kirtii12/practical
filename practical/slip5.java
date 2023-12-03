import java.util.Enumeration;
import java.util.Iterator;
// Create an adapter class that implements the Iterator interface and adapts an Enumeration
class EnumerationAdapter<T> implements Iterator<T> {
 private Enumeration<T> enumeration;
 public EnumerationAdapter(Enumeration<T> enumeration) {
 this.enumeration = enumeration;
 }
 @Override
 public boolean hasNext() {
 return enumeration.hasMoreElements();
 }
 @Override
 public T next() {
 return enumeration.nextElement();
 }
 @Override
 public void remove() {
 throw new UnsupportedOperationException("Remove operation is not supported");
 }
}
public class AdapterPatternDemo {
 public static void main(String[] args) {
 // Create an Enumeration of some elements
 Enumeration<String> enumeration = new Enumeration<String>() {
 private String[] elements = {"Mango", "Orange", "Apple"};
 private int index = 0;
 @Override
 public boolean hasMoreElements() {
 return index < elements.length;
 }
 @Override
 public String nextElement() {
 if (hasMoreElements()) {
 return elements[index++];
 } else {
 return null;
 }
 }
 };
 // Create an Iterator by adapting the Enumeration using the EnumerationAdapter
 Iterator<String> iterator = new EnumerationAdapter<>(enumeration);
 // Use the Iterator to traverse the elements
 while (iterator.hasNext()) {
 System.out.println(iterator.next());
 }
}
}

Or

import java.util.*;
class EnumerationIterator implements Iterator {
Enumeration enumeration;
public EnumerationIterator(Enumeration enumeration) {
this.enumeration = enumeration;
}
public boolean hasNext() {
return enumeration.hasMoreElements();
}
public Object next() {
return enumeration.nextElement();
}
public void remove() {
throw new UnsupportedOperationException();
}
}
class EnumerationIteratorTestDrive1 {
public static void main (String args[]) {
Vector v = new Vector(Arrays.asList("apple","mango","grapes"));
Iterator iterator = new EnumerationIterator(v.elements());
while (iterator.hasNext()) {
System.out.println(iterator.next());
}
}
}
