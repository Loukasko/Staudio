import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Room {
    // Variables
    private int roomId;
    private int rating;
    private float cost;

    public enum type {highend, rehearsal}
    private type roomType;

    public enum size {small, medium, large}
    private size roomSize;

    private ArrayList<String> availiableRoomDates;

    private ArrayList<Reservation> listOfReservations; //not sure

    // Constructions
    public Room(int roomId, type roomType, size roomSize, int rating, float cost) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomSize = roomSize;
        this.rating = rating;
        this.cost = cost;
        availiableRoomDates = new ArrayList<>();
        //listOfReservations=new ArrayList<>();
    }

    // Setters - Getters
    public ArrayList<String> getAvailiableRoomDates() {
        return availiableRoomDates;
    }

    public String getAvaliableRoomDate(String date) {
        for (String s : this.availiableRoomDates) {
            if (s.equals(date)) {
                return s;
            }
        }
        return null;
    }

    public boolean setAvaliableRoomDate(String date) {
        String avalDate = getAvaliableRoomDate(date);
        if (avalDate == null) {
            return false;
        }
        this.availiableRoomDates.add(date);
        return true;
    }

    public void addAvaliableRoomDate(String date) {
        this.getAvailiableRoomDates().add(date);
    }

    public boolean deleteAvaliableDate(String date) {
        String avalDate = getAvaliableRoomDate(date);
        if (avalDate.equals(date)) {
            this.availiableRoomDates.remove(avalDate);
            return true;
        }
        return false;
    }

    public ArrayList<Reservation> getListOfReservations() {
        return listOfReservations;
    }

    public Reservation getReservation(int resId) {
        for (Reservation r : this.listOfReservations) {
            if (r.getReservationId() == resId) {
                return r;
            }
        }
        return null;
    }

    public boolean setReservation(Reservation res) {
        if (getReservation(res.getReservationId()) == null) {
            this.listOfReservations.add(res);
            return true;
        }
        return false;
    }

    public boolean deleteReservation(int resId) {
        Reservation res = getReservation(resId);
        if (res == null) {
            return false;
        }
        this.listOfReservations.remove(res);
        return true;
    }

    public type getRoomType() {
        return roomType;
    }

    public void setRoomType(type roomType) {
        this.roomType = roomType;
    }

    public size getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(size roomSize) {
        this.roomSize = roomSize;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean checkRoomAvailiability(int studioId, String checkDate, int RoomId) {
        for (String date : this.getAvailiableRoomDates()) {
            if (date.equals(checkDate)) return true;
        }
        return false;
    }
}
