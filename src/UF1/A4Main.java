package UF1;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;

public class A4Main {

    public static void main(String[] args) throws IOException {
        Xifrar xifrar = new Xifrar();

        File file = new File("/home/dam2a/Escriptori/clausA4.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea=bufferedReader.readLine();

        Path path = Paths.get("/home/dam2a/Escriptori/clausA4.txt");
        byte[] textoenbytes = Files.readAllBytes(path);


        while (linea != null){
            if (linea.equals("")){
                linea=bufferedReader.readLine();
            }else {
                SecretKey secretKey1 = xifrar.keygenKeyGeneration(128);
                System.out.println("lectura: "+linea);
                //xifrar.encryptData(linea.getBytes("UTF8"))
                linea=bufferedReader.readLine();

            }
        }




    }
}