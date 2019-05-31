import java.util.Scanner;

public class OwnerUI {

    public OwnerUI(Owner owner) {
        int option;

        while (true) {
            System.out.println("Owner option : ");
            System.out.println("1) Show My Studios");
            System.out.println("2) Personal Info");
            System.out.println("0) Exit");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            switch (option) {
                case 1:
                    for (int i = 0; i < SampleInit.getStudioList().size(); i++) {
                        System.out.println(i + 1 + ")" + SampleInit.getStudioList().get(i).getStudioName());
                    }
                    option = sc.nextInt();
                    Studio selectedStudio = SampleInit.getStudioList().get(option - 1);

                    System.out.println("Please select a Reservation from the list below");
                    for (int j = 0; j < selectedStudio.getReservations().size(); j++) {
                        //System.out.print("poutsa");
                        System.out.print(j + 1 + ")");
                        System.out.println("Reservation ID:" + selectedStudio.getReservations().get(j).getReservationId());
                        System.out.print("Client of the Reservation:" + selectedStudio.getReservations().get(j).getClient() + "\t");
                        System.out.print("Room of the Reservation:" + selectedStudio.getReservations().get(j).getRoom() + "\t");
                        System.out.println("Is the reservation Confirmed:" + selectedStudio.getReservations().get(j).isConfirmed());
                    }

                    option = sc.nextInt();
                    Reservation selectedReservation = selectedStudio.getReservations().get(option - 1);

                    for (int j = 0; j < selectedStudio.getReservations().size(); j++) {
                        if(selectedReservation.isConfirmed() == false){
                        System.out.println("You have a pending reservation");
                        System.out.println("Select an option: ");
                        System.out.println("1) Reservation Details");
                        System.out.println("2) Accept Reservation");
                        System.out.println("3) Decline Reservation");

                        option = sc.nextInt();

                        }
                        else{
                            System.out.println("You have a non-pending reservation");
                            System.out.println("Edit Your Reservation ");
                            System.out.println("1) Edit Reservation Room");
                            System.out.println("2) Edit Reservation Equipment");
                            System.out.println("0) Exit ");

                        }

                    }


                    //System.out.println("Please select Date from the available below");
                    //for (int j = 0; j < selectedRoom.getAvailiableRoomDates().size(); j++) {
                    //    System.out.println(j + ")" + selectedRoom.getAvailiableRoomDates().get(j));
                    //}
                    //option = sc.nextInt();
                    //String selectedDate = selectedRoom.getAvailiableRoomDates().get(option);
                    //System.out.println("Synopsis");
                    //System.out.println("Studio:" + selectedStudio.getStudioName());
                    //System.out.print("Room Size:" + selectedRoom.getRoomSize() + "\t");
                    //System.out.print("Room Type:" + selectedRoom.getRoomType() + "\t");
                    //System.out.println("Room Cost:" + selectedRoom.getCost());
                    //System.out.println("Date:" + selectedDate);
                    //System.out.println("Ready for rehearsal ?");
                    //System.out.println("1)yes 2)No");
                    //option = sc.nextInt();
                    //if (option == 1) {
                     //   new Reservation(1, null, selectedStudio, selectedRoom, false);
                     //   System.out.println("New book request sent. Reservation currently pending.");
                    //} else {
                     //   System.out.println("canceled");
                    //}
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


