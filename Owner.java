import java.util.ArrayList;

public class Owner extends User{

    private int ownerId;
    private ArrayList<Studio> partnerStudios;

    public Owner(String name, String lastName, String phone, String email, String password, int ownerId) {
        super(name, lastName, phone, email, password);
        this.ownerId = ownerId;
    }

    public ArrayList<Studio> getPartnerStudios() {
        return partnerStudios;
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
                    if (i.getOffers().get(j).getOfferId()==offerId) {
                        i.getOffers().get(j).setState(state);
                        return;
                    }
                }
            }
        }
    }
}
