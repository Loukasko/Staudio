import java.util.ArrayList;

public class Producer extends User {

    private int producerId ;
    private boolean status;
    private int rating;

    private ArrayList<Studio> partnerStudios;
    private ArrayList<Production> history;

    public Producer(String name, String lastName, String phone, String email, String password, int producerId, boolean status, int rating) {
        super(name, lastName, phone, email, password);
        this.producerId = producerId;
        this.status = status;
        this.rating = rating;
        this.partnerStudios=new ArrayList<>();
        this.history=new ArrayList<>();
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

    public ArrayList<Studio> getPartnerStudios() {
        return partnerStudios;
    }

    public ArrayList<Production> getHistory() {
        return history;
    }
}
