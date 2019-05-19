import java.util.ArrayList;

public class Client extends User {

    private int clientId;
    ArrayList<Reservation> history;

    public Client(String name, String lastName, String phone, String email, String password, int clientId) {
        super(name, lastName, phone, email, password);
        this.clientId = clientId;
        this.history = new ArrayList<>();
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

    //ehei lathos . thelei orisma studioId alla den einai apothikeymena ta studio kapou sth parousa ekdosh
    public void rate(Studio studio, int reservationId, int soundRating, int environmentRating, int staffRating) {//analoga an epelekse na vathmologisei kai sound kai environment kai staff , prosarmozetai o paronomasths tou mesou orou tou rating
        int div=3;
        if (soundRating==0){
            div-=1;
        }
        if (environmentRating==0){
            div-=1;
        }
        if (staffRating==0){
            div-=1;
        }

        if (checkRating(soundRating) && checkRating(environmentRating) && checkRating(staffRating)&&(div!=0)) {
            Reservation reservation = this.getReservationById(reservationId);
            if (reservation != null) {
                int mo = soundRating + environmentRating + staffRating;
                mo = mo / div;
                studio.setOverallRating(mo);
            }
        }
    }

    public Reservation getReservationById(int reservationId) {
        for (Reservation i : this.history) {
            if (i.getReservationId() == reservationId) {
                return i;
            }
        }
        return null;
    }

    private boolean checkRating(int rating) {
        if ((rating <= 5) && (rating >= 1)) {
            return true;
        }
        return false;
    }


}
