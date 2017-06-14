package sys.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by My System on 6/14/2017.
 */
@Entity
public class InvoiceProduct {
    @Id
    @GeneratedValue
    private long id;
    private long qty;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @ManyToOne
    @JoinColumn(name = "invoiceId")
    @JsonIgnore
    private Invoice invoice;
    @ManyToMany
    @JoinTable(name = "invoiceProduct_product", joinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "invoceProductId", referencedColumnName = "id"))
    @JsonIgnore
    private List<Product> products;
}
