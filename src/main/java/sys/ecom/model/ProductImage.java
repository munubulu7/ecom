package sys.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by My System on 6/7/2017.
 */
@Entity
public class ProductImage {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String imageUrl;
    private boolean isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @ManyToOne
    @JoinColumn(name = "productId")
    @JsonIgnore
    private Product product;
}
