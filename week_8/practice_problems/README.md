# Week 8 - Practice Problems & Q&A (Category C)

This folder contains solutions for Week 8 Coding Practice problems, Quiz Questions, and Concept Questions focusing on **Inheritance** and **Polymorphism**.

---

## Coding Practice Problems Overview

1. **Problem 1: Payment System Fee Calculation** ([`Problem1_PaymentSystemFeeCalculation.java`](./Problem1_PaymentSystemFeeCalculation.java))
   - Handles processing fee calculation for Card (2%), Wallet (1%), and BankTransfer (0%).
2. **Problem 2: Library Item Due Date Calculator** ([`Problem2_LibraryItemDueDateCalculator.java`](./Problem2_LibraryItemDueDateCalculator.java))
   - Calculates borrowing due dates for Books (14 days), DVDs (7 days), and Magazines (3 days) relative to base date `2023-10-26`.
3. **Problem 3: Delivery Fee Calculator** ([`Problem3_DeliveryFeeCalculator.java`](./Problem3_DeliveryFeeCalculator.java))
   - Computes delivery fee for Standard, Express, and International options with weight, distance, and customs fees.
4. **Problem 4: Examination Question Grader** ([`Problem4_ExaminationQuestionGrader.java`](./Problem4_ExaminationQuestionGrader.java))
   - Evaluates MCQ, True/False, and Essay questions (essay graded on keyword matching: >=2 keywords = 75%, 1 keyword = 50%).
5. **Problem 5: Public Transport Fare Calculator** ([`Problem5_PublicTransportFareCalculator.java`](./Problem5_PublicTransportFareCalculator.java))
   - Calculates transport fares for Bus ($2 base + $0.10/km, max $10), Train ($3 base + $0.15/km), and Metro ($1.50 base + $0.20/km * PeakHourFactor).

---

## Quiz Questions & Answers

### Question 1
**Question:** A system processes Document objects. It initially had PDFDocument and WordDocument classes, both inheriting from Document and implementing a `render()` method. A developer observes repeated if-else if blocks checking the document type before calling `render()`. What is the most appropriate OOP principle to apply to eliminate this conditional logic?
- **Answer:** **C Polymorphism**
- **Explanation:** Polymorphism (specifically dynamic method dispatch) allows calling `render()` directly on a `Document` reference, automatically invoking the appropriate subclass implementation without type-checking conditional blocks.

### Question 2
**Question:** Which of the following scenarios represent a genuine 'is-a' relationship, making inheritance a suitable design choice? (Select all that apply)
- **Answer:** **A, B, C**
  - **A:** A `Car` is a `Vehicle`.
  - **B:** A `Rectangle` is a `Shape`.
  - **C:** A `DatabaseConnection` is a `NetworkResource`.
- **Explanation:** Options A, B, and C represent valid specialization/subtype relationships. Option D (`HelperUtility` containing a `Calculator`) is a HAS-A (composition) relationship.

### Question 3
**Question:** Consider a Vehicle base class with a method `startEngine()` and two derived classes, Car and Motorcycle, both overriding `startEngine()` with their specific engine start sounds. If you iterate through a list of Vehicle objects calling `startEngine()`, what mechanism ensures the correct implementation is called?
- **Answer:** **C Runtime method dispatch**
- **Explanation:** In Java, non-static method calls on object references are resolved dynamically at runtime (dynamic method dispatch / late binding) based on the actual object type in memory.

### Question 4
**Question:** A Shape base class has a method `calculateArea()`. Circle and Rectangle derived classes override `calculateArea()`. Iterating over a list of Shape objects and calling `calculateArea()` demonstrates:
- **Answer:** **C Inheritance-based polymorphism**
- **Explanation:** Using a common base class interface and overriding methods in derived classes is classic inheritance-based runtime polymorphism.

### Question 5
**Question:** A system manages `Book` and `DVD` extending `LibraryItem` with `getLoanPeriod()`. `Book` extends inherited behavior for new releases, `DVD` sets fixed loan period. Which statements accurately describe this behavior? (Select all that apply)
- **Answer:** **A, C, D**
  - **A:** `getLoanPeriod()` in `Book` is an example of extending inherited behavior.
  - **C:** The `LibraryItem` class defines the common behavior for all library items.
  - **D:** A `DVD` object can be processed as a `LibraryItem` through a common reference.

