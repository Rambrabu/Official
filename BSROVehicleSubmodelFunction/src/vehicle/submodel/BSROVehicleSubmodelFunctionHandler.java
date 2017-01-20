package vehicle.submodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.vehicle.Vehicle;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class BSROVehicleSubmodelFunctionHandler implements RequestHandler<Object, Object> {

    @Override
    public Object handleRequest(Object input, Context context) {
    	context.getLogger().log("Input: " + input);
        AWSCredentials creds = new BasicAWSCredentials("AKIAIWQOW2UUYPMOG2VQ","T3NHKV0FayMEeHHpwixdguEE7RIPyZywHdESE1ps");
        AmazonDynamoDBClient dyndbclient = new AmazonDynamoDBClient(creds);
        DynamoDBMapper mapper = new DynamoDBMapper(dyndbclient);
        
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue> ();
        eav.put(":s", new AttributeValue().withS("2017-73-986"));
        
        DynamoDBQueryExpression<Vehicle> queryExpression = new DynamoDBQueryExpression<Vehicle>()
        		.withIndexName("SubmodelSearch-index")
		        .withConsistentRead(false)
		        .withKeyConditionExpression("SubmodelSearch = :s")
		        .withExpressionAttributeValues(eav);

        List<Vehicle> itemList = mapper.query(Vehicle.class, queryExpression);
      
        return itemList;
    }

}
