package sys.ecom.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by My System on 6/7/2017.
 */
@Entity
public class SubCategory {
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
}