### Question 6
**Question:** Consider a base class `Animal` with `makeSound()` and derived classes `Dog` and `Cat`. Which statements are correct? (Select all that apply)
- **Answer:** **A, C**
  - **A:** If a `Dog` object is referred to by an `Animal` reference, calling `makeSound()` will execute `Dog`'s `makeSound()`.
  - **C:** The `makeSound()` method in `Dog` is an example of overridden behavior.

### Question 7
**Question:** Both `CardPayment` and `BankTransferPayment` derive from `Payment` and override `calculateFee()`. What is the primary benefit when adding a new `WalletPayment` type?
- **Answer:** **C It allows adding `WalletPayment` without modifying the existing `PaymentProcessor`'s iteration logic.**
- **Explanation:** Open-Closed Principle (OCP): system is open for extension without modifying existing processing loops.

### Question 8
**Question:** What is the primary reason why using inheritance solely for superficial code reuse between unrelated classes is considered inappropriate?
- **Answer:** **A It leads to tighter coupling and incorrect 'is-a' relationships, making the design rigid.**

### Question 9
**Question:** Derived classes `EmailNotification`, `SMSNotification`, `PushNotification` override `send()`. What are the advantages of using inheritance and polymorphism here? (Select all that apply)
- **Answer:** **A, C**
  - **A:** It allows a generic `NotificationSender` to send various types of notifications without knowing their concrete types.
  - **C:** It simplifies the process of adding a new notification channel without altering existing sender logic.

### Question 10
**Question:** Which of the following are benefits of using polymorphic collections? (Select all that apply)
- **Answer:** **A, B, C**
  - **A:** It simplifies iterating over diverse but related objects.
  - **B:** It allows for uniform processing of objects with specialized behavior.
  - **C:** It reduces the need for explicit type casting in common processing loops.

---

## Concept Questions & Detailed Answers

### Question 1: Specialized Behavior vs Base Behavior
Inheritance allows specialized subclasses to inherit standard behavior from a parent class while overriding or adding attributes/methods for unique requirements. For instance, in an `Employee` system, base salary logic is inherited, but `CommissionEmployee` extends it to calculate commissions.

### Question 2: The 'Is-A' Relationship
An 'is-a' relationship indicates that a derived class is a specialized subtype of the base class (e.g., `SavingsAccount` IS-A `BankAccount`). Enforcing this ensures substitutability (Liskov Substitution Principle).

### Question 3: Method Overriding
Method overriding occurs when a derived class provides a specific implementation for a method already defined in its base class with the exact same signature. For example, `FullTimeEmployee` overrides `calculateBonus()` to return 10% salary, whereas `InternEmployee` overrides it to return a fixed ₹2000.

### Question 4: Runtime Polymorphism (Dynamic Dispatch)
Dynamic dispatch is the mechanism by which a call to an overridden method is resolved at runtime rather than compile time. The JVM checks the actual object type in heap memory at runtime to execute the correct method implementation.

### Question 5: Polymorphic Collections
A polymorphic collection (e.g., `List<CustomerBill>`) holds references of a supertype while containing actual instances of various derived types (`StudentBill`, `StaffBill`, `GuestBill`). This enables uniform iteration and processing.

### Question 6: Polymorphism vs Type-Based Conditional Logic
Using polymorphism replaces fragile `if-else` or `switch` blocks checking object types with clean dynamic method calls. This adheres to the Open-Closed Principle (OCP), making code extensible without modifying core processor logic.

### Question 7: Extending Design with Minimal Changes
Adding a new type (e.g. `CryptoPayment`) requires creating a new subclass of `Payment` implementing `calculateFee()`. Existing `PaymentProcessor` code requires zero modifications to support the new payment method.

### Question 8: Inherited vs Overridden Behavior
A subclass inherits behavior when the base implementation is identical across all subtypes. Subclasses override behavior when each subtype requires unique logic (e.g. calculating parking charges differently for bikes vs trucks).

### Question 9: Inappropriate Inheritance (Favor Composition Over Inheritance)
Inheriting solely for code reuse without a valid 'is-a' relationship introduces tight coupling, fragile base class problems, and violates LSP (e.g. inheriting `Stack` from `Vector`).

### Question 10: Vehicle Rental Scenario
In a `VehicleRental` system, shared attributes (`vehicleId`, `dailyRate`, `calculateBaseFare()`) reside in `VehicleRental`, while specialized behaviors (`calculateInsuranceFee()`, `applyCargoSurcharge()`) are overridden in `CarRental` and `TruckRental`.
