import java.util.ArrayList;

public class Offer {

    // Variables
    private int offerId;
    private Studio studio;
    public enum type{recording,rehearsal};
    private type recType;
    private int numOfReservations;
    private int free;
    private boolean state;
    private ArrayList<Reservation> listOfReservations;
    //private ArrayList<Studio> listOfStudios;
    private ArrayList<Offer> listOfOffers;


    // Constructors
    public Offer(int offerId, Studio studio, int numOfReservations,int free,type recType, boolean state) {
        this.offerId = offerId;
        this.studio = studio;
        this.recType = recType;
        this.numOfReservations = numOfReservations;
        this.free = free;
        this.state = state;
        //this.listOfStudios = new ArrayList<Studio>();
        this.listOfOffers = new ArrayList<Offer>();
        this.listOfReservations = new ArrayList<Reservation>();
    }

    // Setters - Getters
    public int getOfferId() { return offerId; }
    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
    public type getRecType() { return this.recType; }
    public void setRecType() { this.recType = recType; }
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
    public void setState(boolean state) { this.state = state; }
    public ArrayList<Reservation> getListOfReservations() { return listOfReservations; }
    public Reservation getReservation(int resId) {
        for(Reservation r : this.listOfReservations) {
            if(r.getReservationId() == resId) {
                return r;
            }
        }
        return null;
    }
    public boolean setReservation(Reservation res) {
        if(getReservation(res.getReservationId()) == null) {
            return false;
        }
        this.listOfReservations.add(res);
        return true;
    }
    public boolean deleteReservation(int resId) {
        Reservation res = getReservation(resId);
        if(res == null) {
            return false;
        }
        this.listOfReservations.remove(res);
        return true;
    }
}
