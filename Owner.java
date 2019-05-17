import java.util.ArrayList;

public class Owner extends User{

    private int ownerId;
    private ArrayList<Studio> partnerStudios;
    private ArrayList<Reservation> reservationId;

    public Owner(String name, String lastName, String phone, String email, String password, int ownerId) {
        super(name, lastName, phone, email, password);
        this.ownerId = ownerId;
    }

    public ArrayList<Studio> getPartnerStudios() {
        return partnerStudios;
    }

    public ArrayList<Reservation> getReservationId() {
        return reservationId;
    }
    public void confirmResevation(Studio studio,User user, Reservation reservation,Room room, boolean pending, boolean accept){
        for (Studio i:this.getPartnerStudios()){
            if(i.getStudioId()==studio){
                for (Reservation j:i.getReservations()){
                    if(j.getReservationId() == reservation){
                        if(j.isConfirmed() == pending) {
                            if (accept == true) {
                                j.setConfirmed(true);
                                System.out.println("The reservation of the user" + user + " is confirmed");
                            } else {
                                i.getReservations().remove(reservation);
                                System.out.println("The reservation of the user" + user + " is declined");
                            }
                            //ή μπορώ να χω 2 συναρτήσεις , που η μια να κάνει κονφιρμ πχ και η άλλη να κάνει αλλαγές ( ίδιο όνομα , διαφορετικά ορίσματα)(sId,us9d,res9d,pend) , mr(5orismata) diaforetikh
                            //ή να καλεί την ίδια συνάρτηση και να βάλεις να έχει αν θες να πειράξεις μονο το pending και όχι πχ μουσικό όργανο
                        }   // , τότε να έχει default τιμές τα ορίσματα πχ null , και τσεκάρεις να είναι null με if και αν ναι τότε δεν αλλάζεις πχ (int musinsid:default null)
                    }
                }
            }
        }
    }

    public void manageReservationRoom(Studio studio, Reservation reservation,Room room, boolean acceptChanges){
        for (Studio i:this.getPartnerStudios()) {
            if (i.getStudioId() == studio) {
                for (Reservation j : i.getReservations()) {
                    if (j.getReservationId() == reservation) {
                        if (j.getRoomId() == room) {
                            j.setRoomId(room);
                        }
                    }

                }
            }
        }
    }


    public void makeOwnOffer(String type, int resNum, int free , int studioId, boolean state) {
            for(Studio i:this.getPartnerStudios()){
                if(i.getStudioId()==studioId){
                    Offer offer = new Offer(resNum,free,type,state);
                }
            }
    }

    public void addOffer(int studioId,int offerId,boolean state){
        for(Studio i:this.getPartnerStudios()){
            if(i.getStudioId()==studioId){
                for(int j=0;j<i.getOffers().size();j++){
                    if (i.getOffers().get(j).getOfferId()==offerId){
                        i.getOffers().get(j).setState(state);
                        return;
                    }
                }
            }
        }
    }
}
