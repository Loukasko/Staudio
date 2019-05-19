import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Studio {
    private int studioId;
    private String address;
    private String phone;
    private double lat;
    private double lng;
    private int overallRating;

    private ArrayList<Producer> partnerProducers;
    private ArrayList<Owner> partnerOwners;
    private ArrayList<Offer> offers;
    private ArrayList<Equipment> equips;
    private ArrayList<String> availiableDates;
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Studio(int studioId, String address, String phone, double lat, double lng,
                  int overallRating) {
        this.studioId = studioId;
        this.address = address;
        this.phone = phone;
        this.lat = lat;
        this.lng = lng;
        this.overallRating = overallRating;
        this.partnerProducers = new ArrayList<>();
        this.partnerOwners = new ArrayList<>();
        this.offers = new ArrayList<>();
        this.equips = new ArrayList<>();
        this.availiableDates = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.reservations=new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<String> getAvailiableDates() {
        return availiableDates;
    }

    public ArrayList getOffers() {
        return offers;
    }

    public ArrayList getEquips() {
        return equips;
    }

    public ArrayList getPartnerProducers() {
        return partnerProducers;
    }

    public ArrayList getPartnerOwners() {
        return partnerOwners;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public boolean checkDateAvailiability(String checkDate){
        for(String date:this.getAvailiableDates()){
            if(date.equals(checkDate))return true;
        }
        return false;
    }

    public Reservation getReservationById(int reservationId){
        for(Reservation i:this.reservations){
            if(i.getStudioId()==reservationId){
                return i;
            }
        }
        return null;
    }

    public Room getRoomById(int roomId){
        for(Room i:this.rooms){
            if(i.getRoomId()==roomId){
                return i;
            }
        }
        return null;
    }

    public Equipment getEquipmentById(int equipmentId){
        for(Equipment i:this.equips){
            if(i.getMusInsId()==equipmentId){
                return i;
            }
        }
        return null;
    }

    public Offer getOfferById(int offerId) {
        for (Offer i : this.offers) {
            if (i.getOfferId() == offerId) {
                return i;
            }
        }
        return null;
    }

}
