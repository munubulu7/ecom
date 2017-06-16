package sys.ecom.model;

import java.io.Serializable;

/**
 * Created by My System on 6/7/2017.
 */
public class ProductPropertiesIdClass implements Serializable {
    private Long propertiesId;
    private Long productId;




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((propertiesId == null) ? 0 : propertiesId.hashCode());
        result = (int) (prime * result + productId);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductPropertiesIdClass other = (ProductPropertiesIdClass) obj;
        if (propertiesId == null) {
            if (other.propertiesId != null)
                return false;
        } else if (!propertiesId.equals(other.propertiesId))
            return false;
        if (productId != other.productId)
            return false;
        return true;
    }
}
