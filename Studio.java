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

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public Studio(int studioId, String address, String phone, double lat, double lng,
                  int overallRating, ArrayList<Producer> partnerProducers,
                  ArrayList<Owner> partnerOwners, ArrayList<Offer> offers, ArrayList<Equipment> equips,
                  ArrayList<String> availiableDates, ArrayList<Room> rooms) {
        this.studioId = studioId;
        this.address = address;
        this.phone = phone;
        this.lat = lat;
        this.lng = lng;
        this.overallRating = overallRating;
        this.partnerProducers = partnerProducers;
        this.partnerOwners = partnerOwners;
        this.offers = offers;
        this.equips = equips;
        this.availiableDates = availiableDates;
        this.rooms = rooms;
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

    public boolean checkDateAvailiability(String checkDate){
//        getAvailiableDates().forEach((date)->{
//            if(date.equals(checkDate));
//        });

        for(String date:this.getAvailiableDates()){
            if(date.equals(checkDate))return true;
        }
        return false;
    }

//    public Studio getStudio(int studioId){
//        Iterator i = this.getStudios().iterator();
//
//    }



}
