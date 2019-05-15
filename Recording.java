public class Recording extends Reservation {
    private enum type{laiko,rock,tsifteteli,punk,hiphop,psalmodia}
    private float costPerHour;
    private String startDate;
    private String endDate;

    public Recording(int reservationId, int userId, int studioId, int roomId, boolean confirmed, float costPerHour, String startDate, String endDate) {
        super(reservationId, userId, studioId, roomId, confirmed);
        this.costPerHour = costPerHour;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public float getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(float costPerHour) {
        this.costPerHour = costPerHour;
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
