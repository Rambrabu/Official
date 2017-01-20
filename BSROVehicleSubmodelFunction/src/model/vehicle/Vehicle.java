package model.vehicle;

import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="VehicleSearch")
public class Vehicle {
	
	private Integer acesVehicleId;
	
	private Integer year;
	private Integer makeId;
	private String makeName;
	private String friendlyMakeName;
	
	private String modelSearch;
	private Integer modelId;
	private String modelName;
	private String friendlyModelName;
	
	private String submodelSearch;
	private Integer submodelId;
	private String submodelName;
	private String friendlySubmodelName;
	
	private boolean tpmsInd;
	
	@DynamoDBHashKey(attributeName="AcesVehicleId")  
	public Integer getAcesVehicleId() {
		return acesVehicleId;
	}
	public void setAcesVehicleId(Integer acesVehicleId) {
		this.acesVehicleId = acesVehicleId;
	}
	
	@DynamoDBIndexHashKey(globalSecondaryIndexName = "MakeSearch-index", attributeName="ModelYear") 
    public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@DynamoDBIndexRangeKey(globalSecondaryIndexName = "MakeSearch-index", attributeName="MakeId")
	public Integer getMakeId() {
		return makeId;
	}
	public void setMakeId(Integer makeId) {
		this.makeId = makeId;
	}
	
	@DynamoDBAttribute(attributeName="MakeName") 
	public String getMakeName() {
		return makeName;
	}
	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}
	
	@DynamoDBAttribute(attributeName="FriendlyMakeName") 
	public String getFriendlyMakeName() {
		return friendlyMakeName;
	}
	public void setFriendlyMakeName(String friendlyMakeName) {
		this.friendlyMakeName = friendlyMakeName;
	}
	
	@DynamoDBIndexHashKey(globalSecondaryIndexName = "ModelSearch-index", attributeName="ModelSearch")
	public String getModelSearch() {
		return modelSearch;
	}
	public void setModelSearch(String modelSearch) {
		this.modelSearch = modelSearch;
	}
	
	@DynamoDBIndexRangeKey(globalSecondaryIndexName = "ModelSearch-index", attributeName="ModelId")
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	
	@DynamoDBAttribute(attributeName="ModelName")
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	@DynamoDBAttribute(attributeName="FriendlyModelName")
	public String getFriendlyModelName() {
		return friendlyModelName;
	}
	public void setFriendlyModelName(String friendlyModelName) {
		this.friendlyModelName = friendlyModelName;
	}
	
	@DynamoDBIndexHashKey(globalSecondaryIndexName = "SubmodelSearch-index", attributeName="SubmodelSearch")
	public String getSubmodelSearch() {
		return submodelSearch;
	}
	public void setSubmodelSearch(String submodelSearch) {
		this.submodelSearch = submodelSearch;
	}
	
	@DynamoDBIndexRangeKey(globalSecondaryIndexName = "SubmodelSearch-index", attributeName="SubmodelId")
	public Integer getSubmodelId() {
		return submodelId;
	}
	public void setSubmodelId(Integer submodelId) {
		this.submodelId = submodelId;
	}
	
	@DynamoDBAttribute(attributeName="SubmodelName")
	public String getSubmodelName() {
		return submodelName;
	}
	public void setSubmodelName(String submodelName) {
		this.submodelName = submodelName;
	}
	
	@DynamoDBAttribute(attributeName="FriendlySubmodelName")
	public String getFriendlySubmodelName() {
		return friendlySubmodelName;
	}
	public void setFriendlySubmodelName(String friendlySubmodelName) {
		this.friendlySubmodelName = friendlySubmodelName;
	}
	
	@DynamoDBAttribute(attributeName="TpmsInd")
	public boolean isTpmsInd() {
		return tpmsInd;
	}
	public void setTpmsInd(boolean tpmsInd) {
		this.tpmsInd = tpmsInd;
	}
    
}
