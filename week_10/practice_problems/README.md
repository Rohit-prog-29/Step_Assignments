# Week 10 - Practice Problems & Q&A (Category C)

This folder contains solutions for Week 10 Coding Practice problems, Quiz Questions, and Concept Questions focusing on **Control Flow, Loops, Arrays, Strings, OOP Basics, and Static Members** in Java.

---

## Coding Practice Problems Overview

1. **Problem 1: Vowel and Consonant Counter** ([`Problem1_VowelAndConsonantCounter.java`](./Problem1_VowelAndConsonantCounter.java))
   - Reads a word and counts vowels ('a', 'e', 'i', 'o', 'u', case-insensitive) and consonants using conditional checks.

2. **Problem 2: Word Reverser and Palindrome Checker** ([`Problem2_WordReverserAndPalindromeChecker.java`](./Problem2_WordReverserAndPalindromeChecker.java))
   - Uses `StringBuilder` to reverse words and determines if the word is a palindrome by comparing forward and backward representations.

3. **Problem 3: Even and Odd Numbers in a List** ([`Problem3_EvenAndOddNumbersInAList.java`](./Problem3_EvenAndOddNumbersInAList.java))
   - Traverses a list of integers and uses the modulo operator (`% 2`) to count even and odd numbers.

4. **Problem 4: In-Place Array Reversal** ([`Problem4_InPlaceArrayReversal.java`](./Problem4_InPlaceArrayReversal.java))
   - Reverses an array in-place without auxiliary arrays using a two-pointer swapping strategy from both ends.

5. **Problem 5: Digit Sum and Number Reversal** ([`Problem5_DigitSumAndNumberReversal.java`](./Problem5_DigitSumAndNumberReversal.java))
   - Extracts digits using `% 10` and `/ 10` to calculate the digit sum and construct the reversed integer.

6. **Problem 6: Prime Number Checker** ([`Problem6_PrimeNumberChecker.java`](./Problem6_PrimeNumberChecker.java))
   - Determines primality of a number greater than 1 by checking for divisors up to $\lfloor\sqrt{n}\rfloor$.

7. **Problem 7: Factorial Calculation** ([`Problem7_FactorialCalculation.java`](./Problem7_FactorialCalculation.java))
   - Calculates $n!$ iteratively with support for large numbers using `BigInteger`, handling $0! = 1$.

8. **Problem 8: Student Grade Assignment** ([`Problem8_StudentGradeAssignment.java`](./Problem8_StudentGradeAssignment.java))
   - Evaluates marks out of 100 through an `if-else if-else` ladder to assign grades (A, B, C, D, F).

9. **Problem 9: Leap Year Detector** ([`Problem9_LeapYearDetector.java`](./Problem9_LeapYearDetector.java))
   - Checks if a year is a leap year using boolean logic: `(year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)`.

10. **Problem 10: Student Result Card Generator** ([`Problem10_StudentResultCardGenerator.java`](./Problem10_StudentResultCardGenerator.java))
    - Models a `Student` class with fields for name and marks array. Calculates average marks, assigns grades, and prints formatted result cards in uppercase.

---

## Part B — Quiz Questions & Answers

### Q1. Consider two String objects, s1 and s2, created as follows:
```java
String s1 = new String("hello");
String s2 = new String("hello");
```
Which of the following statements is true regarding the comparison of s1 and s2 in Java?
- **Options:**
  - A. `s1 == s2` is true, and `s1.equals(s2)` is true.
  - B. `s1 == s2` is false, and `s1.equals(s2)` is false.
  - C. `s1 == s2` is true, and `s1.equals(s2)` is false.
  - D. `s1 == s2` is false, and `s1.equals(s2)` is true.
- **Answer:** **D. `s1 == s2` is false, and `s1.equals(s2)` is true.**
- **Explanation:** Using `new String(...)` allocates two distinct objects at different memory addresses in heap memory, so reference equality `==` evaluates to `false`. The `.equals()` method compares character content, which is identical ("hello"), evaluating to `true`.

---

