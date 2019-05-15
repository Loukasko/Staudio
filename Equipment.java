import java.util.ArrayList;

public class Equipment {
    private int musInsId;
    private String name;
    private enum type{violi,klarino,kithara,baglamas,drums,fysarmonika};
    private ArrayList<String> availiableDates;

    public Equipment(int musInsId, String name, ArrayList<String> availiableDates) {
        this.musInsId = musInsId;
        this.name = name;
        this.availiableDates = availiableDates;
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

    public ArrayList<String> getAvailiableDates() {
        return availiableDates;
    }

    public void setAvailiableDates(ArrayList<String> availiableDates) {
        this.availiableDates = availiableDates;
    }
}
