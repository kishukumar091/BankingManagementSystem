Banking Management System

Overview

The Banking Management System is a Java-based console application designed to simulate essential banking operations. It provides users with functionalities such as account creation, deposit and withdrawal transactions, balance inquiries, and transaction history management.

Features

User Registration and Authentication:

Registration: Allows new users to register by providing their full name, email, and password.

Login: Validates user credentials and facilitates access to account operations.

Account Existence Check: Ensures users cannot register multiple times with the same email.

Account Management:

Open Account: Users can open a new account with an initial deposit and a unique security PIN.

Generate Unique Account Numbers: Automatically assigns a unique account number for every new account.

Transactions:

Credit Money: Enables users to deposit funds securely into their account.

Debit Money: Allows users to withdraw funds while ensuring sufficient balance.

Money Transfer: Facilitates transferring funds between accounts with validations for balance and account details.

Balance Inquiry: Provides real-time balance information upon entering a security PIN.

Database Operations:

Secure handling of SQL queries with prepared statements to prevent SQL injection.

Transaction management with commit and rollback to ensure data integrity during operations.

Integration with MySQL for persistent storage of user and account data.

Technologies Used

Programming Language: Java

Database: MySQL

IDE: IntelliJ IDEA / Eclipse / NetBeans

Version Control: Git

Installation & Setup

Clone the Repository:

git clone https://github.com/kishukumar091/BankingManagementSystem.git
cd BankingManagementSystem

Database Setup:

Ensure MySQL is installed and running on your system.

Create a database named banking_system.

Import the provided SQL script to set up the necessary tables:

mysql -u your_username -p banking_system < banking_system.sql

Update the database configuration in the application to match your MySQL credentials.

Compile and Run the Application:

Open the project in your preferred Java IDE.

Build the project to resolve any dependencies.

Run the Main class to start the application.

Usage

Registration: New users can register by providing their full name, email, and a secure password.

Login: Registered users can log in using their email and password.

Account Operations:

Open Account: After logging in, users can open a new bank account by providing an initial deposit and setting a security PIN.

Deposit Funds: Users can deposit money into their account.

Withdraw Funds: Users can withdraw money, provided they have sufficient balance.

Transfer Funds: Users can transfer money to another account within the system.

Balance Inquiry: Users can check their current account balance.

Transaction History: Users can view a history of their transactions.

Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

Fork the repository.

Create a new branch (git checkout -b feature/YourFeature).

Commit your changes (git commit -m 'Add some feature').

Push to the branch (git push origin feature/YourFeature).

Open a Pull Request.

Please ensure your code follows the project's coding standards and includes appropriate tests.

License

This project is licensed under the MIT License. See the LICENSE file for more details.

