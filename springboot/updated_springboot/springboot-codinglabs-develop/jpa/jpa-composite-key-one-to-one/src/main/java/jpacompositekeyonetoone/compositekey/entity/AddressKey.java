package jpacompositekeyonetoone.compositekey.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AddressKey implements Serializable {
 
    private Long xId;
    private Long yId;
     
    public AddressKey() {}
     
    public AddressKey(Long xId, Long yId) {
        super();
        this.xId = xId;
        this.yId = yId;
    }
 
    public Long getxId() {
        return xId;
    }
 
    public void setxId(Long xId) {
        this.xId = xId;
    }
 
    public Long getyId() {
        return yId;
    }
 
    public void setyId(Long yId) {
        this.yId = yId;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((xId == null) ? 0 : xId.hashCode());
        result = prime * result + ((yId == null) ? 0 : yId.hashCode());
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
        AddressKey other = (AddressKey) obj;
        if (xId == null) {
            if (other.xId != null)
                return false;
        } else if (!xId.equals(other.xId))
            return false;
        if (yId == null) {
            if (other.yId != null)
                return false;
        } else if (!yId.equals(other.yId))
            return false;
        return true;
    }
}