### Q2. Given the following sequence of operations on a StringBuilder object:
```java
StringBuilder sb = new StringBuilder();
sb.append("Java");
sb.append(" Lab");
sb.reverse();
```
What will be the content of the StringBuilder object sb after these operations?
- **Options:**
  - A. `"Java Lab"`
  - B. `"baL avaJ"`
  - C. `"Lab Java"`
  - D. `"avaL baJ"`
- **Answer:** **B. `"baL avaJ"`**
- **Explanation:** Appending `"Java"` and `" Lab"` produces `"Java Lab"`. The `.reverse()` method reverses characters in-place: `'J'` moves to the end, `'b'` moves to the front, producing `"baL avaJ"`.

---

### Q3. Consider a Student class with the following constructors:
```java
class Student {
    String name;
    String department;
    public Student() { this("Unknown", "Not assigned"); }
    public Student(String name) { this(name, "Not assigned"); }
    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
```
If the following code is executed: `Student s = new Student("Ravi");`
Which constructor will be directly called by `new Student("Ravi")`?
- **Options:**
  - A. `public Student()`
  - B. `public Student(String name)`
  - C. `public Student(String name, String department)`
  - D. The code will result in a compile-time error due to ambiguity.
- **Answer:** **B. `public Student(String name)`**
- **Explanation:** The `new` statement specifies a single `String` argument, matching the constructor signature `Student(String name)` directly. Although that constructor delegates to `Student(String, String)` via constructor chaining (`this(...)`), the directly invoked constructor is `Student(String name)`.

---

### Q4. Consider a Wallet class with a balance field and an add(int amount) method. If w1 and w2 are Wallet reference variables, and the following operations occur:
```java
Wallet w1 = new Wallet(500);
Wallet w2 = w1;
w2.add(200);
```
What will be the balance seen through w1 and w2 after `w2.add(200)` is executed?
- **Options:**
  - A. `w1 balance: 500, w2 balance: 700`
  - B. `w1 balance: 700, w2 balance: 500`
  - C. `w1 balance: 500, w2 balance: 500`
  - D. `w1 balance: 700, w2 balance: 700`
- **Answer:** **D. `w1 balance: 700, w2 balance: 700`**
- **Explanation:** `w2 = w1` copies the reference (memory address) of the `Wallet` object. Both `w1` and `w2` point to the same object in heap memory. Mutating state via `w2.add(200)` alters that single object's `balance` to 700, so reading `balance` through either reference yields 700.

---

### Q5. Consider a Visitor class that tracks the total number of visitors using a static variable count.
```java
class Visitor {
    private static int count = 0;
    private String name;
    public Visitor(String name) {
        this.name = name;
        count++; // Increment the shared counter
    }
    public static int getTotalVisitors() {
        return count;
    }
}
```
If three Visitor objects are created:
```java
new Visitor("Asha");
new Visitor("Ravi");
new Visitor("Neha");
```
What will be the value returned by `Visitor.getTotalVisitors()` after these objects are created?
- **Options:**
  - A. 0
  - B. 1
  - C. 3
  - D. Undefined, as static variables require an object instance.
- **Answer:** **C. 3**
- **Explanation:** Static variables belong to the class rather than individual instances and are shared by all objects. Each time the constructor is executed, `count++` increments the same static variable. After 3 object creations, `count` equals 3.

---

### Q6. Consider an integer array named scores with elements [45, 78, 92, 60, 85]. If you iterate through this array using a standard for loop from index 0 to scores.length - 1 and print each element:
```java
int[] scores = {45, 78, 92, 60, 85};
for (int i = 0; i < scores.length; i++) {
    System.out.print(scores[i] + " ");
}
```
What will be the output?
- **Options:**
  - A. `45 78 92 60 85 `
  - B. `85 60 92 78 45 `
  - C. `45 78 92 60 `
  - D. Error: Index out of bounds.
- **Answer:** **A. `45 78 92 60 85`**
- **Explanation:** The standard loop traverses indices 0 through 4 in sequential ascending order, printing each element followed by a space.

---

### Q7. Analyze the following for loop in Java:
```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.print(i + " ");
}
```
What will be the output when this code segment is executed?
- **Options:**
  - A. `1 2 3 4 5 `
  - B. `1 2 4 5 `
  - C. `3 `
  - D. `1 2 `
