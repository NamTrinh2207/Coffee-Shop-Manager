package controller.storageController;

import model.modelClass.Client;
import model.modelClass.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteToFile implements ReadWrite{
    //Clients-------------------------------------------------------------------------
    private ReadWriteToFile() {
    }

    private static ReadWriteToFile instance;
    public static ReadWriteToFile getInstance() {
        if (instance == null) {
            instance = new ReadWriteToFile();
        }
        return instance;
    }
    @Override
    public void writeToFileClient(List<Client> clients) {
        File file = new File("client.dat");
        FileOutputStream stream;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedOutputStream bufSt = new BufferedOutputStream(stream);
            ObjectOutputStream oos = new ObjectOutputStream(bufSt);
            oos.writeObject(clients);
            oos.close();
        } catch (IOException e) {
            System.err.println("Không ghi được file");
        }
        try {
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Client> readDataFileClient() {
        File file = new File("client.dat");
        List<Client> clients = new ArrayList<>();
        FileInputStream stream;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedInputStream bufInSt = new BufferedInputStream(stream);
            ObjectInputStream ois = new ObjectInputStream(bufInSt);
            clients = (List<Client>) ois.readObject();
            ois.close();
            stream.close();
        } catch (Exception ex) {
            System.err.println("Không đọc được dữ liệu");
        }
        return clients;
    }

    //Employees-------------------------------------------------------------------------------------------------
    @Override
    public void writeToFileEmployees(List<Person> employees) {
        File file = new File("employee.dat");
        FileOutputStream stream;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedOutputStream bufSt = new BufferedOutputStream(stream);
            ObjectOutputStream oos = new ObjectOutputStream(bufSt);
            oos.writeObject(employees);
            oos.close();
        } catch (IOException e) {
            System.err.println("Không ghi được file");
        }
        try {
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Person> readDataFileEmployees() {
        File file = new File("employee.dat");
        List<Person> employees = new ArrayList<>();
        FileInputStream stream;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedInputStream bufInSt = new BufferedInputStream(stream);
            ObjectInputStream ois = new ObjectInputStream(bufInSt);
            employees = (List<Person>) ois.readObject();
            ois.close();
            stream.close();
        } catch (Exception ex) {
            System.err.println("Không đọc được dữ liệu");
        }
        return employees;
    }
}
