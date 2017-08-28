package com.mx.jsen.application.encryption;

public class test {
	public static void main(String args[]) throws Exception{
		String pass = "prueba@prueba.com";
		String user = "prueba1@prueba.com";
		DataEncryptionImpl encript = new DataEncryptionImpl();
		System.out.println("pass : "+encript.encriptarAndDesencriptar(pass, "ENC"));
		System.out.println("user : "+encript.encriptarAndDesencriptar(user, "ENC"));
		
		System.out.println("pass : "+encript.encriptarAndDesencriptar(encript.encriptarAndDesencriptar(pass, "ENC"), "DES"));
		System.out.println("user : "+encript.encriptarAndDesencriptar(encript.encriptarAndDesencriptar(user, "ENC"), "DES"));
		
	}
}
