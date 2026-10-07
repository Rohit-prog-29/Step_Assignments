# Step_Assignments - Week 9 (Abstraction & Interfaces)

This repository branch contains the practice and assignment problems for **Week 9: Abstraction and Interfaces** for the **STEP Program (Semester 3)**.

GitHub Repository: [https://github.com/Rohit-prog-29/Step_Assignments](https://github.com/Rohit-prog-29/Step_Assignments)

---

## 📁 Branch Structure

```
Step_Assignments/
├── README.md
└── week_9/
    ├── README.md
    ├── assignment_problems/ (and assignment/)
    │   ├── Problem1_MovieTicketCounter.java
    │   ├── Problem2_ParcelShippingDesk.java
    │   ├── Problem3_CollegeFeeCounter.java
    │   ├── Problem4_CityCabFareMeter.java
    │   ├── Problem5_HomeApplianceEnergyReport.java
    │   └── README.md
    └── practice_problems/ (and practice/)
        ├── Problem1_GardenPlotAreaReport.java
        ├── Problem2_WeeklyStaffPay.java
        ├── Problem3_LibraryLateFineCounter.java
        ├── Problem4_ElectricityConnectionBilling.java
        ├── Problem5_TravelBookingCommonFee.java
        └── README.md (Quiz Q1-Q10 & Concept Q1-Q5 Answers)
```

---

## 📚 Overview of Solved Problems

### Coding Assignment Problems (`week_9/assignment_problems/`)
1. **`Problem1_MovieTicketCounter.java`**: Ticket counter calculating booking totals with a shared $20 convenience fee in abstract class `Ticket`.
2. **`Problem2_ParcelShippingDesk.java`**: Shipping desk computing shipping charges in abstract class `Parcel` and insurance (2%) via interface `Insurable`.
3. **`Problem3_CollegeFeeCounter.java`**: Student tuition counter using abstract `Student` and interface `BusServiceable` for transport fee calculations.
4. **`Problem4_CityCabFareMeter.java`**: Cab fare meter enforcing $100 minimum fare in `Cab` and 20% night surcharge via `NightServiceable`.
5. **`Problem5_HomeApplianceEnergyReport.java`**: Energy app calculating kWh units and costs with `SaverModeCapable` interface.

### Coding Practice Problems & Q&A (`week_9/practice_problems/`)
1. **`Problem1_GardenPlotAreaReport.java`**: Garden plot area calculation using abstract `Plot`.
2. **`Problem2_WeeklyStaffPay.java`**: Weekly payroll system for full-time, hourly, and intern staff.
3. **`Problem3_LibraryLateFineCounter.java`**: Library item fine counter using abstract `LibraryItem`.
4. **`Problem4_ElectricityConnectionBilling.java`**: Electricity connection billing for home, shop, and factory connections.
5. **`Problem5_TravelBookingCommonFee.java`**: Travel booking calculator with shared $50 booking fee in `TravelBooking`.
6. **`README.md`**: Complete solutions for Part B Quiz (Q1–Q10) and Part C Concept Questions (Q1–Q5).

---

## 🛠️ How to Compile & Run

From the root directory:

```cmd
# Compile all Week 9 assignment and practice problems
javac week_9/assignment_problems/*.java week_9/practice_problems/*.java

# Run sample assignment problem
java -cp week_9/assignment_problems Problem1_MovieTicketCounter

# Run sample practice problem
java -cp week_9/practice_problems Problem1_GardenPlotAreaReport
```
