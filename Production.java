public class Production extends  Reservation{
    private enum type{miniAlbum,song,fullAlbum}
    private String startDay;
    private String endDay;
    private int producerId;
    private float costPerMeeting;
    private boolean accepted;


    public Production(int reservationId, int userId, int studioId, int roomId, boolean confirmed, String startDay, String endDay, int producerId, float costPerMeeting) {
        super(reservationId, userId, studioId, roomId, confirmed);
        this.startDay = startDay;
        this.endDay = endDay;
        this.producerId = producerId;
        this.costPerMeeting = costPerMeeting;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public float getCostPerMeeting() {
        return costPerMeeting;
    }

    public void setCostPerMeeting(float costPerMeeting) {
        this.costPerMeeting = costPerMeeting;
    }
}
