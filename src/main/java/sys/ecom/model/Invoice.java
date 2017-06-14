package sys.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by My System on 6/14/2017.
 */
@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceProduct> invoiceProducts;
    @ManyToOne
    @JoinColumn(name = "addressId")
    @JsonIgnore
    private Address billingAddress;
}
