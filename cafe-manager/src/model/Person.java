package model;

import java.io.Serializable;

public abstract class Person implements CalculateTheAmount, Serializable, Comparable<Person> {
    private String id;
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String id, String name, int age, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        String name = this.getName().trim();
        if (name.indexOf(" ") >= 0) {
            int index = name.lastIndexOf(" ");
            return name.substring(index + 1);
        } else {
            return name;
        }
    }

    @Override
    public int compareTo(Person o) {
        String thisName = this.getFullName();
        String nameO = o.getFullName();
        return thisName.compareTo(nameO);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
