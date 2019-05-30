import java.util.ArrayList;
import java.util.Scanner;

public class BasicUI {

    //public BasicUI();
    public BasicUI() {
        Scanner keyboard = new Scanner(System.in);
        int opt = 0;
        System.out.println("Welcome to St-audio!");
        System.out.println("Login as:");
        System.out.println("\t1) Client\n\t2) Owner\n\t3) Producer\n\t0) Exit");

        do {
            System.out.println("Choose option: ");
            opt = keyboard.nextInt();
            switch (opt) {
                case 1:
                    new ClientUI();
                    break;
                case 2:
                    createOwnerUI();
                    break;
                case 3:
                    createProducerUI();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("No such option.");
                    break;
            }
        } while (opt < 0 || opt > 3);
    }

    public static void createOwnerUI() {
        System.out.println("Owner options: ");
    }

    public static void createProducerUI() {
        ProducerUI.producer= SampleInit.getProdList().get(0);
        int x = 10;
        while (x != 0)
            x = ProducerUI.showStartMenu();
    }

    public static class OwnerUI {
        public static Owner owner;

        public static int showStartMenu() {
            Scanner keyboard = new Scanner(System.in);
            int opt = 0;
            int x = 10;

            System.out.println("Owner options: ");
            System.out.println("\t1) My studios\n\t2) Personal info\n\t0) Exit");

            do {
                System.out.print("Choose option: ");
                opt = keyboard.nextInt();

                switch (opt) {
                    case 1:
                        while (x != 0 && x != -1) {
                            x = showMyStudios();
                        }
                        if (x != 0)
                            opt = 0;
                        break;
                    case 2:
                        while (x != 0 && x != -1) {
                            x = showPersonalInfo();
                        }
                        if (x != 0)
                            opt = 0;
                        break;
                    case 0:
                        break;
                    default:
                        break;
                }

            } while (opt < 0 || opt > 2);
            return opt;
        }

        public static int showMyStudios() {
            Scanner keyboard = new Scanner(System.in);
            int opt;
            int x = 10;

            System.out.println("My studios: ");
            owner.printOwnerStudios();

            /*do {
                System.out.println("Choose option: ");
                opt = keyboard.nextInt();

                switch(opt)
                {
                    case 1:

                }
            }while(opt < 0 || opt > 2);*/

            return 1;
        }

        public static int showPersonalInfo() {

            return 0;
        }

    }

    static class ProducerUI {
        public static Producer producer;

        public static int showStartMenu() {
            Scanner keyboard = new Scanner(System.in);
            int opt = 0;
            int x = 10;

            System.out.println("Producer options:");
            System.out.println("\t1) Show profile");
            System.out.println("\t0) Exit");

            do {
                System.out.print("Choose option: ");
                opt = keyboard.nextInt();

                switch (opt) {
                    case 1:
                        while (x != 0 && x != -1)
                            x = showProfile();
                        if (x == 0)
                            opt = 0;
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("No such option.");
                        break;
                }
            } while (opt < 0 || opt > 1);

            return opt;
        }

        public static int showProfile() {
            Scanner keyboard = new Scanner(System.in);
            int opt;
            int x = 10;

            System.out.println("Producer profile options: ");
            System.out.println("\t1) Show Producer Info\n\t2) Show Producer Work\n\t0) Exit\n\t-1) Back");

            do {
                System.out.print("Choose option: ");
                opt = keyboard.nextInt();

                switch (opt) {
                    case 1:
                        while (x != 0 && x != -1)
                            x = showProducerInfo();
                        if (x == 0)
                            opt = 0;
                        break;
                    case 2:
                        showProducerWork();
                        break;
                    case 0:
                        break;
                    case -1:
                        break;
                    default:
                        System.out.println("No such option.");
                        break;
                }
            } while (opt < -1 || opt > 2);

            return opt;
        }

        public static int showProducerInfo() {
            Scanner keyboard = new Scanner(System.in);
            int opt;

            System.out.println("Producer info:");
            System.out.println(producer.toString());
            System.out.println();
            System.out.println("Producer profile info option: ");
            System.out.println("\t1) Edit Profile Info\n\t0) Exit\n\t-1) Back");

            do {
                System.out.print("Choose option: ");
                opt = keyboard.nextInt();

                switch (opt) {
                    case 1:
                        producer.editProducerInfo();
                        break;
                    case 0:
                        break;
                    case -1:
                        break;
                    default:
                        System.out.println("No such option.");
                        break;
                }
            } while (opt < -1 || opt > 1);

            return opt;
        }

        public static void showProducerWork() {
            producer.printWork();
        }
    }
}

