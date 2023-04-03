package com.nagarro.constants;

public class Constants {
	public static final String PARENTQUERY = "SELECT p From Product p WHERE ";
	public static final String PRICERANGEQUERY = "p.price between :min and :max";
	public static final String SEARCHBYNAMEBRANDPRODUCTCODE = "p.name LIKE CONCAT('%',:name,'%') or p.brand LIKE CONCAT('%',:brand,'%') or p.productCode=:productCode";
	public static final String SEARCHBYNAMEBRAND = "p.name LIKE CONCAT('%',:name,'%')and p.brand LIKE CONCAT('%',:brand,'%') ";
	public static final String USERALREADYEXIST = "%s already exist with emailid  :%s";
	public static final String RESOURCENOTFOUND = "%s not found with %s:%s";
}
