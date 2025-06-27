# 🛒 Supermarket Project
A lightweight Java-based system for managing supermarket tickets and calculating tax totals.

> 📌 This project is part of a personal initiative to explore practical applications of Java beyond academic coursework.

---

## 📑 Index
- [💡 Why this project?](#-why-this-project)
- [⚙️ Functionalities](#-functionalities)
- [🚀 How to use](#-how-to-use)
- [📈 Future improvements](#-future-improvements)

---

### 💡 Why this project?

The original idea behind this application was to develop a financial calculator for loans and small businesses. However, for the alpha version, I decided to significantly narrow the scope to a basic "receipt and tax manager" for a supermarket.

This simplified version allowed me to demonstrate fundamental Java programming concepts — such as object-oriented design, file I/O, and modular code structure — while leaving room for future feature expansions. My focus is now shifting toward projects that explore more advanced topics and real-world applications in finance and software engineering.

---

### ⚙️ Functionalities

This alpha version includes the following features:

- **Add product** (`addProduct`)  
  Add a product with its name, price, and applicable VAT (4%, 10%, or 21%).

- **Remove product** (`removeByName`)  
  Remove a product from the current list by its name.

- **Calculate total tax** (`totalTax`)  
  Compute the total tax amount based on all products added.

- **Calculate total ticket value** (`totalTicket`)  
  Display the final price (including tax) for all items.

- **Persistent storage**  
  Every time a product is added, it is saved automatically to a `.csv` file.

- **Data loading on startup**  
  On program launch, all previously saved products are loaded and categorized by their VAT type.

---

### 🚀 How to use

To compile and run the project:

```bash
javac CalculatorMain.java
java CalculatorMain
```
#### Note
This is an alpha version.
No Makefile, pom.xml (Maven), or build.gradle (Gradle) is included due to the simplicity of the current implementation.

---

### 📈 Future improvements

Planned features and technical enhancements:

- ✅ **JUnit testing** for key components and calculations.
- ✅ **Maven integration** to manage dependencies and streamline the build process.
- ✅ **User interface**, either CLI-enhanced or GUI (JavaFX/Swing).
- ✅ **Loan calculator subsystem**, including:
    - Monthly installment
    - Financial capacity
    - Nominal Interest Rate (TIN)
    - Annual Effective Rate (TEA)
    - Annual Equivalent Cost (TCEA)
    - Total loan cost
    - Amortization schedule
    - Commission totals
- ✅ **Advanced supermarket calculations**, including:
    - Retentions
    - Net profit
    - Profit margin
    - Break-even point
    - Return on Investment (ROI)

