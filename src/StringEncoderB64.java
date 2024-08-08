import java.util.Base64;

public class StringEncoderB64 {

    //Encode string function, using Base64 lib
    public static String encode64(String encodeString) {
        if (!encodeString.isBlank()) {
            return Base64.getEncoder().encodeToString(encodeString.strip().getBytes());
        } else {
            return null;
        }
    }

    //Decode string function, using Base64 lib
    public static String decode64(String encodeString) {
        if (!encodeString.isBlank()) {
            byte[] decodeB = Base64.getDecoder().decode(encodeString.strip());
            return new String(decodeB);
        } else {
            return null;
        }
    }
}
