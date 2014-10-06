import java.util.*;

class GenerateUniqueIP {

    public static String getUniqueEmail() {
        Long uuid = UUID.randomUUID().getMostSignificantBits();
        String email = uuid.toString().substring(1, uuid.toString().length());
        return email + "@emc.com";
    }

    public static String getUniqueIP() {
        Random r = new Random();
        return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256); 
    }

    public static void main(String[] args) {
    System.out.print("Unique: " + getUniqueEmail());
    System.out.print("UniqueIP: " + getUniqueIP());
    }
        
}
