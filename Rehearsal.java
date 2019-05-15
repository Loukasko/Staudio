import org.w3c.dom.Text;

public class Rehearsal extends Reservation {
    private int roomId;
    private float costPerHour;
    private Text comments;
    private String startDate;
    private String endDate;

    public Rehearsal(int reservationId, int userId, int studioId, int roomId, boolean confirmed, int roomId1, float costPerHour, Text comments, String startDate, String endDate) {
        super(reservationId, userId, studioId, roomId, confirmed);
        this.roomId = roomId1;
        this.costPerHour = costPerHour;
        this.comments = comments;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public float getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(float costPerHour) {
        this.costPerHour = costPerHour;
    }

    public Text getComments() {
        return comments;
    }

    public void setComments(Text comments) {
        this.comments = comments;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
