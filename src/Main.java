import java.util.Scanner;

public class Main {

    static addDetails addDet;
    static transaction addtrans;
    static views view;

    static{
        System.out.println("============================WELCOME============================");
    }

    public static void main(String[] args) {
        First:
        while(true) {
                System.out.print("\n\nPress 1 to \"ADDITION OF DETAILS\" " +
                        "\nPress 2 to \"TRANSACTIONS\"" +
                        "\nPress 3 to \"TO VIEW\"" +
                        "\nPress 4 to \"EXIT\"" +
                        "\nEnter your Choice: ");

                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        addDet = new addDetails(true);
                        break;
                    case 2:
                        addtrans = new transaction(true);
                        break;
                    case 3:
                        view = new views();
                        break;
                    case 4:
                        break First;
                }
        }
        System.out.println("\n\n============================THANK___YOU============================\n\n");
    }
}