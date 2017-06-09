package sys.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by My System on 6/7/2017.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String displayName;
    private String description;
    private String price;
    private String tagLine;
    private String btnText;
    private String priceTagImageUrl;
    private String availability;
    @Column(name = "productCondition")
    private String condition;
    private boolean isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date manufactureDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImages;
}
