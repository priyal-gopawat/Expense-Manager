package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TransactionFunction {
    Scanner sc = new Scanner(System.in);
    HashMap<String, ArrayList<Transaction>> transactions;
    ArrayList<Transaction> allTransactions = new ArrayList<>();

    public TransactionFunction() {
        this.transactions = new HashMap<>();
    }

    /**
     * Adding transaction
     */
    public void add() {
        while (true) {
            String menu = "========================" +
                    "\n0.Exit" +
                    "\n1.Expense" +
                    "\n2.Income" +
                    "\n========================";
            System.out.println(menu);
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            if (choice == 0)
                break;
            else {
                System.out.print("Enter date (Format y-M-d or yyyy-MM-d) : "); //2001-02-10
                String date = sc.nextLine();
                while (date.isEmpty()) date = sc.nextLine();
                LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);  //2001-02-10
                String key = date1.getMonth() + " " + date1.getYear();         //FEBRUARY 2001

                System.out.print("Enter amount : ");
                Double amount = sc.nextDouble();

                System.out.print("Enter Description : ");
                String description = sc.nextLine();
                while (description.isEmpty()) description = sc.nextLine();

                Transaction transaction = new Transaction(date, amount, choice - 1, description);
                //Already exist
                if (transactions.containsKey(key)) {
                    transactions.get(key).add(transaction);
                    allTransactions.add(transaction);
                }
                //Adding for the first time
                else {
                    ArrayList<Transaction> trans = new ArrayList<>();
                    trans.add(transaction);
                    transactions.put(key, trans);
                    allTransactions.add(transaction);
                }
            }
            System.out.println(Colors.CYAN + "Transaction added Successfully !" + Colors.RESET);
        }
    }

    /**
     * Deleting transaction
     */
    public void delete() {
        while (true) {
            Object[] arrayList = transactions.keySet().toArray();
            for (int i = 0; i < arrayList.length; i++) {
                System.out.println(i + " " + arrayList[i]);
            }
            System.out.println(arrayList.length + " " + "Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            if (choice == arrayList.length)
                break;
            ArrayList<Transaction> trans = transactions.get(arrayList[choice]);
            for (int i = 0; i < trans.size(); i++) {
                System.out.println(i + " " + trans.get(i));
            }
            System.out.print(" Enter your choice1 you want to delete : ");
            int choice1 = sc.nextInt();
            allTransactions.remove(trans.get(choice1));
            trans.remove(choice1);
            if (trans.size() == 0)
                transactions.remove(arrayList[choice]);
            System.out.println(Colors.CYAN + "Transaction Deleted Successfully !" + Colors.RESET);
        }
    }

    /**
     * Edit transaction
     */
    public void edit() {
        while (true) {
            Object[] arrayList = transactions.keySet().toArray();
            for (int i = 0; i < arrayList.length; i++) {
                System.out.println(i + " " + arrayList[i]);
            }
            System.out.println(arrayList.length + " " + " Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            if (choice == arrayList.length)
                break;
            ArrayList<Transaction> trans = transactions.get(arrayList[choice]);
            for (int i = 0; i < trans.size(); i++) {
                System.out.println(i + " " + trans.get(i));
            }
            System.out.print(" Enter your choice1 you want to edit : ");
            int choice1 = sc.nextInt();
            Transaction transaction = trans.get(choice1);
            while (true) {
                String menu = "\n==========================" +
                        "\n0.Go Back" +
                        "\n1.Amount" +
                        "\n2.Description" +
                        "\n==========================";
                System.out.println(menu);
                int choice2 = sc.nextInt();
                if (choice2 == 0)
                    break;
                else if (choice2 == 1) {
                    System.out.print("Enter new amount : ");
                    double amount = sc.nextDouble();
                    transaction.amount = amount;
                    System.out.println(Colors.CYAN + " New Amount Added Successfully !" + Colors.RESET);
                } else {
                    System.out.print("Enter new Description : ");
                    String description = sc.nextLine();
                    transaction.description = description;
                    System.out.println(Colors.CYAN + " New Description Added Successfully !" + Colors.RESET);
                }
            }
        }
    }

    /**
     * expenditure in month
     */
    public void expenditure() {
        Object[] arrayList = transactions.keySet().toArray();
        for (int i = 0; i < arrayList.length; i++) {
            System.out.println(i + " " + arrayList[i]);
        }
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();
        ArrayList<Transaction> trans = transactions.get(arrayList[choice]);
        double total = 0;
        double expense = 0;
        double income = 0;
        for (int i = 0; i < trans.size(); i++) {
            Transaction transaction = trans.get(i);
            if (transaction.type == 0) {
                total -= transaction.amount;
                expense += transaction.amount;
            } else {
                total += transaction.amount;
                income += transaction.amount;
            }
        }
        System.out.println(Colors.CYAN + "Your monthly expense is : " + Colors.RESET + expense);
        System.out.println(Colors.CYAN + "Your monthly income is : " + Colors.RESET + income);
        System.out.println(Colors.CYAN + "Your monthly expenditure is : " + Colors.RESET + total);
    }

    /**
     * Showing transactions by month
     */
    public void transactions() {
        Object[] arrayList = transactions.keySet().toArray();
        for (int i = 0; i < arrayList.length; i++) {
            System.out.println(i + " " + arrayList[i]);
        }
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();
        ArrayList<Transaction> trans = transactions.get(arrayList[choice]);
        for (int i = 0; i < trans.size(); i++) {
            Transaction transaction = trans.get(i);
            System.out.println(transaction);
        }
    }

    /**
     * Showing all transactions
     */
    public void allTransaction() {
        for (int i = 0; i < allTransactions.size(); i++)
            System.out.println(i + " " + allTransactions.get(i));
    }

    @Override
    public String toString() {
        return "TransactionFunction{" +
                "sc=" + sc +
                ", transactions=" + transactions +
                '}';
    }

}

