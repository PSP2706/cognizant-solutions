public class Exercise11 {
    public static void main(String[] args){
        new DITest().runTests();
    }
}

class DITest {
    void runTests() {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        service.findCustomer("C101");
    }
}

interface CustomerRepository {
    void findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void findCustomerById(String id) {
        System.out.println("Customer found with ID: " + id);
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void findCustomer(String id) {
        repository.findCustomerById(id);
    }
}
