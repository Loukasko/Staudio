import java.util.ArrayList;

public class Offer {
    private int offerId;
    private enum type{recording,rehearsal};
    private int numOfReservations;
    private float cost;

    private ArrayList<Reservation> listOfReservations;


    public Offer(int offerId, int numOfReservations, float cost, ArrayList<Reservation> listOfReservations) {
        this.offerId = offerId;
        this.numOfReservations = numOfReservations;
        this.cost = cost;
        this.listOfReservations = listOfReservations;
    }

    public ArrayList<Reservation> getListOfReservations() {
        return listOfReservations;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getNumOfReservations() {
        return numOfReservations;
    }

    public void setNumOfReservations(int numOfReservations) {
        this.numOfReservations = numOfReservations;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
