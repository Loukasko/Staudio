import java.util.ArrayList;

public class Room {

    private int roomId;
    private enum type {highend,rehearsal,};
    private enum size {small,medium,large};
    private int rating;

    private ArrayList<Reservation> listOfReservations; //not sure

    public Room(int roomId, int rating) {
        this.roomId = roomId;
        this.rating = rating;
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
}
