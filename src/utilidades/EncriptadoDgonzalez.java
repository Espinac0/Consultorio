/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author David
 */
public class EncriptadoDgonzalez {
    private static final String MILLAVE = "vJMnURwFuojTiaJT";

    public static String encriptar(String textoEncriptar) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
       Key millaveEnBytes = new SecretKeySpec(MILLAVE.getBytes(),"AES");


    Cipher encriptador = Cipher.getInstance("AES");
    encriptador.init(Cipher.ENCRYPT_MODE, millaveEnBytes);

    byte[] bytesEncriptados = encriptador.doFinal(textoEncriptar.getBytes());

    return Base64.encodeBase64String(bytesEncriptados);
    }

    public static String desencriptar(String textoDesencriptar) throws InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException  {

     byte[] bytesEncriptados = Base64.decodeBase64(textoDesencriptar);
     Key millaveEnBytes = new SecretKeySpec(MILLAVE.getBytes(), "AES");

     Cipher encriptador = Cipher.getInstance("AES");
     encriptador.init(Cipher.DECRYPT_MODE, millaveEnBytes);

     String desencriptado = new String(encriptador.doFinal(bytesEncriptados));

     return desencriptado;
    }
}
