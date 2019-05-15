import java.util.ArrayList;

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
//dates


}
