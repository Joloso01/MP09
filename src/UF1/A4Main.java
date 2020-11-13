package UF1;

import javax.crypto.SecretKey;
import javax.security.auth.kerberos.EncryptionKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class A4Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Xifrar xifrar = new Xifrar();
        SecretKey clave = xifrar.keygenKeyGeneration(128);
        Path path = Paths.get("/home/dam2a/Escriptori/EjemploA4.txt");
        byte[] textoEnBytes = Files.readAllBytes(path);
        byte[] textoCifrado = xifrar.encryptData(clave,textoEnBytes);
        System.out.println("Texto Cifrado");
        System.out.println(new String(textoCifrado, "UTF8"));
        System.out.println();
        System.out.println("Texto Descifrado");
        byte[] textoDescifrado = xifrar.decryptData(clave,textoCifrado);
        System.out.println(new String(textoDescifrado, "UTF8"));

    }
}