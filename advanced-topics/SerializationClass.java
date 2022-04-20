package AdvancedTopics;

import java.io.*;

public class SerializationClass {

    public static void main(String[] args) {

        serializedObject();
        deserializeObject("C:\\Users\\sesa649044\\Downloads\\serializedObject.txt");

    }

    private static void serializedObject() {
        Student student = new Student("Mario", "La Vaguada", 30);

        String filename = "C:\\Users\\sesa649044\\Downloads\\serializedObject.txt";
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;

        try {
            fileOut = new FileOutputStream(filename);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(student);

            objOut.close();
            fileOut.close();

            System.out.println("SERIALIZED");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void deserializeObject(String filename){

        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;

        try {
            fileIn = new FileInputStream(filename);
            objIn = new ObjectInputStream(fileIn);

            Student object = (Student) objIn.readObject();

            System.out.println("DESERIALIZE" + object);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;
    private final String address;
    private final int age;

    public Student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
}
