import java.util.ArrayList;

public class Reservation {
    private int reservationId;
    private int userId;
    private int StudioId;
    private boolean confirmed;

    private ArrayList<Equipment> listOfEquipment;

    public Reservation(int reservationId, int userId, int studioId, int roomId, boolean confirmed) {
        this.reservationId = reservationId;
        this.userId = userId;
        StudioId = studioId;
        this.confirmed = confirmed;

    }

    public ArrayList<Equipment> getListOfEquipment() {
        return listOfEquipment;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStudioId() {
        return StudioId;
    }

    public void setStudioId(int studioId) {
        StudioId = studioId;
    }


    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
