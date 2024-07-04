# Collection Framework

- has three main types:
  - set
  - linked-list
  - Queue/Dequeue (Deck)

# Generics

- used to create classes or methods which can take any type as parameter
- we can create even static methods which don't need any reference
- Parameter Naming conventions:
  E - element
  K - Key
  N - Number
  T - Type

Eg:
class Container <T> {
T obj;
Container(T obj) {
this.obj = obj;
}

    public void set() {
        this.obj = obj;
    }

    public void get() {
        return obj;
    }

}

Container<String> anjali = new Container<String>("yash");
anjali.get();

public static <E> void display(E[] arr) {
for(E element : arr) {
sout(element)
}
}

# Interface
- has methods like add, clear, contains, remove,etc.
- .hasNext and all methods for iterator and all

# Class
- has methods like copy, max, min, etc



