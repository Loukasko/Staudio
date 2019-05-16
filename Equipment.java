import java.util.ArrayList;

public class Equipment {
    private int musInsId;
    private String name;
    private enum type{violi,klarino,kithara,baglamas,drums,fysarmonika};
    private ArrayList<String> availiableMusInsDates;

    public Equipment(int musInsId, String name, ArrayList<String> availiableMusInsDates) {
        this.musInsId = musInsId;
        this.name = name;
        this.availiableMusInsDates = availiableMusInsDates;
    }

    public int getMusInsId() {
        return musInsId;
    }

    public void setMusInsId(int musInsId) {
        this.musInsId = musInsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAvailiableMusInsDates() {
        return availiableMusInsDates;
    }

    public void setAvailiableMusInsDates(ArrayList<String> availiableMusInsDates) {
        this.availiableMusInsDates = availiableMusInsDates;
    }

    public boolean checkMusInsAvailiability(String checkDate){
        for(String date:this.getAvailiableMusInsDates()){
            if(date.equals(checkDate))return true;
        }
        return false;
    }
}
