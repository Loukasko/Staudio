import java.util.ArrayList;

public class SampleInit {
    private static ArrayList<Producer> prodList =new ArrayList<>();
    private static ArrayList<Client> clientList =new ArrayList<>();
    private static ArrayList<Owner> ownerList =new ArrayList<>();
    private static ArrayList<Studio> studioList =new ArrayList<>();
    private static ArrayList<Reservation> reservationList =new ArrayList<>();

    public SampleInit() {
        //producers initialization
        Producer producer1 = new Producer("Kirk", "Gian", "6981097028", "email@gmail.com", "otithelw", 16, true, 3);
        prodList.add(producer1);
        Producer producer2 = new Producer("Vasilis", "Terlegkas", "6981097028", "email@gmail.com", "otithelw", 16, true, 4);
        prodList.add(producer2);

        //owners initialization
        Owner owner1 = new Owner("Nikos", "Korompos", "6981787878", "korompos@gmail.com", "kalantas", 20);
        ownerList.add(owner1);
        Owner owner2 = new Owner("Kwstas", "Kavourdirhs", "2310474829", "kavourdirhs@hotmail.gr", "kavourdirhs", 4019);
        ownerList.add(owner2);
        Owner owner3 = new Owner("Giorgos", "Georgiou", "2310474829", "kavourdirhs@hotmail.gr", "kavourdirhs", 4019);
        ownerList.add(owner3);

        //client initialization
        Client client1 = new Client("Maria", "Pentagiotisa", "2102904738", "maria5i@gmail.com", "5i", 100);
        clientList.add(client1);
        Client client2 = new Client("Ihsous", "Xristos", "2107777777", "jesuschrist@hotmail.com", "isousnika", 777);
        clientList.add(client2);
        Client client3 = new Client("Pasxalis", "Terzis", "2102102102", "dethymamaitoemail@hotmail.com", "terzitragoyda", 778);
        clientList.add(client3);
        Client client4 = new Client("Snoop", "Dog", "2102102102", "smokeweveryday@hotmail.com", "snoop", 778);
        clientList.add(client3);

        //studios initialization
        Studio studio1 = new Studio("Shame Story", 1, "kapouedw", "2222222222", 3.2, 3.3, 5);
        studioList.add(studio1);
        Studio studio2 = new Studio("American Canary ", 2, "parapera", "2222222222", 3.4, 3.7, 4);
        studioList.add(studio2);
        Studio studio3 = new Studio("Wudsound ", 3, "nea smurnnis 23", "2111111424", 3.4, 3.7, 5);
        studioList.add(studio3);



        Room room1 = new Room(1, Room.type.highend, Room.size.large, 4, 15);
        room1.addAvaliableRoomDate("1-6-19 17:00:00");
        room1.addAvaliableRoomDate("1-6-19 18:00:00");
        room1.addAvaliableRoomDate("1-6-19 19:00:00");
        room1.addAvaliableRoomDate("2-6-19 17:00:00");
        room1.addAvaliableRoomDate("2-6-19 18:00:00");
        room1.addAvaliableRoomDate("2-6-19 19:00:00");
        Room room2 = new Room(2, Room.type.highend, Room.size.large, 4, 12);
        room2.addAvaliableRoomDate("3-6-19 17:00:00");
        room2.addAvaliableRoomDate("4-6-19 18:00:00");
        room2.addAvaliableRoomDate("5-6-19 19:00:00");
        room2.addAvaliableRoomDate("6-6-19 17:00:00");
        room2.addAvaliableRoomDate("7-6-19 18:00:00");
        room2.addAvaliableRoomDate("8-6-19 19:00:00");
        Room room3 = new Room(3, Room.type.rehearsal, Room.size.small, 5, 14);
        room3.addAvaliableRoomDate("1-6-19 17:00:00");
        room3.addAvaliableRoomDate("2-6-19 18:00:00");
        room3.addAvaliableRoomDate("3-6-19 19:00:00");
        room3.addAvaliableRoomDate("4-6-19 17:00:00");
        room3.addAvaliableRoomDate("5-6-19 18:00:00");
        room3.addAvaliableRoomDate("6-6-19 19:00:00");
        Room room4 = new Room(4, Room.type.rehearsal, Room.size.medium, 2, 20);
        room4.addAvaliableRoomDate("7-6-19 17:00:00");
        room4.addAvaliableRoomDate("8-6-19 18:00:00");
        room4.addAvaliableRoomDate("9-6-19 19:00:00");
        room4.addAvaliableRoomDate("11-6-19 17:00:00");
        room4.addAvaliableRoomDate("12-6-19 18:00:00");
        room4.addAvaliableRoomDate("13-6-19 19:00:00");
        studio1.setRoom(room1);
        studio1.setRoom(room2);
        studio1.setRoom(room3);
        studio1.setRoom(room4);

        Room room5 = new Room(5, Room.type.rehearsal, Room.size.small, 2, 50);
        room5.addAvaliableRoomDate("1-6-19 17:00:00");
        room5.addAvaliableRoomDate("1-6-19 18:00:00");
        room5.addAvaliableRoomDate("1-6-19 19:00:00");
        room5.addAvaliableRoomDate("2-6-19 17:00:00");
        room5.addAvaliableRoomDate("2-6-19 18:00:00");
        room5.addAvaliableRoomDate("2-6-19 19:00:00");
        Room room6 = new Room(6, Room.type.highend, Room.size.large, 4, 300);
        room6.addAvaliableRoomDate("1-6-19 17:00:00");
        room6.addAvaliableRoomDate("2-6-19 18:00:00");
        room6.addAvaliableRoomDate("3-6-19 19:00:00");
        room6.addAvaliableRoomDate("4-6-19 17:00:00");
        room6.addAvaliableRoomDate("5-6-19 18:00:00");
        room6.addAvaliableRoomDate("6-6-19 19:00:00");
        Room room7 = new Room(7, Room.type.highend, Room.size.medium, 3, 5000);
        room7.addAvaliableRoomDate("2-6-19 17:00:00");
        room7.addAvaliableRoomDate("3-6-19 18:00:00");
        room7.addAvaliableRoomDate("4-6-19 19:00:00");
        room7.addAvaliableRoomDate("5-6-19 17:00:00");
        room7.addAvaliableRoomDate("6-6-19 18:00:00");
        room7.addAvaliableRoomDate("7-6-19 19:00:00");
        Room room8 = new Room(8, Room.type.rehearsal, Room.size.medium, 1, 12);
        room8.addAvaliableRoomDate("2-6-19 17:00:00");
        room8.addAvaliableRoomDate("3-6-19 18:00:00");
        room8.addAvaliableRoomDate("4-6-19 19:00:00");
        room8.addAvaliableRoomDate("5-6-19 17:00:00");
        room8.addAvaliableRoomDate("6-6-19 18:00:00");
        room8.addAvaliableRoomDate("7-6-19 19:00:00");
        studio2.setRoom(room5);
        studio2.setRoom(room6);
        studio2.setRoom(room7);
        studio2.setRoom(room8);

        //reservations initialization
        Reservation reserv1 = new Reservation(001, client1, studio1, room1, false  );
        reservationList.add(reserv1);
        studio1.setReservation(reserv1);
        Reservation reserv2 = new Reservation(002, client3, studio1, room5, false  );
        reservationList.add(reserv2);
        studio1.setReservation(reserv2);
        Reservation reserv3 = new Reservation(003, client2, studio2, room4, false  );
        reservationList.add(reserv3);
        studio2.setReservation(reserv3);
        Reservation reserv4 = new Reservation(004, client2, studio3, room4, true  );
        reservationList.add(reserv4);
        studio3.setReservation(reserv4);

        Room room9 = new Room(9, Room.type.highend, Room.size.small, 1, 2);
        Room room10 = new Room(10, Room.type.highend, Room.size.large, 1, 200);
        Room room11 = new Room(11, Room.type.highend, Room.size.medium, 1, 0);
        Room room12 = new Room(12, Room.type.highend, Room.size.medium, 1, 1);
        studio3.setRoom(room9);
        studio3.setRoom(room10);
        studio3.setRoom(room11);
        studio3.setRoom(room12);

        producer1.setPartnerStudio(studio1);
        producer2.setPartnerStudio(studio2);

        owner2.setPartnerStudio(studio1);
    }

    public static ArrayList<Studio> getStudioList() {
        return SampleInit.studioList;
    }

    public static ArrayList<Producer> getProdList() {
        return prodList;
    }

    public static ArrayList<Client> getClientList() { return clientList; }

    public static ArrayList<Reservation> getReservationList() { return reservationList; }

    public static ArrayList<Owner> getOwnerList() {
        return ownerList;
    }

}
