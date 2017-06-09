package sys.ecom.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by My System on 6/7/2017.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String displayName;
    private String description;
    private String tergetLink;
    private String targetId;
    private boolean isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}
