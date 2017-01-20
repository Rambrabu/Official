package vehicle.make;

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
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;

public class BSROVehicleMakeFunctionHandler implements RequestHandler<Object, Object> {

    @Override
    public Object handleRequest(Object input, Context context) {
    	context.getLogger().log("Input: " + input);
    	/*if (input.toString().equals("{}") || input.toString().equals("")) {
			context.getLogger().log("input is empty: abort");
			return "{\"status\":\"error\",\"message\":\"input at lambda function is empty\"}";
		}*/
    	
        AWSCredentials creds = new BasicAWSCredentials("AKIAIWQOW2UUYPMOG2VQ","T3NHKV0FayMEeHHpwixdguEE7RIPyZywHdESE1ps");
        AmazonDynamoDBClient dyndbclient = new AmazonDynamoDBClient(creds);
        DynamoDBMapper mapper = new DynamoDBMapper(dyndbclient);
        
        HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":n", new AttributeValue().withN("2017"));

        DynamoDBQueryExpression<Vehicle> queryExpression = new DynamoDBQueryExpression<Vehicle>()
        	.withIndexName("MakeSearch-index")
            .withConsistentRead(false)
            .withKeyConditionExpression("ModelYear = :n")
            .withExpressionAttributeValues(eav);

        List<Vehicle> itemList = mapper.query(Vehicle.class, queryExpression);
        
        return input;
    }
}
