package UF1;

import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.security.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

public class A5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keystorePW = "Torrent.11";
        //1.1._________________________________________________________________
        System.out.println("1.1._________________________________");
        KeyPair clave = Xifrar.randomGenerate(1024);
        System.out.println("Introduzca el texto a cifrar:");
        String texto = sc.nextLine();
        byte[] textoEnByte = texto.getBytes();
        System.out.println("Texto Cifrado");
        byte[] textoCifrado = Xifrar.encryptData(textoEnByte, clave.getPublic());
        System.out.println(new String(textoCifrado));
        System.out.println(clave.getPublic().toString());
        System.out.println();
        System.out.println("Texto Descifrado");
        byte[] textoDescifrado = Xifrar.decryptData(textoCifrado, clave.getPrivate());
        System.out.println(new String(textoDescifrado));
        System.out.println(clave.getPrivate().toString());
        System.out.println();

        //1.2____________________________________________________________
        System.out.println("1.2________________________________________________________");
        String home = System.getProperty("user.home");
        KeyStore keyStoreCargado = null;

        try {
            keyStoreCargado = Xifrar.loadKeyStore(home + "/keystore.ks", keystorePW);
        } catch (Exception e) {
            System.out.println("Error al cargar el Keystore");
        }

        //2.1.1_____________________________________________
        keyStoreCargado.getType();

        //2.1.2_____________________________________________
        int keystoreSize = 0;
        try {
            keystoreSize = keyStoreCargado.size();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        //2.1.3_____________________________________________
        Enumeration<String> listAlias = null;
        try {
            listAlias = keyStoreCargado.aliases();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        System.out.println(listAlias);

        //2.1.4_____________________________________________
        for (int i = 0; i < keystoreSize; i++) {
            try {
                keyStoreCargado.getCertificate(String.valueOf(listAlias));
            } catch (KeyStoreException e) {
                e.printStackTrace();
            }
        }

        //2.1.5_____________________________________________
        char[] passwdEnChar = keystorePW.toCharArray();
        for (int i = 0; i < keystoreSize; i++) {
            try {
                Key key = keyStoreCargado.getKey(String.valueOf(listAlias),passwdEnChar);
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnrecoverableKeyException e) {
                e.printStackTrace();
            }
        }


        //2.2_________________________________________________
        SecretKey claveSimetrica = Xifrar.keygenKeyGeneration(256);
        KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(passwdEnChar);
        try {
         keyStoreCargado.setEntry("prueba1", (KeyStore.Entry) claveSimetrica,protParam);
            FileOutputStream fos = new FileOutputStream(home+"/Keystore.ks");
            keyStoreCargado.store(fos,passwdEnChar);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
