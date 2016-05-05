package wky.java.base.serialization.bean;

import java.io.Serializable;

/**
 * copy from D:\fusion\fatools\techarch\components\AdfbcTest\AdrLookup\src\oracle\apps\ta\adrUtils\Lba.java
 * 
 * JavaBean conventions: https://en.wikipedia.org/wiki/JavaBeans#JavaBean_conventions
 * Have to be java bean, so that XMLEncoder could serialize it.
 * 
 * */
public class Lba implements Serializable{

	private static final long serialVersionUID = 1L;
// instance variables need to follow the javabean pattern and have corresponding 
// get'ter method since using XMLEncoder / XMLDecoder
// Don't need set'ters because using the constructor to populate the variables..

    private String lbaShortName;
    private String lbaPackageName;
    private String productShortCode;
    private String parentLbaShortName;
    private String lbaFullName;
    private String familyADRShortCode;
    private String lbaStatus;
    private String lbaFusionRelease;
    private String lbaShippingRelease;
    private int lbaType;
    
    // transient instance variables are ignored by XMLEncoder, and re-default when the object is decoded
    // Setting the leaf node involves a scan of the LbaList, LbaList.setLeafNodes() needs to be called
    // to set this property, which for performance reasons is not done automatically.
    transient boolean leafNode = true;
    
    /**
     * java bean: public constructor with no arguments .
     * */
    public Lba(){};
    
    public Lba(String shortName, String packageName, String prodShortCode,
            String name, String parentShortCode, String familyShortCode,
            String status, String fusionRelease, String shippingRelease, int type) {
        super();
        
        //if (prodShortCode == null) 
        //    System.out.println("productShortCode is null for "+prodShortCode);
        //if (shortName == null) 
        //    System.out.println("lbaShortName is null for "+shortName);
        
        lbaShortName = shortName.trim();
        if (packageName!=null) {
            lbaPackageName = packageName.trim();
        }
        
        productShortCode = prodShortCode.trim();
        
        if (name!=null) {
            lbaFullName = name.trim();
        }
        
        if (parentShortCode!=null) {
            parentLbaShortName = parentShortCode.trim();   
        }
        
        familyADRShortCode = familyShortCode.trim();
        
        lbaStatus = status;
        lbaFusionRelease = fusionRelease;
        lbaShippingRelease = shippingRelease;
        lbaType=type;

    }

	public String getLbaShortName() {
		return lbaShortName;
	}

	public void setLbaShortName(String lbaShortName) {
		this.lbaShortName = lbaShortName;
	}

	public String getLbaPackageName() {
		return lbaPackageName;
	}

	public void setLbaPackageName(String lbaPackageName) {
		this.lbaPackageName = lbaPackageName;
	}

	public String getProductShortCode() {
		return productShortCode;
	}

	public void setProductShortCode(String productShortCode) {
		this.productShortCode = productShortCode;
	}

	public String getParentLbaShortName() {
		return parentLbaShortName;
	}

	public void setParentLbaShortName(String parentLbaShortName) {
		this.parentLbaShortName = parentLbaShortName;
	}

	public String getLbaFullName() {
		return lbaFullName;
	}

	public void setLbaFullName(String lbaFullName) {
		this.lbaFullName = lbaFullName;
	}

	public String getFamilyADRShortCode() {
		return familyADRShortCode;
	}

	public void setFamilyADRShortCode(String familyADRShortCode) {
		this.familyADRShortCode = familyADRShortCode;
	}

	public String getLbaStatus() {
		return lbaStatus;
	}

	public void setLbaStatus(String lbaStatus) {
		this.lbaStatus = lbaStatus;
	}

	public String getLbaFusionRelease() {
		return lbaFusionRelease;
	}

	public void setLbaFusionRelease(String lbaFusionRelease) {
		this.lbaFusionRelease = lbaFusionRelease;
	}

	public String getLbaShippingRelease() {
		return lbaShippingRelease;
	}

	public void setLbaShippingRelease(String lbaShippingRelease) {
		this.lbaShippingRelease = lbaShippingRelease;
	}

	public int getLbaType() {
		return lbaType;
	}

	public void setLbaType(int lbaType) {
		this.lbaType = lbaType;
	}

	public boolean isLeafNode() {
		return leafNode;
	}

	public void setLeafNode(boolean leafNode) {
		this.leafNode = leafNode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Lba [lbaShortName=" + lbaShortName + ", lbaPackageName=" + lbaPackageName + ", productShortCode="
				+ productShortCode + ", parentLbaShortName=" + parentLbaShortName + ", lbaFullName=" + lbaFullName
				+ ", familyADRShortCode=" + familyADRShortCode + ", lbaStatus=" + lbaStatus + ", lbaFusionRelease="
				+ lbaFusionRelease + ", lbaShippingRelease=" + lbaShippingRelease + ", lbaType=" + lbaType + "]";
	}
    
}
