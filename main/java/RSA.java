import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class RSA {

    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    RSA(int N) {
        BigInteger p = BigInteger.probablePrime(N / 2, random);
        BigInteger q = BigInteger.probablePrime(N / 2, random);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));

        modulus = p.multiply(q);
        publicKey = new BigInteger("65537");
        privateKey = publicKey.modInverse(phi);
    }

    public static BigInteger stringToInt(String message) {
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        byte[] paddedBytes = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, paddedBytes, 1, bytes.length);
        return new BigInteger(paddedBytes);
    }

    public static String intToString(BigInteger message) {
        byte[] bytes = message.toByteArray();

        if (bytes[0] == 0) {
            byte[] trimmed = new byte[bytes.length - 1];
            System.arraycopy(bytes, 1, trimmed, 0, trimmed.length);
            bytes = trimmed;
        }

        return new String(bytes, StandardCharsets.UTF_8);
    }



    public BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privateKey, modulus);
    }

    public String toString() {
        String s = "";
        s += "public  = " + publicKey + "\n";
        s += "private = " + privateKey + "\n";
        s += "modulus = " + modulus;
        return s;
    }
}
