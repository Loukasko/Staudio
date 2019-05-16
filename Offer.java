import java.util.ArrayList;

public class Offer {
    private int offerId;
    private enum type{recording,rehearsal};
    private int numOfReservations;
    private int free;
    private boolean state;


    private ArrayList<Reservation> listOfReservations;


    public Offer( int numOfReservations,int free,String type, boolean state) {
        //this.offerId = offerId;
        this.numOfReservations = numOfReservations;
        this.free = free;
        this.state = state;
    }

//    public ArrayList<Reservation> getListOfReservations() {
//        return listOfReservations;
//    }

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

    public float getFree() {
        return free;
    }

    public void setFree(float cost) {
        this.free = free;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}
