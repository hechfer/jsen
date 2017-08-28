package com.mx.jsen.application.encryption;

import javax.crypto.Cipher;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;
import java.util.Base64;

@Component
public class DataEncryptionImpl implements DataEncryption{
    protected final static String alg = "AES";
    protected final static String cI = "AES/CBC/PKCS5Padding";
    protected final static String key = "92AE31A79FEEB2A3";
    protected final static String iv = "0123456789ABCDEF";
    protected final static String ENCRIPTAR = "ENC";
    protected final static String DESENCRIPTAR = "DES";
    protected String encrypt(String key, String iv, String cleartext) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return new String(Base64.getEncoder().encode((encrypted)));
    }

    protected String decrypt(String key, String iv, String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = Base64.getDecoder().decode(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }
    
    protected String enc(String enc) throws Exception{
    	return encrypt(key,iv,enc);
    }
    
    protected String dec(String enc) throws Exception{
    	return decrypt(key,iv,enc);
    }
    
    public String encriptarAndDesencriptar(String dato, String op) throws Exception{
    	if(op.equals(ENCRIPTAR)){
    		return enc(dato);
    	}else if(op.equals(DESENCRIPTAR)){
    		return dec(dato);
    	}
    	return null;
    }
}
