import java.util.UUID;

public class UUIDExample {

    public static void main(String[] args) {

        //randomly generates a UUID
        UUID uuid = UUID.randomUUID();
        System.out.println("Randomly Generated UUID: "+uuid);

        //converts the randomly generated UUID into String
        String uuidAsString = uuid.toString();
        System.out.println("UUID as String: "+uuidAsString.replace("-",""));

        //generates a UUID from the String
        UUID sameUuid = UUID.fromString(uuidAsString);
        System.out.println("UUID from String: "+sameUuid);

        //compares UUID generated from the string with the randomly generated UUID
        System.out.println(sameUuid.equals(uuid));



    }



}
