import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Input secret message: ");
        String message = scn.nextLine();

        RSA rsa = new RSA(1024);

        BigInteger paddedMessage = RSA.stringToInt(message);
        BigInteger encrypt = rsa.encrypt(paddedMessage);
        BigInteger decrypt = rsa.decrypt(encrypt);

        String decryptedMessage = RSA.intToString(decrypt);
        System.out.println("message         = " + message);
        System.out.println("padded message  = " + paddedMessage);
        System.out.println("encrypted       = " + encrypt);
        System.out.println("decrypted       = " + decrypt);
        System.out.println("decrypted (str) = " + decryptedMessage);
    }

}
