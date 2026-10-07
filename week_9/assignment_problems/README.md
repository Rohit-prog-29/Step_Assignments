# Week 9 - Assignment Problems (Category C)

This directory contains solutions for Week 9 Coding Assignment problems focusing on **Abstraction and Interfaces** in Java.

---

## Assignment Problems Overview

1. **Problem 1: Movie Ticket Counter** ([`Problem1_MovieTicketCounter.java`](./Problem1_MovieTicketCounter.java))
   - Encapsulates ticket seat types (`RegularTicket`, `PremiumTicket`, `ReclinerTicket`) extending abstract class `Ticket`. Shared convenience fee of 20 is written in one place.

2. **Problem 2: Parcel Shipping Desk** ([`Problem2_ParcelShippingDesk.java`](./Problem2_ParcelShippingDesk.java))
   - Uses abstract class `Parcel` for shipping charge logic and interface `Insurable` implemented by `ExpressParcel` and `FragileParcel` to compute 2% insurance on declared value.

3. **Problem 3: College Fee Counter** ([`Problem3_CollegeFeeCounter.java`](./Problem3_CollegeFeeCounter.java))
   - Models college students (`DayScholarStudent`, `HostellerStudent`, `ScholarshipStudent`) inheriting from abstract class `Student`. `BusServiceable` interface dynamically provides transport fee addition.

4. **Problem 4: City Cab Fare Meter** ([`Problem4_CityCabFareMeter.java`](./Problem4_CityCabFareMeter.java))
   - Models cab rides with shared minimum-fare policy ($100 minimum) in abstract `Cab`. Interface `NightServiceable` implemented by `SedanCab` and `SUVCab` applies 20% night surcharge while `MiniCab` rejects night requests.

5. **Problem 5: Home Appliance Energy Report** ([`Problem5_HomeApplianceEnergyReport.java`](./Problem5_HomeApplianceEnergyReport.java))
   - Calculates monthly electricity units and cost across appliances (`FridgeAppliance`, `ACAppliance`, `TVAppliance`, `WasherAppliance`). `SaverModeCapable` interface enables 25% energy reduction for AC and Washer while reporting unsupported saver requests for Fridge and TV.
