public class Owner extends User{

    private int ownerId;

    public Owner(String name, String lastName, String phone, String email, String password, int ownerId) {
        super(name, lastName, phone, email, password);
        this.ownerId = ownerId;
    }
}
