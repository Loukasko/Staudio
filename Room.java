import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Room {

    private int roomId;

    private enum type {
        highend,
        rehearsal,
    }

    ;

    private enum size {
        small,
        medium,
        large
    }

    ;
    private int rating;
    private ArrayList<String> availiableRoomDates;
    private ArrayList<Reservation> listOfReservations; //not sure

    public Room(int roomId) {
        this.roomId = roomId;
        this.rating = 0;
    }

    public ArrayList<String> getAvailiableRoomDates() {
        return availiableRoomDates;
    }

    public ArrayList<Reservation> getListOfReservations() {
        return listOfReservations;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean checkRoomAvailiability(int studioId,String checkDate,int RoomId){
        for (String date:this.getAvailiableRoomDates()){
            if(date.equals(checkDate))return true;
        }
        return false;
    }
}
