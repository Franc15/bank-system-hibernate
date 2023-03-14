import com.codewithkiks.daos.AddressDao;
import com.codewithkiks.daos.BranchDao;
import com.codewithkiks.daos.Dao;
import com.codewithkiks.models.Address;
import com.codewithkiks.models.Branch;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BranchTests {
    private static Dao<Branch> branchDao = null;
    private static Dao<Address> addressDao = null;

    @BeforeAll
    public static void setUp() {
        System.out.println("Setting up Branch Tests...");
        branchDao = new BranchDao();
        addressDao = new AddressDao();
        System.out.println("Setup success.");
    }

    @Test
    public void testAddBranch() {
        System.out.println("Running Test (testAddBranch)...");
        Address address = new Address("Ramgush St.", "Rose Hill", "Mauritius");
        addressDao.save(address);
        Branch branch = new Branch("Roses", address);
        branchDao.save(branch);
        System.out.println("Branch created successfully.");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Branch tests cleaning up...");
        branchDao = null;
        addressDao = null;
    }
}