- **Answer:** **B. `1 2 4 5`**
- **Explanation:** The `continue` statement skips the remainder of the current iteration when `i == 3`, jumping directly to the increment expression (`i++`). Thus, 3 is not printed.

---

### Q8. Consider the following Java code snippet:
```java
class MyClass {
    public static void change(int n) {
        n = 10;
    }
    public static void main(String[] args) {
        int x = 5;
        change(x);
        System.out.println(x);
    }
}
```
What will be printed to the console when the main method is executed?
- **Options:**
  - A. `5`
  - B. `10`
  - C. `0`
  - D. An error will occur because n is not initialized.
- **Answer:** **A. `5`**
- **Explanation:** Java passes arguments strictly by value. For primitives, a copy of the value (5) is passed to `change()`. Modifying parameter `n` inside the method modifies only the local copy, leaving variable `x` in `main` unchanged.

---

### Q9. Consider the following Java code:
```java
int total = 250;
double count = 3;
double avg = total / count;
System.out.println(avg);
```
What will be the output when this code is executed?
- **Options:**
  - A. `83`
  - B. `83.0`
  - C. `83.33333333333333`
  - D. `83.33`
- **Answer:** **C. `83.33333333333333`**
- **Explanation:** In `total / count`, since `count` is a `double`, Java promotes `total` to a `double` (250.0). Floating-point division produces `83.33333333333333` in 64-bit IEEE 754 precision.

---

### Q10. Consider a Payment abstract class with an abstract method pay() and a Card subclass that extends Payment and overrides the pay() method to include a 2% fee.
```java
abstract class Payment {
    abstract void pay(double amount);
}
class Card extends Payment {
    @Override
    void pay(double amount) {
        double fee = amount * 0.02;
        System.out.println("Paid " + (amount + fee) + " by card");
    }
}
// Execution:
Payment p = new Card();
p.pay(500);
```
What will be the output?
- **Options:**
  - A. `Paid 500.0 by card`
  - B. `Paid 510.0 by card`
  - C. Error: Cannot instantiate abstract class Payment.
  - D. Error: Payment class does not have a concrete pay method.
- **Answer:** **B. `Paid 510.0 by card`**
- **Explanation:** `Card` is a concrete subclass implementing `pay()`. For `amount = 500`, fee is `500 * 0.02 = 10.0`, total is `510.0`. Dynamic method dispatch invokes `Card.pay()`, printing `"Paid 510.0 by card"`.

---

### Q11. Consider the following Java code snippet:
```java
String name = "java";
String upperName = name.toUpperCase();
```
Which of the following statements accurately describes the state of the name object after the toUpperCase() method call, based on Java's String immutability?
- **Options:**
  - A. The name object's value changes to "JAVA".
  - B. The name object's value remains "java", and a new String object "JAVA" is created for upperName.
  - C. Both name and upperName refer to the same new String object "JAVA".
  - D. The original name object is destroyed, and a new one is created.
- **Answer:** **B. The name object's value remains "java", and a new String object "JAVA" is created for upperName.**
- **Explanation:** `String` instances in Java are immutable. Any operation that modifies string content returns a newly created `String` object rather than mutating the original instance in place.

---

### Q12. Given the Java code snippet and considering the String pool, how many String objects are created in memory?
```java
String s1 = "hello";
String s2 = "hello";
String s3 = new String("hello");
```
- **Options:**
  - A. 1
  - B. 2
  - C. 3
  - D. 0
- **Answer:** **B. 2**
- **Explanation:** String literal `"hello"` creates 1 object in the String Intern Pool, which is reused by both `s1` and `s2`. The `new String("hello")` explicitly constructs a separate, 2nd object on the standard heap. Hence, exactly 2 objects exist in memory.

---

### Q13. Consider the Word class and the code snippet. What will be the output of the following Java code?
```java
class Word {
    private String text = "Campus";
    public char letterAt(int i) { return text.charAt(i); }
    public int getTextLength() { return text.length(); }
}
Word myWord = new Word();
System.out.println(myWord.getTextLength());
System.out.println(myWord.letterAt(2));
```
- **Options:**
  - A. `6 / m`
  - B. `6 / p`
  - C. `5 / m`
  - D. `7 / p`
