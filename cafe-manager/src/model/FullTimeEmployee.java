package model;

import java.io.Serializable;

public class FullTimeEmployee extends Person implements Serializable {
    private double hardSalary;
    private double workingDays;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String id, String name, int age, String address, String phoneNumber, String email, double hardSalary, double workingDays) {
        super(id, name, age, address, phoneNumber, email);
        this.hardSalary = hardSalary;
        this.workingDays = workingDays;
    }

    public double getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(double hardSalary) {
        this.hardSalary = hardSalary;
    }

    public double getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(double workingDays) {
        this.workingDays = workingDays;
    }

    @Override
    public String toString() {
        return "Nhân viên full time: " +
                "  id: " + getId() +
                "  Họ tên : " + getName() +
                "  Tuổi : " + getAge() +
                "  Địa chỉ : " + getAddress() +
                "  Số ĐT : " + getPhoneNumber() +
                "  Email : " + getEmail() +
                "  Lương cứng : " + hardSalary +
                "  Ngày công : " + workingDays;
    }

    public double realFieldFullTime(int bonus, int punish) {
        return calculateTheAmount() + bonus - punish;
    }

    @Override
    public double calculateTheAmount() {
        return (getHardSalary() * getWorkingDays());
    }

}
