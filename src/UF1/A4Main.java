package UF1;

import javax.crypto.SecretKey;
import javax.security.auth.kerberos.EncryptionKey;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class A4Main {

    public static void main(String[] args) throws IOException {
        Xifrar xifrar = new Xifrar();
        File file = new File("C:/Users/Jose/Desktop/clausA4.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        Path path = Paths.get("C:/Users/Jose/Desktop/textamagat");
        byte[] textoEnBytes = Files.readAllBytes(path);
        while (linea != null){
            try {
                SecretKey clave = xifrar.passwordKeyGeneration(linea,256);
                byte[] textoDescifrado = xifrar.decryptData(clave,textoEnBytes);
                System.out.println(new String(textoDescifrado, "UTF8"));
                break;
            } catch (Exception e) {
                System.out.println("La contraseña no es: "+ linea);
                linea= br.readLine();
            }
        }

        System.out.println("La contraseña es: "+ linea);
    }
}