- **Answer:** **A. `6 / m`**
- **Explanation:** The length of `"Campus"` is 6 characters. Zero-indexed characters are: index 0='C', 1='a', 2='m', 3='p', 4='u', 5='s'. Thus, `letterAt(2)` returns `'m'`.

---

### Q14. Given the Java code snippet, what will be the output?
```java
String email = "user@domain.com";
int index = email.indexOf("@");
System.out.println(index);
```
- **Options:**
  - A. `4`
  - B. `0`
  - C. `5`
  - D. `-1`
- **Answer:** **A. `4`**
- **Explanation:** In `"user@domain.com"`, characters are: 'u'(0), 's'(1), 'e'(2), 'r'(3), '@'(4). Thus, `indexOf("@")` returns `4`.

---

### Q15. Consider the Book class with a default constructor and the code snippet. What will be the output?
```java
class Book {
    private String title;
    private double price;
    public Book() {
        this.title = "Unknown";
        this.price = 0.0;
    }
    public String getDetails() {
        return "Title: " + title + ", Price: " + price;
    }
}
Book b = new Book();
System.out.println(b.getDetails());
```
- **Options:**
  - A. `Title: null, Price: 0.0`
  - B. `Title: Unknown, Price: 0.0`
  - C. `Title: , Price: 0.0`
  - D. `Compilation Error`
- **Answer:** **B. `Title: Unknown, Price: 0.0`**
- **Explanation:** The no-argument constructor explicitly sets `title = "Unknown"` and `price = 0.0`. Invoking `getDetails()` concatenates these values.

---

### Q16. Consider the Book class with a parameterized constructor and the code snippet. What will be the output?
```java
class Book {
    private String title;
    private double price;
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
    public String getDetails() {
        return "Title: " + title + ", Price: " + price;
    }
}
Book b = new Book("Java Programming", 450.0);
System.out.println(b.getDetails());
```
- **Options:**
  - A. `Title: Java Programming, Price: 450.0`
  - B. `Title: null, Price: 0.0`
  - C. `Title: , Price: 0.0`
  - D. `Compilation Error`
- **Answer:** **A. `Title: Java Programming, Price: 450.0`**
- **Explanation:** The parameterized constructor assigns `"Java Programming"` and `450.0` to the respective instance variables, formatted and printed via `getDetails()`.

---

### Q17. Given the Wallet class and the code snippet, how many Wallet objects exist in memory after the execution of these lines?
```java
class Wallet {
    int balance;
    public Wallet(int amount) {
        this.balance = amount;
    }
}
Wallet w1 = new Wallet(500);
Wallet w2 = w1; // w2 now refers to the same object as w1
Wallet w3 = new Wallet(500); // w3 refers to a new object
```
- **Options:**
  - A. 1
  - B. 2
  - C. 3
  - D. 0
- **Answer:** **B. 2**
- **Explanation:** The `new` keyword is called twice (`new Wallet(500)` for `w1`, and `new Wallet(500)` for `w3`). `w2` is merely a reference copy of `w1`. Therefore, exactly 2 distinct `Wallet` objects exist in heap memory.

---

### Q18. Consider the Wallet class and the code snippet. What will be the output after the add() method is called through w2?
```java
class Wallet {
    int balance;
    public Wallet(int amount) {
        this.balance = amount;
    }
    public void add(int amount) {
        this.balance += amount;
    }
}
Wallet w1 = new Wallet(500);
Wallet w2 = w1;
w2.add(200);
System.out.println("w1 balance: " + w1.balance);
System.out.println("w2 balance: " + w2.balance);
```
- **Options:**
  - A. `w1 balance: 500 / w2 balance: 700`
  - B. `w1 balance: 700 / w2 balance: 500`
  - C. `w1 balance: 700 / w2 balance: 700`
  - D. `w1 balance: 500 / w2 balance: 500`
- **Answer:** **C. `w1 balance: 700 / w2 balance: 700`**
- **Explanation:** `w1` and `w2` refer to the same object instance. When `w2.add(200)` increments the balance from 500 to 700, both references observe the updated value 700.

