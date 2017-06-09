package sys.ecom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by My System on 6/7/2017.
 */
@Entity
public class ProductProperties {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String displayName;
}
