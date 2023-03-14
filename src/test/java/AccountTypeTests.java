import com.codewithkiks.daos.AccountTypeDao;
import com.codewithkiks.daos.Dao;
import com.codewithkiks.models.AccountType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountTypeTests {
    private static Dao<AccountType> accountTypeDao;

    @BeforeAll
    public static void setUp() {
        System.out.println("Setting up AccountTypeTests...");
        accountTypeDao = new AccountTypeDao();
        System.out.println("Setup success.");
    }

    @Test
    public void testAddAccountType() {
        System.out.println("Running Test (testAddAccountType)...");
        AccountType accountType = new AccountType(
                "Savings",
                2.5,
                "Account for personal and family savings.");
        accountTypeDao.save(accountType);
        System.out.println("AccountType added successfully.");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("AccountTypeTests cleaning up...");
        accountTypeDao = null;
    }
}