---

### Q19. Consider the Student class and the code snippet. What will be the output after s1.setName("Anu") is called?
```java
class Student {
    String name;
    public Student(String name) {
        this.name = name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
}
Student s1 = new Student("Asha");
Student s2 = new Student("Ravi");
s1.setName("Anu");
System.out.println("s1 name: " + s1.name);
System.out.println("s2 name: " + s2.name);
```
- **Options:**
  - A. `s1 name: Asha / s2 name: Ravi`
  - B. `s1 name: Anu / s2 name: Anu`
  - C. `s1 name: Anu / s2 name: Ravi`
  - D. `s1 name: Asha / s2 name: Anu`
- **Answer:** **C. `s1 name: Anu / s2 name: Ravi`**
- **Explanation:** `s1` and `s2` refer to two distinct `Student` instances. Modifying the state of `s1` via `s1.setName("Anu")` changes only `s1.name` to `"Anu"`, leaving `s2.name` as `"Ravi"`.

---

### Q20. Consider the Visitor class with a static visitorCount variable and the code snippet. What will be the output?
```java
class Visitor {
    static int visitorCount = 0; // Shared by all visitors
    public Visitor() {
        visitorCount++;
    }
}
Visitor v1 = new Visitor();
Visitor v2 = new Visitor();
Visitor v3 = new Visitor();
System.out.println("Total visitors: " + Visitor.visitorCount);
```
- **Options:**
  - A. `Total visitors: 0`
  - B. `Total visitors: 1`
  - C. `Total visitors: 3`
  - D. `Total visitors: Error`
- **Answer:** **C. `Total visitors: 3`**
- **Explanation:** `visitorCount` is a class-level `static` variable shared across all instances. Every constructor call increments `visitorCount`. After three object instantiations, `Visitor.visitorCount` is 3.

---

## Part C — Concept Questions & Answers

### Question 1
**Explain the concept of String immutability in Java and discuss its impact on performance when a String object undergoes repeated modifications. How can this performance impact be mitigated?**

**Answer:**
In Java, `String` objects are immutable, meaning once created, their internal character data cannot be modified. Any modification (such as concatenation using `+`, substring extraction, or case transformation) allocates a brand new `String` object in heap memory and copies over the character sequence, leaving the original object unchanged. 

When repeated string concatenation is performed inside a loop (e.g., $N$ iterations), this creates $O(N)$ temporary intermediate objects and results in $O(N^2)$ quadratic time complexity due to repeated array copying and heavy garbage collection overhead. This performance degradation is mitigated by using mutable character sequence buffers such as `StringBuilder` (unsynchronized, optimal for single-threaded usage) or `StringBuffer` (synchronized, thread-safe), which dynamically resize an internal character array in amortized $O(1)$ time per append, achieving $O(N)$ overall time complexity.

---

### Question 2
**In a Java class constructor, when both an instance variable and a constructor parameter share the same name, how does the 'this' keyword resolve this ambiguity? Provide an example scenario to illustrate its use.**

**Answer:**
When a method or constructor parameter has the identical identifier as an instance variable, the local parameter variable "shadows" (hides) the instance variable within that scope. In Java, the `this` keyword refers to the current object instance whose method or constructor is being invoked. Prefixing the identifier with `this.` (e.g., `this.name = name;`) instructs the compiler that the left-hand variable belongs to the current instance's field, while the right-hand unadorned identifier refers to the local constructor parameter.

**Example Scenario:**
```java
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;       // Resolves shadowing: assigns parameter 'name' to instance field 'name'
        this.salary = salary;   // Assigns parameter 'salary' to instance field 'salary'
    }
}
```

---

### Question 3
**Differentiate between an object and a reference variable in Java. Explain what occurs in memory when one reference variable is assigned the value of another, detailing the implications for object manipulation.**

**Answer:**
- **Object:** An actual instance of a class allocated in the heap memory containing the concrete state (instance variables) and methods defined by the class blueprint.
- **Reference Variable:** A variable allocated on the stack (or as part of another object in the heap) that stores the memory address (pointer) of where the actual object resides in the heap, rather than holding the object data itself.

