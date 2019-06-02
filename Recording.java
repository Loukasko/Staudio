public class Recording extends Reservation {
    // Variables
    public enum type{laiko,rock,tsifteteli,punk,hiphop,psalmodia}
    private type recType;
    private float costPerHour;
    private String startDate;
    private String endDate;

    // Constructors
    public Recording(int reservationId, Client client, Studio studio, Room room, boolean confirmed, type recType, float costPerHour, String startDate, String endDate) {
        super(reservationId, client, studio, room, confirmed);
        this.recType = recType;
        this.costPerHour = costPerHour;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Setters - Getters
    public type getRecType() { return recType; }
    public void setRecType(type recType) { this.recType = recType; }
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
