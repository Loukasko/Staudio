import java.util.ArrayList;

public class Producer extends User {
    // Variables
    private int producerId ;
    private boolean status;
    private int rating;
    private ArrayList<Studio> partnerStudios;
    private ArrayList<Production> productions;

    // Constructors
    public Producer(String name, String lastName, String phone, String email, String password, int producerId, boolean status, int rating) {
        super(name, lastName, phone, email, password);
        this.producerId = producerId;
        this.status = status;
        this.rating = rating;
    }

    // Setters - Getters
    public ArrayList<Studio> getPartnerStudios() {
        return partnerStudios;
    }
    public Studio getPartnerStudio(int studioId) {
        for(Studio s : this.partnerStudios) {
            if(s.getStudioId() == studioId) {
                return s;
            }
        }
        return null;
    }
    public boolean setPartnerStudio(Studio stud) {

        if(getPartnerStudio(stud.getStudioId()) != null) {
            return false;
        }
        this.partnerStudios.add(stud);
        return true;
    }
    public boolean deletePartnerStudio(int studioId) {
        Studio stud = getPartnerStudio(studioId);
        if(stud == null) {
            return false;
        }
        this.partnerStudios.remove(stud);
        return true;
    }
    public ArrayList<Production> getProductions() { return productions; }
    public Production getProduction(int productionId) {
        for(Production p : this.productions) {
            if(p.getReservationId() == productionId) {
                return p;
            }
        }
        return null;
    }
    public boolean setProduction(Production prod) {
        if(getProduction(prod.getReservationId()) != null) {
            return false;
        }
        this.productions.add(prod);
        return true;
    }
    public boolean deleteStudio(int studioId) {
        Studio stud = getPartnerStudio(studioId);
        if(stud == null) {
            return false;
        }
        this.partnerStudios.remove(stud);
        return true;
    }
    public int getProducerId() {
        return producerId;
    }
    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Producer ID: " + this.getProducerId() + "\n";
        String tempStr = super.toString().replaceAll("User", "Producer");
        str += "Producer status: " + this.isStatus() + "\n";
        str += "Producer rating: " + this.getRating() + "\n";
        str += "Producer partner studios:\n";
        for(Studio s : this.partnerStudios) {
            str += "\tStudio ID: " + s.getStudioId() + ", Studio adress: " + s.getAddress() + ", Phone: " + s.getPhone() + "\n";
        }
        str += "Producer productions:\n";
        for(Production p : this.productions) {
            str += "\tProduction ID: " + p.getReservationId() + ", Production studio: " + p.getStudio().getStudioId() + "\n";
        }

        return str;
    }
}