package model;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    private List<Product> product;

    public Client() {
        product = new ArrayList<>();
    }

    public Client(String id, String name, int age, String address, String phoneNumber, String email, List<Product> product) {
        super(id, name, age, address, phoneNumber, email);
        this.product = product;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Khách hàng =>" +
                "  id: " + getId() +
                "  Họ tên : " + getName() +
                "  Tuổi : " + getAge() +
                "  Địa chỉ : " + getAddress() +
                "  Số ĐT : " + getPhoneNumber() +
                "  Email : " + getEmail() + "\n" + product;
    }

    @Override
    public double calculateTheAmount() {
        return 0;
    }
}
