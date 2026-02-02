# Secret Santa Matcher

A Java-based Secret Santa algorithm designed with specific gender-based pairing constraints to ensure a balanced and organized gift exchange among students.

---

## 🎄 Objectives & Logic

The algorithm follows a strict hierarchy to determine pairings to meet the following requirements:

1.  **Gender Diversity:** Priority is given to pairing two students of different genders.
2.  **No Female-Female Pairs:** The system is programmed to never pair two female students together.
3.  **Male-Male Pairing Logic:** Two male students are paired together **if and only if** there are no more available female participants in the pool.
4.  **Odd Number Handling:** If the total number of students is an odd number, the last remaining person is automatically paired with a female participant.
5.  **Automated Notification:** Once matches are finalized, the system forwards the contact information of each Secret Santa to their respective recipient.

---

## 🚀 How to Run the Program

### Prerequisites
* **Java Development Kit (JDK):** Version 8 or higher is required.
* **Terminal/IDE:** Access to a command-line interface or a Java IDE (IntelliJ, Eclipse, or VS Code).

### Installation & Execution
1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/your-username/secret-santa-matcher.git](https://github.com/your-username/secret-santa-matcher.git)
    cd secret-santa-matcher
    ```

2.  **Compile the Source Code:**
    ```bash
    javac Main.java
    ```

3.  **Run the Application:**
    ```bash
    java Main
    ```

---

## 🛠 Implementation Details

The program processes participants by splitting them into two distinct collections based on gender. It then uses a matching engine to satisfy the constraints:

* **Cross-Gender Matching:** The engine draws one participant from the "Male" list and one from the "Female" list to create a valid pair.
* **Fallback Logic:** If the female list is exhausted while males remain, the engine begins pairing the remaining males with each other.
* **The "Odd One Out" Rule:** In cases of an odd participant count, the final student is assigned to a female participant to ensure the gift cycle remains unbroken.

---

## 📧 Notifications

The system includes a dedicated module for contact distribution. Once the algorithm confirms all pairs are valid according to the rules:
* It retrieves the **Contact Information** (Email/Phone) of the Secret Santa.
* It sends that information to the assigned recipient.
* This ensures that the exchange remains "Secret" until the very end.

---
