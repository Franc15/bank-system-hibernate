import com.codewithkiks.daos.AddressDao;
import com.codewithkiks.daos.CustomerDao;
import com.codewithkiks.daos.Dao;
import com.codewithkiks.models.Address;
import com.codewithkiks.models.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CustomerTests {
    private static Dao<Customer> customerDao = null;
    private static Dao<Address> addressDao = null;

    @BeforeAll
    public static void setUp() {
        System.out.println("Setting up Tests...");
        customerDao = new CustomerDao();
        addressDao = new AddressDao();
    }

    @Test
    public void testAddCustomer() {
        System.out.println("Running add customer test...");
        Address address = new Address("123 King Rd.", "Nairobi", "Kenya");
        addressDao.save(address);
        Customer customer = new Customer(
                "Isabelle",
                "Wood",
                "isabel05@acensi.com",
                address,
                new Date());
        customerDao.save(customer);
        System.out.println("Customer added successfully.");
    }

    @AfterAll
    public static void tearDown() {
        customerDao = null;
    }
}
