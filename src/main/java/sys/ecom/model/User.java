package sys.ecom.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by My System on 6/14/2017.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String password;
    private String userName;
    private int loginAttempt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;
}
