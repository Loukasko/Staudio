import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BasicUI {

    private static class MyException extends Exception {

    }

    private static class BackException extends MyException {

    }
    private static class ExitException extends MyException {

    }

    private static class LogoutException extends MyException {

    }

    static ArrayList<Producer> prodList = new ArrayList<Producer>();
    static ArrayList<Client> clientList = new ArrayList<Client>();
    static ArrayList<Owner> ownerList = new ArrayList<Owner>();

    public static void startBasicUI() {

        Scanner keyboard = new Scanner(System.in);
        int opt;

        ArrayList<String> optionList = new ArrayList<String>();
        optionList.add("Client");
        optionList.add("Owner");
        optionList.add("Producer");

        while(true) {
            try {
                opt = makeMenu("Welcome to St-Audio!!\nLogin as", optionList);

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
                    case -1:
                        break;
                }
            } catch (LogoutException le) {
                continue;
            } catch (ExitException ee) {
                System.out.println("Bye");
                return;
            } catch (BackException be) {
                continue;
            }
        }
    }

    public static void createClientUI() throws BackException, ExitException, LogoutException {

        ClientUI.client=SampleInit.getClientList().get(0);
        ClientUI.showStartMenuUI();


    }

    public static void createOwnerUI() throws ExitException, LogoutException {
        OwnerUI.owner = SampleInit.getOwnerList().get(0);
        OwnerUI.showStartMenu();
    }

    public static void createProducerUI() throws ExitException, LogoutException {
        ProducerUI.producer = SampleInit.getProdList().get(0);
        ProducerUI.showStartMenu();
    }

    public static class ClientUI {
        public static Client client;
        public static void showStartMenuUI() throws ExitException, BackException, LogoutException {
            int option;
            Scanner keyboard = new Scanner(System.in);
            ArrayList<String> optionList = new ArrayList<String>();
            optionList.add("Rehersal");
            optionList.add("Recording");
            optionList.add("Production");
            optionList.add("Rate");

            while(true) {
                option = makeMenu("Client options: ", optionList, "Client");
                try {
                    switch (option) {
                        case 1:
                            showNewRehearsalWin();
                            break;
                        case 2:
                            showNewRecordingWin();
                            break;
                        case 3:
                            showNewProductionWin();
                            break;
                        case 4:
                            showNewRateWin();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("No such option. ");
                            break;
                    }
                } catch (BackException be) {
                    continue;
                }

            }
        }
        public static void showNewRehearsalWin() throws BackException, ExitException, LogoutException {
            Scanner keyboard = new Scanner(System.in);
            int option;

            Studio selectedStudio = selectFromList(SampleInit.getStudioList(), "Studio list", "studio");
            Room selectedRoom = selectFromList(selectedStudio.getRooms(), "Rooms list", "room");
            String selectedDate = selectFromList(selectedRoom.getAvailiableRoomDates(), "Avaliable dates list: ", "date");

            System.out.println("Synopsis");
            System.out.println("Client: " + client.getName() + " " + client.getLastName());
            System.out.println("Studio:" + selectedStudio.getStudioName());
            System.out.println("Room Size:" + selectedRoom.getRoomSize());
            System.out.println("Room Type:" + selectedRoom.getRoomType());
            System.out.println("Room Cost:" + selectedRoom.getCost());
            System.out.println("Date:" + selectedDate + "\n");

            if (makeDialog("Ready for rehersal?")) {
                new Rehearsal(Reservation.idAutoIncrement(), client, selectedStudio, selectedRoom, false, selectedRoom.getCost(), null, selectedDate, null);
                System.out.println("New book request sent. Reservation currently pending.");
            } else {
                System.out.println("Canceled");
            }
        }
        public static void showNewRecordingWin() throws BackException, ExitException, LogoutException {
            Scanner keyboard = new Scanner(System.in);
            int option;
            String tempComm="";
            Equipment selectedEquipment= null;


            Studio selectedStudio = selectFromList(SampleInit.getStudioList(), "Studio list", "studio");
            Recording.type instrument = Recording.type.valueOf(selectFromList(Recording.getRecordingTypeList(), "Recording type", "recording type"));

            if (makeDialog("Would you like to rent equipment?")) {
                selectedEquipment = selectFromList(selectedStudio.getEquips(), "Equipment list", "equipment: ");
            }

            String selectedDate = selectFromList(selectedStudio.getAvailiableDates(), "Avaliable Dates", "date");
            if (makeDialog("Would you like to leave a comment?")) {
                System.out.print("Comment: ");
                tempComm = keyboard.nextLine();
            }
            System.out.println("Synopsis");
            System.out.println("Studio:" + selectedStudio.getStudioName());
            System.out.println("Type of recording " + instrument.toString());
            System.out.println("Date:" + selectedDate);
            System.out.println("Comment: " + tempComm);
            if (makeDialog("Ready to record?")) {
                new Recording(Reservation.idAutoIncrement(), client, selectedStudio, false, instrument, selectedEquipment, 0, selectedDate, tempComm);
                System.out.println("New book request sent. Reservation currently pending.");
            } else {
                System.out.println("Canceled.");
            }


        }
        public static void showNewProductionWin() {

        }
        public static void showNewRateWin() throws BackException, ExitException, LogoutException {
            int option;
            Scanner keyboard = new Scanner(System.in);

            int sound = 0;
            int staff = 0;
            int environment = 0;
            System.out.println("Visited studios: ");

            Studio selectedStudio = selectFromList(client.getHistory(), "History", "reservation").getStudio();

            sound = makeRatingDialog("Sound");
            staff = makeRatingDialog("Staff");
            environment = makeRatingDialog("Enviroment");

            client.rate(selectedStudio,sound,environment,staff);
        }

    }

    public static class OwnerUI {
        public static Owner owner;
        public static void showStartMenu() throws LogoutException, ExitException {
            int opt = 0;
            ArrayList<String> list = new ArrayList<String>();

            list.add("My studios");
            list.add("Personal info");

            while(true) {
                try {
                    opt = makeMenu("Owner options", list, "Owner");
                    switch (opt) {
                        case 1:
                            showOwnerMyStudios();
                            break;
                        case 2:
                            showOwnerPersonalInfo();
                            break;
                    }
                } catch (BackException be) {
                    continue;
                } catch (ExitException | LogoutException e) {
                    throw e;
                }
            }
        }
        public static void showOwnerMyStudios() throws BackException, LogoutException, ExitException {
            int opt = 0;
            int ID;

            Studio selectedStudio = selectFromList(owner.getPartnerStudios(), "My studios", "studio");
            System.out.println(selectedStudio.getStudioInfo());
            if (makeDialog("Edit studio info")) {
                editOwnerStudioInfo(selectedStudio);
            }
        }
        public static int showOwnerPersonalInfo() throws BackException, LogoutException, ExitException {
            int opt;
            int x=10;
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Owner personal info: ");
            System.out.println(owner.toString());
            System.out.println("Owner personal info options: ");
            System.out.println("\t1) Edit personal info\n\t0) Exit\n\t-1) Back");

            do {
                System.out.print("Choose option: ");
                opt = keyboard.nextInt();

                switch (opt) {
                    case 1:
                        editOwnerPersonalInfo();
                        break;
                    case 0:
                        break;
                    case -1:
                        break;
                    default:
                        System.out.println("No such option");
                        break;
                }
            }while(opt < -1 || opt > 1);

            return opt;
        }
        public static void editOwnerStudioInfo(Studio stud) throws BackException, LogoutException, ExitException {
            char c;
            Scanner keyboard = new Scanner(System.in);

            String tempName = stud.getStudioName();
            String tempAdress = stud.getAddress();
            String tempPhone = stud.getPhone();
            ArrayList<Owner> tempOwnerList = stud.getPartnerOwners();
            ArrayList<Producer> tempProducerList = stud.getPartnerProducers();
            ArrayList<Room> tempRoomList = stud.getRooms();
            ArrayList<Equipment> tempEquipList = stud.getEquips();


            if(makeDialog("Change name?")) {
                System.out.print("Name: ");
                tempName = keyboard.next();
            }
            if(makeDialog("Chane adress?")) {
                System.out.print("Address: ");
                tempAdress = keyboard.next();
            }
            if(makeDialog("Change phone num?")) {
                System.out.print("Phone num: ");
                tempPhone = keyboard.next();
            }
            if(makeDialog("Edit studio owners?"))
               tempOwnerList = editStudioOwners(stud);
            if(makeDialog("Edit producers?"))
                tempProducerList = editStudioProducers(stud);
            if(makeDialog("Edit studio rooms?"))
                tempRoomList = editStudioRooms(stud);
            if(makeDialog("Edit equipment?"))
                tempEquipList = editStudioEquipment(stud);
            if(makeDialog("Save?")) {
                stud.setName(tempName);
                stud.setAddress(tempAdress);
                stud.setPhone(tempPhone);
                stud.setPartnerOwners(tempOwnerList);
                stud.setPartnerProducers(tempProducerList);
                stud.setEquips(tempEquipList);
                stud.setRooms(tempRoomList);
                System.out.println(stud.getStudioInfo());
            }
        }
        public static ArrayList<Owner> editStudioOwners(Studio stud) throws BackException, LogoutException, ExitException {
            int opt;
            int x;
            Scanner keyboard = new Scanner(System.in);
            int tempID;
            ArrayList<Owner> partOwnerList = stud.getPartnerOwners();
            Owner tempOwn;

            ArrayList<String> list = new ArrayList<>();
            list.add("Add Owner");
            list.add("Remove Owner");

            while(true) {
                try {
                    opt = makeMenu("Partner Owners options", list);
                    break;
                } catch (ExitException | LogoutException | BackException e) {
                    throw e;
                }
            }
            boolean f;
            switch (opt) {
                case 1:
                System.out.print("New Owner ID: ");
                tempID = keyboard.nextInt();
                f = false;

                for(Owner o : SampleInit.getOwnerList()) {
                    if(o.getOwnerId() == tempID) {
                        if(stud.getPartnerOwner(tempID) != null) {
                            System.out.println("This studio already has owner with ID " + tempID + ".");
                            f = true;
                            break;
                        }
                        else {
                            partOwnerList.add(o);
                            System.out.println("Owner added succesful.");
                            f = true;
                            break;
                        }
                    }
                }
                System.out.println(!f ? ("There is no registered owner with ID " + tempID + ".") : "");
                break;
            case 2:
                tempOwn = selectFromList(stud.getPartnerOwners(), "Studio partner owners", "partner owner");
                f = partOwnerList.remove(tempOwn);
                System.out.println(f ? ("Partner Owner removed successfully.") : ("Error removing owner."));
                break;
            }

            return partOwnerList;
        }
        public static ArrayList<Producer> editStudioProducers(Studio stud) throws LogoutException, BackException, ExitException {
            int opt;
            Scanner keyboard = new Scanner(System.in);
            int tempID;
            boolean f = false;
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<Producer> partProdList = stud.getPartnerProducers();

            list.add("New producer");
            list.add("Remove producer");

            opt = makeMenu("Studio producer options", list);

            switch(opt) {
                case 1:
                    f = false;
                    System.out.print("Producer ID: ");
                    tempID = keyboard.nextInt();
                    for(Producer p : SampleInit.getProdList()) {
                        if(p.getProducerId() == tempID) {
                            if(stud.getPartnerProducer(tempID) != null) {
                                System.out.println("Producer with ID " + tempID + " already exists.");
                                f = true;
                                break;
                            }
                            else {
                                partProdList.add(p);
                                System.out.println("Producer added successfully.");
                                f = true;
                            }
                        }
                    }
                    System.out.println(!f ? ("There is no registered producer with ID " + tempID + ".") : "");
                    break;
                case 2:
                    f = false;

                    Producer prod = selectFromList(stud.getPartnerProducers(),"Producers", "producer");
                    f = partProdList.remove(prod);
                    System.out.println(f ? ("Producer removed successfully.") : "Error removing producer.");
                    break;
            }

            return partProdList;
        }
        public static ArrayList<Room> editStudioRooms(Studio stud) throws LogoutException, BackException, ExitException {
            int opt;
            Scanner keyboard = new Scanner(System.in);
            boolean f = false;
            ArrayList<Room> roomList = stud.getRooms();

            int tempID;
            ArrayList<String> list = new ArrayList<>();

            list.add("New room");
            list.add("Remove room");

            opt = makeMenu("Room options", list);
            Room r;

            switch(opt) {
                case 1:
                    r = Room.makeNewRoom();
                    roomList.add(r);
                    System.out.println("Room info:\n" + r.toString());
                    break;
                case 2:
                    r = selectFromList(stud.getRooms(), "Rooms","room");
                    f = roomList.remove(r);
                    System.out.println(f ? "Room removed successfully." : "Error removing room ");
                    break;
            }

            return roomList;
        }
        public static ArrayList<Equipment> editStudioEquipment(Studio stud) throws LogoutException, BackException, ExitException {
            int opt;
            Scanner keyboard = new Scanner(System.in);
            boolean f = false;
            int ID;
            ArrayList<String> list = new ArrayList<>();
            ArrayList<Equipment> equipList = stud.getEquips();

            list.add("New studio");
            list.add("Remove studio");

            opt = makeMenu("Studio equipment options", list);

            System.out.print("Choose option: ");
            opt = keyboard.nextInt();

            Equipment e;

            switch(opt) {
                case 1:
                    e = Equipment.makeNewEquipment();
                    equipList.add(e);
                    System.out.println("Equipment info: ");
                    System.out.println(e.toString());
                    break;
                case 2:
                    e = selectFromList(stud.getEquips(),"Studio equipment", "equipment");
                    f = equipList.remove(e);
                    System.out.println(f ? "Equipment removed successfully." : "Error removing equipment.");
                    break;
            }

            return equipList;
        }
        public static void editOwnerPersonalInfo() throws LogoutException, BackException, ExitException {
            String tempName = owner.getName();
            String tempLastName = owner.getLastName();
            String tempPhone = owner.getPhone();
            String tempEmail = owner.getEmail();
            String tempPassword = owner.getPassword();

            char c;
            Scanner keyboard = new Scanner(System.in);

            if(makeDialog("Change phone number?")) {
                System.out.print("Phone number: ");
                tempPhone = keyboard.next();
            }
            if(makeDialog("Change email?")) {
                System.out.print("Email: ");
                tempEmail = keyboard.next();
            }
            if(makeDialog("Change password?")) {
                System.out.print("Password: ");
                tempPassword = keyboard.next();
            }
            if(makeDialog("Save?")) {
                owner.setName(tempName);
                owner.setLastName(tempLastName);
                owner.setPhone(tempPhone);
                owner.setEmail(tempEmail);
                owner.setPassword(tempPassword);
            }
        }
    }

    public static class ProducerUI {
        public static Producer producer;

        public static void showStartMenu() throws LogoutException, ExitException {
            Scanner keyboard = new Scanner(System.in);
            int opt = 0;
            int x = 10;
            ArrayList<String> list = new ArrayList<>();
            list.add("Show profile");

            while (true) {
                try {
                    opt = makeMenu("Producer options",list);

                    switch (opt) {
                        case 1:
                            showProducerProfile();
                            break;
                    }
                } catch (BackException be) {
                    continue;
                }
            }
        }
        public static void showProducerProfile() throws BackException, ExitException, LogoutException {
            int opt;

            ArrayList<String> list = new ArrayList<>();
            list.add("Show producer info");
            list.add("Shpw producer work");

            opt = makeMenu("Producer profile options",list);
            switch (opt) {
                case 1:
                    showProducerInfo();
                    break;
                case 2:
                    showProducerWork();
                    break;
            }
        }
        public static void showProducerInfo() throws BackException, ExitException, LogoutException {
            System.out.println("Producer info:");
            System.out.println(producer.toString());
            editProducerInfo();
        }

        public static void editProducerInfo() throws BackException, ExitException, LogoutException {
            Scanner keyboard = new Scanner(System.in);
            char c;
            String tempName = producer.getName();
            String tempLastName = producer.getLastName();
            String tempPhone = producer.getPhone();
            String tempEmail = producer.getEmail();
            String tempPassword = producer.getPassword();
            String tempStatus = producer.isStatus() ? "true" : "false";

            if(makeDialog("Chanhe phone num?")) {
                System.out.print("Phone num: ");
                tempPhone = keyboard.next();
            }
            if(makeDialog(("Change email?"))) {
                System.out.print("Email: ");
                tempEmail = keyboard.next();
            }
            if(makeDialog("Change password")) {
                System.out.print("Password: ");
                tempPassword = keyboard.next();
            }
            if(makeDialog("Change status?")) {
                System.out.print("Status [true/false]: ");
                tempStatus = keyboard.next();
            }
            if(makeDialog("Save?")) {
                producer.setPhone(tempPhone);
                producer.setEmail(tempEmail);
                producer.setPassword(tempPassword);
                producer.setStatus(tempStatus.equals("true") ? true : false);
            }

            System.out.println("");
        }

        public static void showProducerWork() throws BackException, ExitException, LogoutException {
            Scanner keyboard = new Scanner(System.in);
            int opt;
            int ID;

            System.out.println("Producer work:");
            producer.printWork();
            editProducerWork();
        }

        public static void editProducerWork() throws BackException, ExitException, LogoutException {
            Production prod = selectFromList(producer.getProductions(), "Production list: " , "production");

            if(!prod.isConfirmed()) {
                if(makeDialog("Confirm production?")) {
                    prod.setConfirmed(true);
                    System.out.println("Production confirmed.");
                }
                else {
                    boolean f = producer.getProductions().remove(prod);
                    System.out.println(f?"Production removed.":"Error removing production.");
                }
            }
            else {
                if(!prod.getProductionStatus()) {
                    if(makeDialog("Finished production?")) {
                        prod.setProductionStatus(true);
                    }
                }
            }
        }

    }

    public static <E> E selectFromList(ArrayList<E> elemList, String title, String optionStr) throws BackException, ExitException, LogoutException {
        int opt;
        ArrayList<String> list = new ArrayList<String>();

        for(E e : elemList) {
            list.add(e.toString());
        }
        opt = makeMenu(title,list, optionStr);
        return elemList.get(opt - 1);
    }
    public static <E> E selectFromList(ArrayList<E> elemList, String title) throws  BackException, ExitException, LogoutException {
        return selectFromList(elemList, title, "option");
    }
    public static int makeMenu(String menuTitle, ArrayList<String> optionList, String optionStr) throws BackException, ExitException, LogoutException  {
        Scanner keyboard = new Scanner(System.in);
        int i = 0;
        int opt;
        String str;

        System.out.println(menuTitle + ": ");
        for(String s : optionList) {
            System.out.println("\t" + ++i + ") " + s);
        }
        System.out.println("\n\t0) Exit\n\t-1) Back\n\t-2) Logout");

        while(true) {
            System.out.print("Choose " + optionStr + ": ");
            str = keyboard.nextLine();
            try {
                opt = Integer.parseInt(str);
                if(opt < -2 || opt > optionList.size())
                    throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("No such choice.");
                str = "";
            }
        }

        if(opt == 0) {
            throw new ExitException();
        }
        else if(opt == -1) {
            throw new BackException();
        }
        else if(opt == -2) {
            throw new LogoutException();
        }
        return opt;
    }
    public static int makeMenu(String str, ArrayList<String> optionList) throws BackException, ExitException,LogoutException {
        return makeMenu(str, optionList, "option");
    }
    public static boolean makeDialog(String message) {
        char c;
        String str;
        Scanner keyboard = new Scanner(System.in);

        while(true) {
            System.out.print(message + "[y/n]: ");
            str = keyboard.nextLine();

            try {
                if (str.length() != 1) {
                    throw new Exception();
                }
                c = str.charAt(0);
                if(c == 'y' || c == 'n') {
                    break;
                }
                else {
                    throw new Exception();
                }
            } catch(Exception e) {
                System.out.println("No such option.");
                str = "";
                c = '\0';
            }
        }

        return c == 'y';
    }
    public static int makeRatingDialog(String message) {
        String str;
        Scanner keyboard = new Scanner(System.in);
        int rating = 0;

        if(makeDialog("Rate " + message)){
            while(true) {
                System.out.print(message + ": ");
                str = keyboard.nextLine();

                try {
                   rating =  Integer.parseInt(str);
                   if(rating < 1 || rating > 5) {
                       throw new Exception();
                   }
                   break;
                } catch (Exception e) {
                    System.out.println("Rating values from 1-5");
                    str = "";
                }
            }
        }
        return rating;
    }


}

