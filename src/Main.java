import models.Colors;
import models.Transaction;
import models.TransactionFunction;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransactionFunction transactionFunction = new TransactionFunction();
        Scanner sc = new Scanner(System.in);

        String menu = "================================" +
                "\nChoose from the following: "
                + "\n0: Exit from application"
                + "\n1: Add New Transaction"
                + "\n2: Delete a Transaction"
                + "\n3: Edit a Transaction"
                + "\n4: Get Expenditure of Month"
                + "\n5: Show Transactions by Month"
                + "\n6: Show all Transactions" +
                "\n================================" +
                "\nEnter your choice : ";

        while (true) {
            System.out.print(menu);
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Exit");
                    break;
                case 1:
                    System.out.println(Colors.YELLOW+"Add new transaction "+Colors.RESET);
                    transactionFunction.add();
                    break;
                case 2:
                    System.out.println(Colors.YELLOW+"Delete a transaction "+Colors.RESET);
                    transactionFunction.delete();
                    break;
                case 3:
                    System.out.println(Colors.YELLOW+"Edit a transaction "+Colors.RESET);
                    transactionFunction.edit();
                    break;
                case 4:
                    System.out.println(Colors.YELLOW+"Expenditure of month "+Colors.RESET);
                    transactionFunction.expenditure();
                    break;
                case 5:
                    System.out.println(Colors.YELLOW+"Transactions by month "+Colors.RESET);
                    transactionFunction.transactions();
                    break;
                case 6:
                    System.out.println(Colors.YELLOW+" All Transactions "+Colors.RESET);
                    transactionFunction.allTransaction();
                    break;
            }
        }
    }
}
