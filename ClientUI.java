import org.w3c.dom.Text;

import java.util.Scanner;

public class ClientUI {
    public ClientUI(Client client) {
        showClientUI(client);
    }

    public void showClientUI(Client client) {
        int option;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Client options: ");
            System.out.println("1) Rehearsal");
            System.out.println("2) Recording");
            System.out.println("3) Production");
            System.out.println("4) Rate");
            System.out.println("0) Back");
            option = sc.nextInt();
            if (option == 1) {
//                System.out.println("Please select Studio from the list below");
//                for (int i = 0; i < SampleInit.getStudioList().size(); i++) {
//                    System.out.println(i + 1 + ")" + SampleInit.getStudioList().get(i).getStudioName());
//                }
//                option = sc.nextInt();
//                Studio selectedStudio = SampleInit.getStudioList().get(option - 1);
                Studio selectedStudio = SampleInit.getStudioList().get(showClientAvailiableStudios(sc) - 1);

                System.out.println("Please select Room from the list below");
                for (int j = 0; j < selectedStudio.getRooms().size(); j++) {
                    System.out.print(j + 1 + ")");
                    System.out.println("Room Rating:" + selectedStudio.getRooms().get(j).getRating());
                    System.out.print("Cost:" + selectedStudio.getRooms().get(j).getCost() + "\t");
                    System.out.print("Type:" + selectedStudio.getRooms().get(j).getRoomType() + "\t");
                    System.out.println("Size:" + selectedStudio.getRooms().get(j).getRoomSize());
                }
                option = sc.nextInt();
                Room selectedRoom = selectedStudio.getRooms().get(option - 1);

                System.out.println("Please select Date from the available below");
                for (int j = 0; j < selectedRoom.getAvailiableRoomDates().size(); j++) {
                    System.out.println(j + ")" + selectedRoom.getAvailiableRoomDates().get(j));
                }
                option = sc.nextInt();
                String selectedDate = selectedRoom.getAvailiableRoomDates().get(option);
                System.out.println("Synopsis");
                System.out.println("Studio:" + selectedStudio.getStudioName());
                System.out.print("Room Size:" + selectedRoom.getRoomSize() + "\t");
                System.out.print("Room Type:" + selectedRoom.getRoomType() + "\t");
                System.out.println("Room Cost:" + selectedRoom.getCost());
                System.out.println("Date:" + selectedDate);
                System.out.println("Ready for rehearsal ?");
                System.out.println("1)yes 2)No");
                option = sc.nextInt();
                if (option == 1) {
                    new Rehearsal(Reservation.idAutoIncrement(), client, selectedStudio, selectedRoom, false, selectedRoom.getCost(), null, selectedDate, null);
                    System.out.println("New book request sent. Reservation currently pending.");
                } else {
                    System.out.println("canceled");
                }
                break;
            } else if (option == 2) {
//                System.out.println("Please select Studio from the list below");
//                for (int i = 0; i < SampleInit.getStudioList().size(); i++) {
//                    System.out.println(i + 1 + ")" + SampleInit.getStudioList().get(i).getStudioName());
//                }
//                option = sc.nextInt();
                Studio selectedStudioRecording = SampleInit.getStudioList().get(showClientAvailiableStudios(sc) - 1);
                System.out.println("What musical instrument would you like to record ?");
                int i = 1;
                for (Recording.type instrument : Recording.type.values()) {
                    System.out.print(i + ")");
                    i++;
                    System.out.println(instrument);
                }
                option = sc.nextInt();
                Recording.type recordingType = Recording.type.values()[option - 1];
                System.out.println("Would you like to rent equipment ?");
                System.out.println("1)yes");
                System.out.println("2)no");
                option = sc.nextInt();
                if (option == 1) {
                    //select equipment
                }
                System.out.println("Please select Date from the available below");
                for (i = 0; i < selectedStudioRecording.getRooms().get(1).getAvailiableRoomDates().size(); i++) {
                    System.out.println(i + 1 + ")" + selectedStudioRecording.getRooms().get(1).getAvailiableRoomDates().get(i));
                }
                option = sc.nextInt();
                String selectedDateRecording = selectedStudioRecording.getRooms().get(1).getAvailiableRoomDates().get(option);
                System.out.println("Would you like to leave a comment?");
                System.out.println("1.yes?");
                System.out.println("2.no");
                option = sc.nextInt();
                if (option == 1) {
//                        leaves coomment
                }
                System.out.println("Synopsis");
                System.out.println("Studio:" + selectedStudioRecording.getStudioName());
                System.out.println("Type of recording " + recordingType);
                System.out.println("Date:" + selectedDateRecording);
                System.out.println("Ready to record?");
                System.out.println("1)yes 2)No");

                option = sc.nextInt();
                if (option == 1) {
                    new Recording(Reservation.idAutoIncrement(), client, selectedStudioRecording, null, false, recordingType, 0, selectedDateRecording, null);
                    System.out.println("New book request sent. Reservation currently pending.");
                }
                break;

            } else if (option == 3) {

            } else if (option == 4) {

                int sound = 0;
                int staff = 0;
                int environment = 0;
                System.out.println("Which studio would you like to rate?");
                System.out.println("(You can rate only studios you have visited)");
                for (int j = 0; j < client.getHistory().size(); j++) {
                    System.out.println(client.getHistory().get(j).getStudio().getStudioName());
                }
                option = sc.nextInt();
                Studio selectedStudioRate = client.getHistory().get(option).getStudio();

                System.out.println("Rate sound?");
                System.out.println("1)yes 2)No");
                option = sc.nextInt();
                if (option == 1) {
                    while (true) {
                        System.out.println("Sound Rating (1-5)");
                        sound = sc.nextInt();
                        if ((sound >= 0) && (sound <= 5)) {
                            break;
                        } else {
                            System.out.println("Rating values from 1 to 5 ");
                        }
                    }
                }
                System.out.println("Rate environment?");
                System.out.println("1)yes 2)No");
                option = sc.nextInt();
                if (option == 1) {
                    while (true) {
                        System.out.println("Environment Rating (1-5)");
                        environment = sc.nextInt();
                        if ((environment >= 0) && (environment <= 5)) {
                            break;
                        } else {
                            System.out.println("Rating values from 1 to 5 ");
                        }
                    }
                }
                System.out.println("Rate staff?");
                System.out.println("1)yes 2)No");
                option = sc.nextInt();
                if (option == 1) {
                    while (true) {
                        System.out.println("Environment Rating (1-5)");
                        staff = sc.nextInt();
                        if ((staff >= 0) && (staff <= 5)) {
                            break;
                        } else {
                            System.out.println("Rating values from 1 to 5 ");
                        }
                    }
                }
                client.rate(selectedStudioRate,sound,environment,staff);
            } else {
                break;
            }
        }
        new BasicUI();
    }

    public int showClientAvailiableStudios(Scanner sc) {

        System.out.println("Please select Studio from the list below");
        for (int i = 0; i < SampleInit.getStudioList().size(); i++) {
            System.out.println(i + 1 + ")" + SampleInit.getStudioList().get(i).getStudioName());
        }
        return sc.nextInt();

    }
}