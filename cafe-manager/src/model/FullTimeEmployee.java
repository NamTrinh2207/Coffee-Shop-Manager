package model;

import java.io.Serializable;

public class FullTimeEmployee extends Person implements RealFieldEmployee, Serializable {
    private String email;
    private double hardSalary;
    private double workingDays;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String id, String name, int age, String address, String phoneNumber, String email, double hardSalary) {
        super(id, name, age, address, phoneNumber);
        this.email = email;
        this.hardSalary = hardSalary;
        this.workingDays = 26;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nhân viên full time: " +
                "  id: " + getId() +
                "  Họ tên : " + getName() +
                "  Tuổi : " + getAge() +
                "  Địa chỉ : " + getAddress() +
                "  Số ĐT : " + getPhoneNumber() +
                "  Email : " + email +
                "  Lương cứng : " + hardSalary;
    }

    @Override
    public double calculateTheAmount() {
        return (getHardSalary() * getWorkingDays());
    }

    @Override
    public double realFieldEmployee(double unpaidLeave, int late) {
        return calculateTheAmount() - (unpaidLeave * getHardSalary()) - (late * 10000);
    }
}