When one reference variable is assigned to another (e.g., `Wallet w2 = w1;`):
1. Only the reference (memory address) is copied; no new object is instantiated in the heap.
2. Both reference variables now point to the exact same object in heap memory (aliasing).
3. Any mutation performed through either reference (e.g., `w2.add(200)`) alters the state of that single underlying object, making the change immediately visible when inspected through the other reference (`w1.balance`).

---

### Question 4
**Discuss the appropriate use cases for static variables and instance variables in Java. Provide a scenario where a static member would be preferred and another where an instance member is more suitable, justifying your choices.**

**Answer:**
- **Static Variables:** Belong to the class itself rather than any individual instance. Only one copy exists in memory, shared across all objects of that class.
  - *Appropriate Use Cases:* Shared configuration settings, common global constants (`Math.PI`), global counters, ID sequence generators, or caches.
  - *Scenario:* A `BankAccount` class using `private static int totalAccountsOpened = 0;` or `private static double defaultInterestRate = 0.05;`. Preferred because all bank accounts share the bank's base interest rate and global account count; duplicating this per object wastes memory and risks inconsistency.
- **Instance Variables:** Belong to individual object instances. Each object receives its own independent copy of the variable upon instantiation.
  - *Appropriate Use Cases:* State and attributes unique to a specific entity.
  - *Scenario:* `accountNumber` and `balance` in `BankAccount`. Preferred because each customer possesses their own unique balance and account number that must not be overwritten by other customers.

---

### Question 5
**Compare and contrast the for, while, and do-while loops in Java. Describe specific programming scenarios where each type of loop would be the most suitable choice, explaining your reasoning.**

**Answer:**
- **`for` Loop:**
  - *Characteristics:* Combines initialization, termination condition, and increment/decrement expressions into a single compact header. Evaluates the condition before every iteration (pre-test).
  - *Ideal Scenario:* Known number of iterations, such as traversing array elements from index $0$ to $n-1$, or computing factorials from $1$ to $N$.
- **`while` Loop:**
  - *Characteristics:* Pre-test loop that evaluates the boolean condition before entering the loop body. May execute zero times if the condition is initially false.
  - *Ideal Scenario:* Event-driven loops where the number of iterations is unknown in advance, such as reading input tokens from a `Scanner` until EOF (`while (scanner.hasNext())`) or extracting digits (`while (temp > 0)`).
- **`do-while` Loop:**
  - *Characteristics:* Post-test loop that executes the body first before evaluating the condition. Guaranteed to execute at least once.
  - *Ideal Scenario:* Interactive menu-driven console applications where a user must be prompted with options at least once before checking if they chose to exit, or retry loops for password input.

---

### Question 6
**Explain the concept of pass-by-value in Java. Differentiate its behavior and implications when a method receives a primitive data type as an argument versus when it receives an object reference.**

**Answer:**
Java is strictly **pass-by-value** for all parameters. This means that whenever an argument is passed to a method, a copy of the actual bit-level value is placed on the call stack frame for the method parameter.
- **Primitive Data Types (`int`, `double`, `boolean`, etc.):**
  The actual binary value (e.g., the number `5`) is copied into the method parameter. Any changes made to the parameter variable inside the method operate strictly on this local copy. The caller's original variable remains completely unaffected.
- **Object Reference Types (`String`, `Student`, `int[]`, etc.):**
  The value copied to the method parameter is the **reference** (the memory address of the object in the heap). Consequently:
  - Modifying the internal state of the referenced object via its methods or fields (e.g., `arr[0] = 99;` or `student.setName(...)`) alters the object in heap memory, so the caller observes the change.
  - Reassigning the parameter reference itself (e.g., `student = new Student("New");`) merely rebinds the local reference copy to a different address; it has no effect on the caller's original reference variable.

---

### Question 7
**Describe how integer division operates in Java, specifically how it handles fractional results. Explain why an explicit type cast might be necessary to obtain a precise floating-point result from an arithmetic expression involving integers.**

**Answer:**
In Java, when an arithmetic operator (such as `/`) is applied to two integer operands (e.g., `int / int`), Java performs **integer division**. In integer division, the fractional portion of the quotient is completely truncated (discarded towards zero), producing an integer result (e.g., `7 / 2` evaluates to `3`, not `3.5`).

