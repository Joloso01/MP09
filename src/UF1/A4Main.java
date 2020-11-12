package UF1;

import javax.crypto.SecretKey;
import javax.security.auth.kerberos.EncryptionKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class A4Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Xifrar xifrar = new Xifrar();
        File file = new File("/home/dam2a/Escriptori/clausA4.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea=bufferedReader.readLine();
        Path pathLinea = Paths.get(linea);
        byte[] lineaEnBytes = Files.readAllBytes(pathLinea);
        Path path = Paths.get("/home/dam2a/Escriptori/textamagat");
        byte[] textoenbytes = Files.readAllBytes(path);
        String textoCifrado=new String(textoenbytes);


        while (linea != null){
            if (linea.equals("")){
                linea=bufferedReader.readLine();
            }else {
                System.out.println("lectura: "+linea);
                linea=bufferedReader.readLine();

            }
        }




    }
}