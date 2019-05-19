public class Production extends Reservation{
    // Variables
    private enum type{miniAlbum,song,fullAlbum}
    private type prodType;
    private String startDay;
    private String endDay;
    private Producer producer;
    private float costPerMeeting;

    // Constructors
    public Production(int reservationId, Client client, Studio studio, Room room, boolean confirmed, type prodType, String startDay, String endDay, Producer producer, float costPerMeeting) {
        super(reservationId, client, studio, room, confirmed);
        this.prodType = prodType;
        this.startDay = startDay;
        this.endDay = endDay;
        this.producer = producer;
        this.costPerMeeting = costPerMeeting;
    }

    // Setters - Getters
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
    public Producer getProducer() { return producer; }
    public void setProducerId(Producer producer) { this.producer = producer; }
    public float getCostPerMeeting() { return costPerMeeting; }
    public void setCostPerMeeting(float costPerMeeting) { this.costPerMeeting = costPerMeeting; }
    public void printProductionInfo() { System.out.println(this.toString()); }

    @Override
    public String toString() {
        String str = "";

        str += super.toString().replaceAll("Reservation", "Production");
        str += "Production type: " + this.prodType + "\n";
        str += "Production start day: " + this.startDay + "\n";
        str += "Production end day: " + this.endDay + "\n";
        str += "Production producer: " + this.producer.getProducerId() + "\n";
        str += "Production cost per day: " + this.costPerMeeting + "\n";
        return str;
    }
}
