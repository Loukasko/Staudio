import java.util.ArrayList;

public class Client extends User{

    private int clientId;
    ArrayList<Reservation> history;

    public Client(String name, String lastName, String phone, String email, String password, int clientId) {
        super(name, lastName, phone, email, password);
        this.clientId = clientId;
    }

    public ArrayList<Reservation> getHistory() {
        return history;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }


}
