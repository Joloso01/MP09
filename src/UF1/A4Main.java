package UF1;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A4Main {

    public static void main(String[] args) throws IOException {
        Xifrar xifrar = new Xifrar();

        //1.5.________________________________________________
        System.out.println("1.5___________________________________________________");
        SecretKey clave15 = xifrar.keygenKeyGeneration(128);
        String texto15 = "Texto de prueba Jose";
        byte[] textoEnBytes15 = texto15.getBytes(StandardCharsets.UTF_8);
        byte[] textoCifrado15 = xifrar.encryptData(clave15,textoEnBytes15);
        System.out.println("Texto Cifrado");
        System.out.println(new String(textoCifrado15, StandardCharsets.UTF_8));
        System.out.println();
        System.out.println("Texto Descifrado");
        byte[] textoDescifrado15 = xifrar.decryptData(clave15,textoCifrado15);
        System.out.println(new String(textoDescifrado15, StandardCharsets.UTF_8));
        System.out.println();

        //1.6.__________________________________________________
        System.out.println("1.6___________________________________________________");
        SecretKey clave16 = xifrar.passwordKeyGeneration("EjemploJose",128);
        String texto16 = "Texto de prueba Jose";
        byte[] textoEnBytes16 = texto16.getBytes(StandardCharsets.UTF_8);
        byte[] textoCifrado16 = xifrar.encryptData(clave16,textoEnBytes16);
        System.out.println("Texto Cifrado");
        System.out.println(new String(textoCifrado16, StandardCharsets.UTF_8));
        System.out.println();
        System.out.println("Texto Descifrado");
        byte[] textoDescifrado16 = xifrar.decryptData(clave16,textoCifrado16);
        System.out.println(new String(textoDescifrado16, StandardCharsets.UTF_8));
        System.out.println();

        //1.7___________________________________________________
        System.out.println("1.7___________________________________________________");
        SecretKey clave17=xifrar.keygenKeyGeneration(128);
        System.out.println(clave17.toString());
        System.out.println(clave17.getFormat());
        System.out.println(clave17.getEncoded());
        System.out.println(clave17.getAlgorithm());

        //1.8.__________________________________________________
        System.out.println("1.8___________________________________________________");
        SecretKey clave181 = xifrar.passwordKeyGeneration("EjemploJosese",128);
        try {
            System.out.println("Texto Descifrado");
            byte[] textoDescifrado18 = xifrar.decryptData(clave181,textoCifrado16);
            System.out.println(new String(textoDescifrado18, StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.out.println("Contraseña incorrecta");
        }
        System.out.println();

        //2._______________________________________________________
        System.out.println("2.___________________________________________________");
        String home = System.getProperty("user.home");
        File file = new File(home+"/"+"clausA4.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        Path path = Paths.get(home + "/"+"textamagat");
        byte[] textoEnBytes = Files.readAllBytes(path);
        while (linea != null){
                try {
                    SecretKey clave = xifrar.passwordKeyGeneration(linea,128);
                    byte[] textoDescifrado = xifrar.decryptData(clave,textoEnBytes);
                    System.out.println(new String(textoDescifrado, StandardCharsets.UTF_8));
                    break;
                } catch (Exception e) {
                    System.out.println("La contraseña no es: "+ linea);
                    linea= br.readLine();
                }
        }
        System.out.println("La contraseña es: "+ linea);
    }
}