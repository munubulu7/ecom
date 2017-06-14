package sys.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by My System on 6/7/2017.
 */
@Entity
public class SubCategory {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String displayName;
    private String description;
    private String targetLink;
    private String targetId;
    private boolean isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Category category;
}
