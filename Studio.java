import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Studio {
    // Variables
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

    // Constructors
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

    // Setters - Getters
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public Room getRoom(int roomId) {
        for(Room r : this.rooms) {
            if(r.getRoomId() == roomId) {
                return r;
            }
        }
        return null;
    }
    public boolean setRoom(Room room) {
        if(getRoom(room.getRoomId()) != null)
        {
            return false;
        }
        this.rooms.add(room);
        return true;
    }
    public boolean deleteRoom(int roomId) {
        Room room = getRoom(roomId);
        if(room == null) {
            return false;
        }
        this.rooms.remove(room);
        return true;
    }
    public ArrayList<String> getAvailiableDates() {
        return availiableDates;
    }
    public String getAvaliableDate(String date) {
        for(String s : this.availiableDates) {
            if(s.equals(date)) {
                return s;
            }
        }
        return null;
    }
    public boolean setAvaliableDate(String date) {
        if(getAvaliableDate(date) != null) {
            return false;
        }
        this.availiableDates.add(date);
        return true;
    }
    public boolean deleteAvaliableDate(String date) {
        String avalDate = getAvaliableDate(date);
        if(avalDate == null) {
            return false;
        }
        this.availiableDates.remove(avalDate);
        return true;
    }
    public ArrayList getOffers() {
        return offers;
    }
    public Offer getOffer(int offerId) {
        for(Offer o : this.offers) {
            if(o.getOfferId() == offerId) {
                return o;
            }
        }
        return null;
    }
    public boolean setOffer(Offer off) {
        if(getOffer(off.getOfferId()) != null) {
            return false;
        }
        this.offers.add(off);
        return true;
    }
    public boolean deleteOffer(int offerId) {
        Offer off = getOffer(offerId);
        if(off == null) {
            return false;
        }
        this.offers.remove(off);
        return true;
    }
    public ArrayList getEquips() {
        return equips;
    }
    public boolean setEquips(Equipment eq) {
        for(Equipment e : this.equips) {
            if(e.getMusInsId() == eq.getMusInsId()) {
                return false;
            }
        }
        this.equips.add(eq);
        return true;
    }
    public ArrayList getPartnerProducers() {
        return partnerProducers;
    }
    public boolean setPartnerProducer(Producer prod) {
        for(Producer p : this.partnerProducers) {
            if(p.getProducerId() == prod.getProducerId()) {
                return false;
            }
        }
        return true;
    }
    public ArrayList getPartnerOwners() {
        return partnerOwners;
    }
    public boolean setPartnerOwner(Owner partOwn) {
        for(Owner o : this.partnerOwners) {
            if(o.getOwnerId() == partOwn.getOwnerId()) {
                return false;
            }
        }
        return true;
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
