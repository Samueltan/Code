package com.sample.exercise;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

class AppleProduct implements Serializable {

    private static final long serialVersionUID = 12345672L;

    public String headphonePort;
    public String thunderboltPort;

    public String getHeadphonePort() {
        return headphonePort;
    }

    public String getThunderboltPort() {
        return thunderboltPort;
    }
}

public class SerializationUtility {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AppleProduct macBook = new AppleProduct();
        macBook.headphonePort = "headphonePort2020";
        macBook.thunderboltPort = "thunderboltPort2020";

        String serializedObj = serializeObjectToString(macBook);

        System.out.println("Serialized AppleProduct object to string:");
        System.out.println(serializedObj);

        String test = "rO0ABXNyACBjb20uc2FtcGxlLmV4ZXJjaXNlLkFwcGxlUHJvZHVjdAAAAAAAEtaHAgACTAANaGVhZHBob25lUG9ydHQAEkxqYXZhL2xhbmcvU3RyaW5nO0wAD3RodW5kZXJib2x0UG9ydHEAfgABeHB0ABFoZWFkcGhvbmVQb3J0MjAyMHQAE3RodW5kZXJib2x0UG9ydDIwMjA";
        AppleProduct deserializedObj = deserializeObjectFromString(test);
        System.out.println(
                "Headphone port of AppleProduct:"
                        + deserializedObj.getHeadphonePort());
        System.out.println(
                "Thunderbolt port of AppleProduct:"
                        + deserializedObj.getThunderboltPort());
    }

    public static String serializeObjectToString(Serializable o) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(o);
        oos.close();

        return Base64.getEncoder().encodeToString(bos.toByteArray());
    }

    public static AppleProduct deserializeObjectFromString(String s) throws IOException, ClassNotFoundException {
        byte[] ba = Base64.getDecoder().decode(s);
        ByteArrayInputStream bis = new ByteArrayInputStream(ba);
        ObjectInputStream ois = new ObjectInputStream(bis);
        AppleProduct  o = (AppleProduct)ois.readObject();
        ois.close();
        return o;
    }

//    public static
}