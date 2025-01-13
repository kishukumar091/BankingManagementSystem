package BankingManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class AccountManager {

    private Connection connection;
    private Scanner scanner;
    public AccountManager(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    public void debit_money(long account_number) throws SQLException{
        scanner.nextLine();
        System.out.print("Enter Amount");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter security PIN: ");
        String security_pin = scanner.nextLine();
        try{
            connection.setAutoCommit(false);
            if(account_number != 0){
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Accounts WHERE account_number = ? and security_pin = ?");
                preparedStatement.setLong(1,account_number);
                preparedStatement.setString(2,security_pin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    double current_balance = resultSet.getDouble("balance");
                    if(amount<=current_balance){
                        String debit_query = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ?";
                        PreparedStatement preparedStatement1 = connection.prepareStatement(debit_query);
                        preparedStatement1.setDouble(1,amount);
                        preparedStatement1.setLong(2,account_number);
                        int rowsAffected = preparedStatement1.executeUpdate();
                        if(rowsAffected > 0){
                            System.out.println("Rs."+amount+"debited Successfully");
                            connection.commit();
                            connection.setAutoCommit(true);
                            return;
                        }
                        else {
                            System.out.println("Transaction Failed!");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }
                    }
                    else {
                        System.out.println("Insufficient Balance!");
                    }
                }
                else{
                    System.out.println("Invalid Pin!");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connection.setAutoCommit(true);
    }
    public void credit_money(long account_number) throws SQLException{
        scanner.nextLine();
        System.out.print("Enter Amount");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter security PIN: ");
        String security_pin = scanner.nextLine();
        try{
            connection.setAutoCommit(false);
            if(account_number!=0){
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Accounts WHERE account_number = ? and security_pin = ?");
                preparedStatement.setLong(1,account_number);
                preparedStatement.setString(2,security_pin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    double current_balance = resultSet.getDouble("balance");
                    String credit_query = "UPDATE Accounts SET balance = balance + ? WHERE account_number = ?";
                    PreparedStatement preparedStatement1 = connection.prepareStatement(credit_query);
                    preparedStatement1.setDouble(1,amount);
                    preparedStatement1.setLong(2,account_number);
                    int rowsAffected = preparedStatement1.executeUpdate();
                    if(rowsAffected > 0){
                        System.out.println("Rs."+amount+"credit Successfully");
                        connection.commit();
                        connection.setAutoCommit(true);
                        return;
                    }
                    else {
                        System.out.println("Transaction Failed!");
                        connection.rollback();
                        connection.setAutoCommit(true);
                    }
                }
                else {
                    System.out.println("Invalid PIN");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
