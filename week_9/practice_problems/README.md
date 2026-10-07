# Week 9 - Practice Problems & Q&A (Category C)

This folder contains solutions for Week 9 Coding Practice problems, Quiz Questions, and Concept Questions focusing on **Abstraction and Interfaces** in Java.

---

## Coding Practice Problems Overview

1. **Problem 1: Garden Plot Area Report** ([`Problem1_GardenPlotAreaReport.java`](./Problem1_GardenPlotAreaReport.java))
   - Uses an abstract `Plot` base class to represent circular, rectangular, and triangular plots with distinct area formulas (`CirclePlot`, `RectanglePlot`, `TrianglePlot`).

2. **Problem 2: Weekly Staff Pay** ([`Problem2_WeeklyStaffPay.java`](./Problem2_WeeklyStaffPay.java))
   - Computes weekly payroll for full-time staff (fixed salary), hourly staff (40-hr base + 1.5x overtime), and interns (stipend) via abstract class `StaffMember`.

3. **Problem 3: Library Late Fine Counter** ([`Problem3_LibraryLateFineCounter.java`](./Problem3_LibraryLateFineCounter.java))
   - Implements library late fine calculation using abstract base class `LibraryItem` with specific rules for `BookItem` ($2/day), `DVDItem` ($5/day capped at $50), and `MagazineItem` ($1/day).

4. **Problem 4: Electricity Connection Billing** ([`Problem4_ElectricityConnectionBilling.java`](./Problem4_ElectricityConnectionBilling.java))
   - Models electricity billing for `HomeConnection` (tiered rates), `ShopConnection` (unit rate + fixed charge), and `FactoryConnection` (unit rate with $1000 minimum) deriving from abstract class `ElectricityConnection`.

5. **Problem 5: Travel Booking with a Common Fee** ([`Problem5_TravelBookingCommonFee.java`](./Problem5_TravelBookingCommonFee.java))
   - Encapsulates a shared $50 booking fee in abstract class `TravelBooking` while concrete subclasses (`BusBooking`, `TrainBooking`, `FlightBooking`) compute mode-specific fares.

---

## Part B — Quiz Questions & Answers

### Q1. Which of the following best describes abstraction in object-oriented programming?
- **Answer:** **C. Hiding how an object performs its operations and showing only what it does**
- **Explanation:** Abstraction focuses on exposing essential behavior to the outside world while hiding the internal details of how that behavior is implemented.

### Q2. Which statement about an abstract class in Java is true?
- **Answer:** **C. It cannot be instantiated directly**
- **Explanation:** An abstract class is an incomplete blueprint designed to be extended by concrete subclasses; direct instantiation using `new AbstractClass()` is prohibited.

### Q3. If a concrete class extends an abstract class but fails to implement an inherited abstract method, what is the consequence?
- **Answer:** **B. The class must be declared abstract, or the code will not compile**
- **Explanation:** A non-abstract (concrete) class must provide implementations for all inherited abstract methods; otherwise, compiler errors occur unless the subclass itself is marked abstract.

### Q4. Which of the following modifiers is NOT allowed for an abstract method in Java?
- **Answer:** **C. private**
- **Explanation:** An abstract method must be overridden in a subclass. `private` methods are not visible to subclasses and cannot be overridden, making `private abstract` illegal in Java.

### Q5. Fields declared within a Java interface are implicitly:
- **Answer:** **C. public, static, and final**
- **Explanation:** All fields in a Java interface are constants by default, implicitly marked `public static final`.

### Q6. How many interfaces can a single Java class implement?
- **Answer:** **C. Any number of interfaces**
- **Explanation:** Java supports multiple interface inheritance, allowing a single class to implement multiple interfaces separated by commas.

### Q7. If a class implements an interface, what access modifier must it use for the implemented methods?
- **Answer:** **D. public**
- **Explanation:** Interface methods are implicitly `public abstract`. When implementing them in a concrete class, Java rules require that method visibility cannot be reduced, so they must be explicitly declared `public`.

### Q8. Why does Java allow a class to implement multiple interfaces but only extend a single class?
- **Answer:** **C. Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance**
- **Explanation:** Interfaces define method signatures (contract) without instance variables/state, eliminating state ambiguity during multiple inheritance.

