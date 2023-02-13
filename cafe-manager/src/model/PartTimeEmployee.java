package model;

import java.io.Serializable;

public class PartTimeEmployee extends Person implements Serializable {
    private double workingTimes;
    private double hourlyMoney;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(String id, String name, int age, String address, String phoneNumber, String email, double workingTimes) {
        super(id, name, age, address, phoneNumber, email);
        this.workingTimes = workingTimes;
        this.hourlyMoney = 5000;
    }

    public double getWorkingTimes() {
        return workingTimes;
    }

    public void setWorkingTimes(double workingTimes) {
        this.workingTimes = workingTimes;
    }

    public double getHourlyMoney() {
        return hourlyMoney;
    }

    public void setHourlyMoney(double hourlyMoney) {
        this.hourlyMoney = hourlyMoney;
    }

    @Override
    public String toString() {
        return "Nhân viên part time: " +
                "  id: " + getId() +
                "  Họ tên : " + getName() +
                "  Tuổi : " + getAge() +
                "  Địa chỉ : " + getAddress() +
                "  Số ĐT : " + getPhoneNumber() +
                "  Email : " + getEmail() +
                "  Thời gian làm việc : " + workingTimes;
    }
    public double realFieldPartTime(int bonus, int punish) {
        return calculateTheAmount() + bonus - punish;
    }
    @Override
    public double calculateTheAmount() {
        return getWorkingTimes()*hourlyMoney;
    }

}
