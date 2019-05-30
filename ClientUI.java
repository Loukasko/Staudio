import java.util.Scanner;

public class ClientUI {
    public ClientUI() {
        int option;
        while (true) {
            System.out.println("Client options: ");
            System.out.println("1) Rehearsal");
            System.out.println("2) Recording");
            System.out.println("3) Production");
            System.out.println("0) Exit");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Please select Studio from the list below");
                    for (int i = 0; i < SampleInit.getStudioList().size(); i++) {
                        System.out.println(i+1 + ")" + SampleInit.getStudioList().get(i).getStudioName());
                    }
                    option = sc.nextInt();
                    Studio selectedStudio = SampleInit.getStudioList().get(option-1);

                    System.out.println("Please select Room from the list below");
                    for (int j = 0; j < selectedStudio.getRooms().size(); j++) {
                        System.out.print(j+1 + ")");
                        System.out.println("Room Rating:" + selectedStudio.getRooms().get(j).getRating());
                        System.out.print("Cost:" + selectedStudio.getRooms().get(j).getCost() + "\t");
                        System.out.print("Type:" + selectedStudio.getRooms().get(j).getRoomType() + "\t");
                        System.out.println("Size:" + selectedStudio.getRooms().get(j).getRoomSize());
                    }
                    option = sc.nextInt();
                    Room selectedRoom = selectedStudio.getRooms().get(option-1);

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
                        new Reservation(1, null, selectedStudio, selectedRoom, false);
                        System.out.println("New book request sent. Reservation currently pending.");
                    }else{
                        System.out.println("canceled");
                    }
                    break;
                case 2:
                    System.out.println("Select Studio from the list below");
                    for (int i = 0; i < SampleInit.getStudioList().size(); i++) {
                        System.out.println(i + ")" + SampleInit.getStudioList().get(i).getStudioName());
                    }
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }
    }
}
