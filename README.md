# Truck Charging Scheduling

This code provides a scheduling algorithm for charging electric mail trucks overnight, with the goal of maximizing the number of trucks charged to full capacity within a specified time period. The algorithm assigns trucks to available chargers based on their battery capacity, current charge level, and charging rate of the chargers.

Given:

1. Some number of trucks, each with a unique ID, battery capacity (in kilowatt hours), and current level of charge.
2. Some number of chargers, each with a unique ID and charging rate (in kilowatts).
3. A specified amount of time (an integer number of hours).

Assumptions:

1. Each charger can charge one truck at a time.
2. Every truck needs to be charged completely by a single charger.
3. Once a truck starts charging, it must continue until it is fully charged.
4. Once a truck is done charging, it takes zero seconds before the next truck can start charging on the same charger.
5. Chargers can work simultaneously.

Usage:

To use the code, follow these steps:

Define the list of trucks, chargers, and the specified time period in the main method of the ScheduleApplication class.
Initialize the ScheduleService class with appropriate schedule strategy.
Call the getSchedule method, passing the trucks, chargers, and time period as parameters.
The method will return a map of chargers to a list of trucks that should be charged on each charger.
Iterate over the map to access the assigned trucks for each charger and perform further operations as needed.

Testing:

The code includes JUnit tests to ensure the correctness of the getChargingSchedule method. The tests cover different scenarios and verify that the algorithm assigns the trucks to chargers correctly.

To run the tests, execute the JUnit test class TruckChargingScheduleTest in your preferred IDE or build tool.

Dependencies

The code requires Java 8 or higher. The JUnit 5 library is used for testing.
