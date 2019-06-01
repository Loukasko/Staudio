import java.util.ArrayList;
import java.util.Scanner;

public class BasicUI {

    static ArrayList<Producer> prodList = new ArrayList<Producer>();
    static ArrayList<Client> clientList = new ArrayList<Client>();
    static ArrayList<Owner> ownerList = new ArrayList<Owner>();

    public static void startBasicUI() {

        //init();

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
                    createClientUI();
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
        }while(opt < 0 || opt > 3);
    }

    public static void createClientUI() {
        System.out.println("Client options: ");
    }

    public static void createOwnerUI() {
        OwnerUI.owner = SampleInit.getOwnerList().get(0);
        int x = 10;
        while(x != 0)
            x = OwnerUI.showStartMenu();
    }

    public static void createProducerUI() {
        ProducerUI.producer = SampleInit.getProdList().get(0);
        int x = 10;
        while(x != 0)
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

            do{
                System.out.print("Choose option: ");
                opt = keyboard.nextInt();

                switch(opt) {
                    case 1:
                        while(x != 0 && x != -1)
                        {
                            x = showOwnerMyStudios();
                        }
                        if(x == 0)
                            opt = 0;
                        break;
                    case 2:
                        while(x != 0 && x != -1)
                        {
                            x = showOwnerPersonalInfo();
                        }
                        if(x == 0)
                            opt = 0;
                        break;
                    case 0:
                        break;
                     default:
                         break;
                }

            }while(opt < 0 || opt > 2);
            return opt;
        }

        public static int showOwnerMyStudios() {
            Scanner keyboard = new Scanner(System.in);
            int opt;
            int x = 10;
            int ID;

            System.out.println("My studios: ");
            owner.printOwnerStudios();
            System.out.println("Owner My studios options: ");
            System.out.println("\t1) Edit Studio by ID\n\t0) Exit\n\t-1) Back");

            do {
                System.out.println("Choose option: ");
                opt = keyboard.nextInt();

                switch(opt)
                {
                    case 1:
                        System.out.print("Studio ID: ");
                        ID = keyboard.nextInt();
                        owner.editOwnerStudioByID(ID);
                        break;
                    case 0:
                        break;
                    case -1:
                        break;
                    default:
                        System.out.println("No such option.");
                        break;
                }
            }while(opt < -1 || opt > 1);

            return opt;
        }

        public static int showOwnerPersonalInfo() {

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
                        while(x != 0 && x != -1)
                            x = showProducerProfile();
                        if(x == 0)
                            opt = 0;
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("No such option.");
                        break;
                }
            }while(opt < 0 || opt > 1);

            return opt;
        }

        public static int showProducerProfile() {
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
                        while(x != 0 && x != -1)
                            x = showProducerInfo();
                        if(x == 0)
                            opt = 0;
                        break;
                    case 2:
                        while(x != 0 && x != -1)
                            x = showProducerWork();
                        if(x == 0)
                            opt = 0;
                        break;
                    case 0:
                        break;
                    case -1:
                        break;
                    default:
                        System.out.println("No such option.");
                        break;
                }
            }while(opt < -1 || opt > 2);

            return opt;
        }

        public static int showProducerInfo() {
            Scanner keyboard = new Scanner(System.in);
            int opt;

            System.out.println("Producer info:");
            System.out.println(producer.toString());
            System.out.println();
            System.out.println("Producer profile info options: ");
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
            }while(opt < -1 || opt > 1);

            return opt;
        }

        public static int showProducerWork() {
            Scanner keyboard = new Scanner(System.in);
            int opt;
            int ID;

            System.out.println("Producer work:");
            producer.printWork();
            System.out.println();
            System.out.println("Producer work options: ");
            System.out.println("\t1) Edit work by ID\n\t0) Exit\n\t-1) Back");

            do {
                System.out.print("Choose option: ");
                opt = keyboard.nextInt();

                switch (opt) {
                    case 1:
                        System.out.print("ID of work: ");
                        ID = keyboard.nextInt();
                        producer.editProducerWorkByID(ID);
                        break;
                    case 0:
                        break;
                    case -1:
                        break;
                    default:
                        System.out.println("No such option.");
                        break;
                }
            }while(opt < -1 || opt > 1);

            return opt;
        }
    }

    /*public static void init() {
        Producer producer = new Producer("Kirk", "Gian", "6981097028", "email@gmail.com", "otithelw", 16, true, 3);
        Owner owner1 = new Owner("Nikos", "Korompos", "6981787878", "korompos@gmail.com", "kalantas", 20);
        Owner owner2 = new Owner("Kwstas", "Kavourdirhs", "2310474829", "kavourdirhs@hotmail.gr", "kavourdirhs", 4019);
        Client client1 = new Client("Maria", "Pentagiotisa", "2102904738", "maria5i@gmail.com", "5i", 100);
        Client client2 = new Client("Ihsous", "Xristos", "2107777777", "jesuschrist@hotmail.com", "isousnika", 777);

        Studio studio1 = new Studio(1, "kapouedw", "2222222222", 3.2, 3.3, 5, prodList, ownerList, null, null, null, null);

        producer.setPartnerStudio(studio1);

        prodList.clear();
        prodList.add(producer);

        ownerList.clear();
        ownerList.add(owner1);
        ownerList.add(owner2);

        clientList.clear();
        clientList.add(client1);
        clientList.add(client2);
    }*/


}

