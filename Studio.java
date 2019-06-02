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
    private String studioName;
    private ArrayList<Producer> partnerProducers;
    private ArrayList<Owner> partnerOwners;
    private ArrayList<Offer> offers;
    private ArrayList<Equipment> equips;
    private ArrayList<String> availiableDates;
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    // Constructors
    public Studio(String studioName,int studioId, String address, String phone, double lat, double lng,int overallRating)  {
        this.studioName=studioName;
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

    // Setters - Getters
    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }
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

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    public Reservation getReservation(int reservationId) {
        for(Reservation r : this.reservations) {
            if(r.getReservationId() == reservationId) {
                return r;
            }
        }
        return null;
    }
    public boolean setReservation(Reservation res) {
        if (getReservation(res.getReservationId()) != null) {
            return false;
        }
        res.setStudio(this);
        return this.reservations.add(res);
    }

    public boolean deleteReservation(int reservationId) {
        Reservation res = getReservation(reservationId);
        if (res == null) {
            return false;
        }
        this.reservations.remove(res);
        return true;
    }

    public ArrayList<Offer> getOffers() {
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
    //public ArrayList<Reservation> getReservations() {
    //    return reservations;
    //}

    public boolean checkDateAvailiability(String checkDate){
//        getAvailiableDates().forEach((date)->{
//            if(date.equals(checkDate));
//        });

        for(String date:this.getAvailiableDates()){
            if(date.equals(checkDate))return true;
        }
        return false;
    }
    @Override
    public String toString() {
        String str = "";
        str += "Studio name: " + this.getStudioName() + "\n";
        str += "Studio ID: " + this.getStudioId() + "\n";
        str += "Studio adress: " + this.getAddress() + "\n";
        str += "Studio overall rating: " + this.getOverallRating() + "\n";
        str += "Studio phone: " + this.getPhone() + "\n";
        str += "Studio lat: " + this.getLat() + "\n";
        str += "Studio lng: " + this.getLng() + "\n";
        str += "Studio owner" + (this.getPartnerOwners().size() > 1 ? "s" : "") + ": ";
        for(Owner o : this.partnerOwners) {
            str += (o==partnerOwners.get(0) ? "" : ", ") + o.getOwnerId();
        }
        str += "\n";
        str += "Studio producer" + (this.getPartnerProducers().size() > 1 ? "s" : "") + ": ";
        for(Producer p : this.partnerProducers) {
            str += (p==partnerProducers.get(0) ? "" : ", ") + p.getProducerId();
        }
        str += "\n";
        str += "Studio rooms:\n";
        for(Room r : this.rooms) {
            str += r.getRoomId() + "\n";
        }
        str += "Studio equipment:\n";
        for(Equipment e : this.equips) {
            str += e.getMusInsId() + "\n";
        }
        str += "Studio avaliable dates:\n";
        for(String s : this.availiableDates) {
            str += s + "\n";
        }
        str += "Studio reservations:\n";
        for(Reservation r : this.reservations) {
            str += r.getReservationId() + "\n";
        }
        str += "Studio offers:\n";
        for(Offer o : this.offers) {
            str += o.getOfferId();
        }
        str += "\n";
        return str;
    }

//    public Studio getStudio(int studioId){
//        Iterator i = this.getStudios().iterator();
//
//    }



}
