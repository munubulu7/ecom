package sys.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by My System on 6/14/2017.
 */
@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private String village;
    private String city;
    private String polishStation;
    private String postOffice;
    private String district;
    private String state;
    private String areaPincode;
    private String landmark;
    private boolean isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "billingAddress", cascade = CascadeType.ALL)
    private List<Invoice> invoices;
    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
}
