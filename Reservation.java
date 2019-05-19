import java.util.ArrayList;

public class Reservation {
    private int reservationId;
    private int userId;
    private int StudioId;
    private boolean confirmed;
    private int roomId;

    private ArrayList<Equipment> listOfEquipment;

    public Reservation(int reservationId, int userId, int studioId, int roomId, boolean confirmed) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.StudioId = studioId;
        this.confirmed = confirmed;
        this.listOfEquipment=new ArrayList<>();
        this.roomId=roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public ArrayList<Equipment> getListOfEquipment() {
        return listOfEquipment;
    }

    public void addEquipment(Studio studio,int equipmentId) {
        Equipment musIns=studio.getEquipmentById(equipmentId);
        this.listOfEquipment.add(musIns);
    }

}
