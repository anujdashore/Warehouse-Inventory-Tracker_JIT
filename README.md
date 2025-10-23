# Warehouse Inventory Tracker_JIT

Author: Anuj Dashore  
Course: B.Tech (CSE) – JIT Borawan  
Project For: Koorier Campus Drive (Assignment)

---

## Project Overview
This is a simple Java project for tracking products in a warehouse.  
It keeps product details like ID, name, quantity, and reorder limit.  
When stock is received, quantity increases.  
When an order is fulfilled, quantity decreases.  
If the stock goes below the limit, it shows a “Low Stock Alert”.

---

## Features
- Add new products  
- Update stock when shipment arrives  
- Decrease stock when order is fulfilled  
- Show alert when quantity is low  
- No database used, only HashMap for storage  
- Simple and easy to understand code  

---

## How to Run
1. Save all Java files in one folder (example: src).  
2. Open Command Prompt or Terminal in that folder.  
3. Type: javac *.java java Main
4. You will see all product actions and alerts in the output.

---

## Files in Project
- Product.java – product details  
- StockObserver.java – interface for alert system  
- AlertService.java – shows alert message  
- Warehouse.java – main class for managing products  
- Main.java – demo file to run the project  

---

## Daily Work Progress
- 19 Oct – Created Product, Observer, and Alert files  
- 20 Oct – Added Warehouse class and methods  
- 21 Oct – Added Main demo class  
- 22 Oct – Improved code and error handling  
- 23 Oct – Added extra feature (file save or multithreading)  
- 24 Oct – Final testing and README updated  

---

## Notes
Code is written in simple Java using OOP concepts.  
No database is used.  
This project is made only for learning and assignment purpose.

---

## Contact
Anuj Dashore  
JIT Borawan – Koorier Campus Drive Assignment
