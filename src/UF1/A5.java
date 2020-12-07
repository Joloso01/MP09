package UF1;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class A5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String keystorePW = "puig2020";

        //1.1._________________________________________________________________
        System.out.println("1.1______________________________________________________");
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
        System.out.println("1.2______________________________________________________");
        KeyStore keyStoreCargado = Xifrar.loadKeyStore("/home/usuari/keystore.ks", keystorePW);

        //1.2.1.1_____________________________________________
        System.out.println("1.2.1.1______________________________________________________");
        System.out.println(keyStoreCargado.getType());

        //1.2.1.2_____________________________________________
        System.out.println("1.2.1.2______________________________________________________");
        int keystoreSize = 0;
        try {
            System.out.println(keystoreSize = keyStoreCargado.size());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
//
//        //1.2.1.3_____________________________________________
        System.out.println("1.2.1.3______________________________________________________");
        Enumeration<String> enumeration = null;
        try {
            enumeration = keyStoreCargado.aliases();
            String alias = enumeration.nextElement();
            for (int i = 0; i < keystoreSize; i++) {
                System.out.println(alias);
                if (enumeration.hasMoreElements()) {
                    alias = enumeration.nextElement();
                }
            }
            System.out.println();
        } catch (KeyStoreException | NoSuchElementException e) {
            e.printStackTrace();
        }

//        1.2.1.4_____________________________________________
        System.out.println("1.2.1.4______________________________________________________");
        try {
            Enumeration<String> enumeration2 = keyStoreCargado.aliases();
            String alias2 = enumeration2.nextElement();
            alias2=enumeration2.nextElement();
            Certificate certificado = keyStoreCargado.getCertificate(alias2);
            System.out.println(certificado.toString());
            System.out.println();
            } catch (KeyStoreException | NoSuchElementException e) {
                e.printStackTrace();
            }


         //1.2.1.5_____________________________________________
        System.out.println("1.2.1.5______________________________________________________");
        try {
            Enumeration<String> enumeration3 = keyStoreCargado.aliases();
            String alias3 = enumeration3.nextElement();
            alias3=enumeration3.nextElement();
            try {
                Certificate certificate = keyStoreCargado.getCertificate(alias3);
                PublicKey publicKey = certificate.getPublicKey();
                String algoritmo = publicKey.getAlgorithm();
                System.out.println(algoritmo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        //ii.2_________________________________________________
        System.out.println("ii.2______________________________________________________");
        SecretKey claveSimetrica = Xifrar.keygenKeyGeneration(256);
        KeyStore.SecretKeyEntry skEntry = new KeyStore.SecretKeyEntry(claveSimetrica);
        char[] passwdEnChar2 = keystorePW.toCharArray();
        KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(passwdEnChar2);
        try {
         keyStoreCargado.setEntry("prueba1", skEntry,protParam);
            FileOutputStream fos = new FileOutputStream("/home/usuari/keystoreJose.jks");
            keyStoreCargado.store(fos,passwdEnChar2);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        //ii.3._____________________________________________________
        System.out.println("ii.3______________________________________________________");
        try {
            System.out.println(Xifrar.getPublicKey("/home/usuari/CertificadoMykey.cer"));
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        //ii.4._____________________________________________________
        System.out.println("ii.4______________________________________________________");

        PublicKey clavePublicaPrueba = Xifrar.getPublicKey(keyStoreCargado,"jordi",keystorePW);
        System.out.println(clavePublicaPrueba);
        System.out.println();
        //ii.5._____________________________________________________
        System.out.println("ii.5______________________________________________________");
        Path path = Paths.get("/home/usuari/tiempo.txt");
        PrivateKey privateKey = (PrivateKey) keyStoreCargado.getKey("a51",keystorePW.toCharArray());
        byte[] fichero= null;
        try {
            fichero = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
            byte[] firma= Xifrar.signData(fichero, privateKey);
        System.out.println(new String(firma,StandardCharsets.UTF_8));


        //ii.6.______________________________________________________
        System.out.println("ii.6______________________________________________________");
        boolean esCorrecta = Xifrar.validateSignature(fichero,firma,Xifrar.getPublicKey("/home/usuari/CertificadoA51.cer"));
        System.out.println("La firma es: " + (esCorrecta ? "Correctes" : "Incorrectes"));


        //2.1__________________________________________________________
        System.out.println("2.2______________________________________________________");
        KeyPair claveReceptor = Xifrar.randomGenerate(1024);
        String mensaje = "Mensaje Prueba Jose";

        byte[][] claveMensajeWrap = Xifrar.encryptWrappedData(mensaje.getBytes(StandardCharsets.UTF_8),claveReceptor.getPublic());
        System.out.println(new String(claveMensajeWrap[0], StandardCharsets.UTF_8));
        System.out.println(new String(claveMensajeWrap[1], StandardCharsets.UTF_8));
        byte[] mensajeUNWRAP = Xifrar.decryptWrappedData(claveMensajeWrap,claveReceptor.getPrivate());
        System.out.println(new String(mensajeUNWRAP, StandardCharsets.UTF_8));


    }
}