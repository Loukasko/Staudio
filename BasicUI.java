import java.util.ArrayList;
import java.util.Scanner;

public class BasicUI {

    static ArrayList<Producer> prodList = new ArrayList<Producer>();
    static ArrayList<Client> clientList = new ArrayList<Client>();
    static ArrayList<Owner> ownerList = new ArrayList<Owner>();

    public static void startBasicUI() {

        init();

        Scanner keyboard = new Scanner(System.in);
        int opt = 0;

        System.out.println("Welcome to St-audio!");
        System.out.println("Login as:");
        System.out.println("\t1) Client\n\t2) Owner\n\t Producer");
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
        }
    }

    public static void createClientUI() {
        System.out.println("Client options: ");
    }

    public static void createOwnerUI() {
        System.out.println("Owner options: ");
    }

    public static void createProducerUI() {
        ProducerUI.producer = prodList.get(0);
        ProducerUI.showStartMenu();
    }

    static class ProducerUI {
        public static Producer producer;

        public ProducerUI(Producer producer) {
            this.producer = producer;
        }

        public static Producer getProducer() { return producer; }
        public static void setProducer(Producer producer) { producer = producer; }

        public static void showStartMenu() {
            Scanner keyboard = new Scanner(System.in);
            int opt = 0;

            System.out.println("Producer options:");
            System.out.println("\t1) Show profile");
            System.out.println("\t0) Exit");
            System.out.print("Choose option: ");
            opt = keyboard.nextInt();

            switch (opt) {
                case 1:
                    showProfile();
                    break;
                case 0:
                    return;
            }
        }

        public static void showProfile() {
            Scanner keyboard = new Scanner(System.in);
            int opt;

            System.out.println("Producer profile options: ");
            System.out.println("\t1) Show Producer Info\n\t2) Show Producer Work\n\t0) Exit");
            System.out.print("Choose option: ");
            opt = keyboard.nextInt();

            switch(opt) {
                case 1:
                    showProducerInfo();
                    break;
                case 2:
                    showProducerWork();
                    break;
                case 0:
                    return;
            }
        }

        public static void showProducerInfo() {
            Scanner keyboard = new Scanner(System.in);
            int opt;

            System.out.println("Producer info:");
            System.out.println(producer.toString());
            System.out.println();
            System.out.println("Producer profile info option: ");
            System.out.println("\t1) Edit Profile Info\n\t0) Exit");
            System.out.print("Choose option: ");
            opt = keyboard.nextInt();

            switch(opt) {
                case 1:
                    producer.editProducerInfo();
                    break;
                case 0:
                    return;
            }
        }

        public static void showProducerWork() {
            producer.printWork();
        }
    }

    public static void init() {
        Producer producer = new Producer("Kirk", "Gian", "6981097028", "email@gmail.com", "otithelw", 16, true, 3);
        Owner owner1 = new Owner("Nikos", "Korompos", "6981787878", "korompos@gmail.com", "kalantas", 20);
        Owner owner2 = new Owner("Kwstas", "Kavourdirhs", "2310474829", "kavourdirhs@hotmail.gr", "kavourdirhs", 4019);
        Client client1 = new Client("Maria", "Pentagiotisa", "2102904738", "maria5i@gmail.com", "5i", 100);
        Client client2 = new Client("Ihsous", "Xristos", "2107777777", "jesuschrist@hotmail.com", "isousnika", 777);

        prodList.clear();
        prodList.add(producer);

        ownerList.clear();
        ownerList.add(owner1);
        ownerList.add(owner2);

        clientList.clear();
        clientList.add(client1);
        clientList.add(client2);
    }


}

