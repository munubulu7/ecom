package sys.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by My System on 6/7/2017.
 */
@Entity
@IdClass(ProductPropertiesIdClass.class)
public class ProductProperties {
    @Id
    private long propertiesId;
    @Id
    private long productId;
    private String name;
    private String displayName;
    @ManyToOne
    @JoinColumn(name = "prodId")
    @JsonIgnore
    private Product product;
    @ManyToOne
    @JoinColumn(name = "propId")
    @JsonIgnore
    private Properties properties;
}
