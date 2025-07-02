
import com.model.Adress;
import com.model.Person;

public class Customer extends Person {

    private String customerCode;

    public Customer(String name, String cpf, String phone, Adress adress, String customerCode) {
        super(name, cpf, phone, adress);
        this.customerCode = customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
    
    @Override
    public void displayData(){
        super.displayData();
        System.out.println("Customer Code: " + customerCode);
    }
}
