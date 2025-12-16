# 🛒 Week 5: E-commerce System - Advanced OOP Documentation

## 1. Project Overview and Objectives

This project successfully builds an E-commerce system to demonstrate mastery of advanced Java OOP concepts, providing a scalable structure for handling diverse product types and behaviors.

### Technical Requirements Met
* **Inheritance Hierarchy:** Implemented using `Product` (Abstract Parent) extended by `Book`, `Electronics`, and `Clothing`.
* **Polymorphism:** Achieved via the overridden `calculateTax()` method, centralizing the logic in the `ShoppingCart`.
* **Abstract Classes/Methods:** `Product` is abstract, enforcing the `calculateTax()` contract on all children.
* **Interfaces:** The `Discountable` interface adds optional behavior (`applyDiscount`) to the `Clothing` class, fulfilling the "can-do" contract.

## 2. System Architecture and UML Class Diagram

### System Architecture
The system employs a classic **Model-Controller** architecture:
* **Model Layer:** The `Product` inheritance tree (`Product`, `Book`, `Electronics`, `Clothing`).
* **Contract Layer:** The `Discountable` interface.
* **Controller Layer:** The `ShoppingCart` manages the collection, business logic, and total calculation.


### UML Class Diagram
![UML Class Diagram for E-commerce System](docs/uml_ecommerce.jpg, Class Diagram.jpg)


## 3. Setup and Installation Instructions

This project is a standalone Java application.

1.  **Clone the Repository:**
    ```bash
    git clone [YOUR-REPOSITORY-URL]
    ```
2.  **Open in IntelliJ IDEA:**
    * Open IntelliJ IDEA.
    * Select **File** -> **Open...** and select the project folder.
3.  **Run the Project:**
    * Navigate to the `src/` directory.
    * Open the `Main.java` file.
    * Right-click and select **Run 'Main.main()'**.

## 4. Code Structure Explanation

### Inheritance Hierarchy and Abstract Contract
| File | Role | Key Features |
| :--- | :--- | :--- |
| `Product.java` | **Abstract Parent** | Defines common attributes (`id`, `name`, `price`) and the abstract method `calculateTax()`, which must be implemented by all subclasses. |
| `Book.java` | **Child** | Implements `calculateTax()` at **5%** rate. Adds unique attributes (`author`). |
| `Electronics.java` | **Child** | Implements `calculateTax()` at **15%** rate. Adds unique attributes (`brand`, `warrantyMonths`). |
| `Clothing.java` | **Child + Interface** | Implements `calculateTax()` at **8%** rate AND implements the `Discountable` interface. |

### Polymorphism Example
Polymorphism is demonstrated within the `ShoppingCart.calculateGrandTotal()` method. The list holds generic `Product` references, but the JVM correctly executes the method specific to the runtime object's type.

```java
// ShoppingCart.java
// item is type Product, but the actual method run is determined at runtime.
double itemTax = item.calculateTax();
