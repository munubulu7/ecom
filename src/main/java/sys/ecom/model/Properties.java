package sys.ecom.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by My System on 6/7/2017.
 */
@Entity
public class Properties {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String displayName;
    private boolean isActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "properties", cascade = CascadeType.ALL)
    private List<ProductProperties> productProperties;
}
