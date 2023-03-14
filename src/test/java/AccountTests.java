import com.codewithkiks.daos.*;
import com.codewithkiks.models.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class AccountTests {
    private static Dao<Account> accountDao = null;
    private static Dao<Address> addressDao = null;
    private static Dao<Branch> branchDao = null;
    private static Dao<Customer> customerDao = null;
    private static Dao<AccountType> accountTypeDao = null;
    @BeforeAll
    public static void setUp() {
        System.out.println("Setting up Account Tests...");
        accountDao = new AccountDao();
        addressDao = new AddressDao();
        branchDao = new BranchDao();
        customerDao = new CustomerDao();
        accountTypeDao = new AccountTypeDao();
        System.out.println("Setup success.");
    }

    @Test
    public void testAddAccount() {
        System.out.println("Running Test (testAddAccount)...");
        // create address for the customer and bank branch
        Address custAddr = new Address(
                "Sunhoo Ave.",
                "Pamplemousses",
                "Mauritius");
        addressDao.save(custAddr);
        Address bankAddr = new Address(
                "Line Barracks Rd.",
                "Port Louis",
                "Mauritius"
        );
        Address bankAddr2 = new Address(
                "Ramgush Rd.",
                "Rose Hill",
                "Mauritius"
        );
        addressDao.save(bankAddr);
        addressDao.save(bankAddr2);

        // create a bank customer
        Customer customer = new Customer(
                "Kelvin",
                "John",
                "kelv.j405@mcb.mu",
                custAddr,
                new Date()
        );
        customerDao.save(customer);

        // create bank branch
        List<Branch> branches = List.of(
                new Branch(
                        "MCB HQ",
                        bankAddr
                ),
                new Branch(
                        "Rose Hill Branch",
                        bankAddr2
                )
        );
        branches.forEach(branch -> branchDao.save(branch));

        // create bank account types
        List<AccountType> accountTypes = List.of(
                new AccountType(
                        "current",
                        5.9,
                        "Account for businesses"
                ),
                new AccountType(
                        "savings",
                        1.5,
                        "Account for individual and family savings"
                )
        );
        accountTypes.forEach(accountType -> accountTypeDao.save(accountType));

        // create customer's account
        Account account = new Account(
                "00045768906",
                customer,
                new Date(),
                accountTypes.get(0),
                branches.get(0),
                10000
        );
        accountDao.save(account);

        System.out.println("Account created successfully.");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("AccountTests cleaning up...");
        accountDao = null;
        addressDao = null;
        customerDao = null;
        branchDao = null;
        accountTypeDao = null;
    }
}
