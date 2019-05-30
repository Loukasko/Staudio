import java.util.ArrayList;

public class Client extends User{
    // Variables
    private int clientId;
    ArrayList<Reservation> history;

    //Constructors
    public Client(String name, String lastName, String phone, String email, String password, int clientId) {
        super(name, lastName, phone, email, password);
        this.clientId = clientId;
        this.history=new ArrayList<>();
    }

    // Setters - Getters
    public ArrayList<Reservation> getHistory() { return history; }
    public Reservation getHistoryReservation(int resId) {
        for(Reservation r : this.history) {
            if(r.getReservationId() == resId) {
                return r;
            }
        }
        return null;
    }
    public boolean setHistoryReservation(Reservation res) {
        if(getHistoryReservation(res.getReservationId()) != null) {
            return false;
        }
        this.history.add(res);
        return true;
    }
    public boolean deleteHistoryReservation(int resId) {
        Reservation res = getHistoryReservation(resId);
        if(res == null) {
            return false;
        }
        this.history.remove(res);
        return true;
    }
    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    @Override
    public String toString() {
        String str = "";
        String tempStr = "";

        str += "Client ID: " + this.getClientId() + "\n";
        tempStr = super.toString().replaceAll("User", "Client");
        str += tempStr;
        str += "History:\n";
        for(Reservation r : this.history) {
            str += "\tReservation id: " + r.getReservationId() + ", StudioId: " + r.getStudio().getStudioId() + ", Confirmed: " + r.isConfirmed() + "\n";
        }

        return str;
    }

//    public void rate(Studio studio, int reservationId, int soundRating, int environmentRating, int staffRating) {//analoga an epelekse na vathmologisei kai sound kai environment kai staff , prosarmozetai o paronomasths tou mesou orou tou rating
//        int div=3;
//        if (soundRating==0){
//            div-=1;
//        }
//        if (environmentRating==0){
//            div-=1;
//        }
//        if (staffRating==0){
//            div-=1;
//        }
//
//        if (checkRating(soundRating) && checkRating(environmentRating) && checkRating(staffRating)&&(div!=0)) {
//            Reservation reservation = this.getReservationById(reservationId);
//            if (reservation != null) {
//                int mo = soundRating + environmentRating + staffRating;
//                mo = mo / div;
//                studio.setOverallRating(mo);
//            }
//        }
//    }
//    private boolean checkRating(int rating) {
//        if ((rating <= 5) && (rating >= 1)) {
//            return true;
//        }
//        return false;
//    }

}