If the result is subsequently assigned to a floating-point variable (e.g., `double res = 7 / 2;`), integer division occurs first, yielding `3`, which is then implicitly widened to `3.0`, losing precision. To obtain an exact floating-point result, at least one of the operands must be evaluated as a floating-point type (`double` or `float`) before the division operator executes. An explicit cast (such as `(double) total / count` or `total / (double) count`) triggers binary numeric promotion, converting the other operand to `double` and performing 64-bit IEEE 754 floating-point division (producing `3.5`).

---

### Question 8
**Elaborate on the principle of encapsulation in Object-Oriented Programming. Discuss how Java's access modifiers (e.g., private) combined with getter and setter methods contribute to enforcing encapsulation and ensuring data integrity.**

**Answer:**
**Encapsulation** is the object-oriented principle of bundling data (fields) and the methods that operate on that data into a single cohesive unit (a class), while restricting direct outside access to internal implementation details (data hiding).

- **Role of `private` modifier:** Marking class fields `private` prevents external classes from arbitrarily reading or corrupting state. For instance, preventing `student.marks = -50;` or `account.balance = -999999;`.
- **Role of Getters and Setters:** Public accessor (getter) and mutator (setter) methods provide a controlled gateway for interacting with private fields.
- **Enforcing Data Integrity:** Setter methods can incorporate validation logic, invariants, and business rules before accepting modifications (e.g., ensuring `marks >= 0 && marks <= 100`, throwing exceptions or rejecting invalid inputs). Furthermore, getters can return defensive copies of mutable objects (like arrays or dates) to protect the internal state from external tampering.

---

### Question 9
**Explain the fundamental distinction between using the == operator and the equals() method when comparing two objects in Java. Illustrate how overriding the equals() method affects object comparison.**

**Answer:**
- **`==` Operator:** Performs reference comparison (shallow identity). It checks whether two reference variables point to the exact same memory address in heap memory. For distinct object instances, `==` always evaluates to `false`, even if their internal field values are identical.
- **`equals()` Method:** Defined in `java.lang.Object`, the default implementation simply uses `==` (identity comparison). However, classes can override `equals()` to provide **value-based (logical) equality**, checking whether two distinct objects have matching field data.

**Illustration:**
```java
class Student {
    String id;
    String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return this.id.equals(other.id); // Same student if ID matches
    }
}

// Comparison:
Student s1 = new Student("S101", "Asha");
Student s2 = new Student("S101", "Asha");

System.out.println(s1 == s2);      // false (different heap allocations)
System.out.println(s1.equals(s2));  // true (logical equality via overridden equals)
```

---

### Question 10
**Differentiate between method overloading and method overriding in Java, both of which are forms of polymorphism. Explain when each is resolved (compile-time vs. run-time) and provide a concise example for each concept.**

**Answer:**
- **Method Overloading (Compile-Time / Static Polymorphism):**
  - Occurs within the same class (or inherited classes) when multiple methods share the same name but have different parameter lists (different number, types, or order of parameters). Return type alone cannot distinguish overloaded methods.
  - *Resolution:* Resolved at compile time by the compiler based on the reference type and static argument types.
  - *Example:*
    ```java
    class Calculator {
        int add(int a, int b) { return a + b; }
        double add(double a, double b) { return a + b; }
        int add(int a, int b, int c) { return a + b + c; }
    }
    ```
- **Method Overriding (Run-Time / Dynamic Polymorphism):**
  - Occurs between a superclass and subclass when a subclass provides a specific implementation of a method already declared in its superclass, using the exact same signature (name, parameter list, and compatible return type).
  - *Resolution:* Resolved at runtime via dynamic method dispatch (virtual table lookup) based on the actual runtime object instance.
  - *Example:*
    ```java
    class Animal {
        void sound() { System.out.println("Animal sound"); }
    }
    class Dog extends Animal {
        @Override
        void sound() { System.out.println("Bark"); }
    }

    Animal a = new Dog();
    a.sound(); // Output: "Bark" (resolved at runtime to Dog's method)
    ```