### Q9. What happens if a class implements two interfaces that both provide a default method with the same signature, and the class does not override this method?
- **Answer:** **D. A compile-time error occurs until the class overrides the method**
- **Explanation:** Java forces the implementing class to explicitly resolve the default method conflict by overriding the method and providing its own implementation or explicitly calling `InterfaceName.super.methodName()`.

### Q10. Which of the following is true regarding constructors in Java?
- **Answer:** **B. Abstract classes can have constructors that run when a subclass object is created**
- **Explanation:** Even though abstract classes cannot be instantiated on their own, their constructors execute via `super()` during subclass instantiation to initialize inherited fields.

---

## Part C — Concept Questions & Detailed Answers

### Question 1: Explain abstraction in your own words. Provide a real-life example, different from those mentioned in the material, detailing what is shown to the user and what details are hidden.
**Answer:**
Abstraction is the principle of simplifying complex systems by presenting a clear, high-level interface to the user while concealing internal execution mechanics and state complexity.

*Real-Life Example (Smart TV Remote Control):*
- **What is shown to the user:** Buttons for power, volume, channel change, and streaming apps.
- **What is hidden from the user:** Microcontroller signal processing, infrared/Bluetooth payload generation, wireless transmission protocols, and decoder operations inside the television.

---

### Question 2: Describe the primary difference between abstraction and encapsulation. Explain how these two concepts work together within a single class to manage complexity and data protection.
**Answer:**
- **Abstraction** focuses on **what** an object does by exposing essential behavior through high-level interfaces and abstract contracts.
- **Encapsulation** focuses on **how** an object protects its state by hiding internal implementation data (using `private` fields) and controlling access via methods (getters/setters).

*Working Together:*
In a single class (e.g., `BankAccount`), encapsulation hides internal data (`private double balance`), preventing unauthorized modification. Abstraction exposes high-level operations (`withdraw()`, `deposit()`) so consumers interact with the bank account cleanly without needing to manage ledger entry persistence or validation logic manually.

---

### Question 3: An abstract class cannot be instantiated, yet it can define a constructor. Explain why an abstract class might have a constructor and describe when this constructor is executed.
**Answer:**
An abstract class defines a constructor to initialize state (fields) that all derived subclasses inherit.

*Execution Timing:*
The constructor of an abstract class is executed when a concrete subclass object is instantiated using the `new` keyword. As part of object creation, the subclass constructor invokes `super(...)` (implicitly or explicitly), running the abstract class's constructor before executing its own constructor logic.

---

### Question 4: Explain why an abstract method cannot be declared with the private, static, or final modifiers. Provide a reason for each of these restrictions.
**Answer:**
1. **`private`:** Abstract methods are contracts meant to be implemented/overridden by subclasses. A `private` method is inaccessible to subclasses, creating an impossible contradiction.
2. **`static`:** `static` methods belong to the class itself and are resolved at compile time (static binding). Abstract methods rely on dynamic runtime dispatch via subclass instances.
3. **`final`:** A `final` modifier prevents a method from being overridden in derived classes. Marking a method both `abstract` (demanding overriding) and `final` (prohibiting overriding) is a direct syntax violation.

---

### Question 5: What is the 'diamond problem' in the context of inheritance? Explain how Java's design, allowing a class to implement multiple interfaces but extend only one class, addresses or avoids this problem.
**Answer:**
The **diamond problem** occurs in multiple class inheritance when a class inherits from two parent classes that both derive from a common grandparent class. If both parent classes override a method or maintain conflicting instance variables, the child class faces ambiguity about which parent's state or behavior to inherit.

*Java's Solution:*
1. **Single Class Extension:** Java permits extending only one superclass, preventing state (field) ambiguity and multiple inheritance collisions of instance fields.
2. **Multiple Interface Implementation:** Interfaces do not carry instance state (no instance fields). Prior to default methods, interfaces contained no implementation at all, eliminating ambiguity. For default method conflicts, Java strictly requires the implementing class to override the conflicting method, completely resolving potential diamond ambiguities at compile time.
