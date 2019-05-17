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
    public void manageResevation(Studio studioId,User userId, Reservation reservationId,Room roomId, boolean pending, boolean accept){
        for (Studio i:this.getPartnerStudios()){
            if(i.getStudioId()==studioId){
                for (Reservation j:this.getReservationId()){
                    if(j.getReservationId() == reservationId){
                        if(j.isConfirmed() == pending && accept==true){
                            Reservation reservation = new Reservation(Studio studioId,User userId, Reservation reservationId,Room roomId, boolean pending);
                        }else if()
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
