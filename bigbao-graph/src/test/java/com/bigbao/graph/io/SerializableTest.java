package com.bigbao.graph.io;

import java.io.*;

public class SerializableTest {

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(11);
        p.setName("大胖");
        ObjectOutputStream ous = null;
        ObjectInputStream ois = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ous = new ObjectOutputStream(bos);
            ous.writeObject(p);
            System.out.println(bos.toByteArray());
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Person o = (Person)ois.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ous){
                try {
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
