package object;

public class ObjectPreparator {
	
	public static ClaimApprovalRequest getRequestObject() {
		ObjectFactory factory = new ObjectFactory();
		ClaimApprovalRequest approvalRequest = factory.createClaimApprovalRequest();
		Customer person = factory.createCustomer();
		person.setFirstname("Kate");
		person.setLastname("Middletone");
		person.setId("QUEEN01");
		approvalRequest.setPerson(person);
		approvalRequest.setAmount(20000);
		approvalRequest.setPrio(2);
		approvalRequest.setRegion("West");
		return approvalRequest;
	}
	
	public static ClaimApprovalResponse getResponseObject() {
		ObjectFactory factory = new ObjectFactory();
		Location location = factory.createLocation();
		location.setLocationId(34);
		Customer account = factory.createCustomer();
		account.setId("idAcc2");
		account.setName("IBM");
		account.setType( "Informatic BusinessAccount");
		account.setLocation(location);
		ClaimApprovalResponse response = factory.createClaimApprovalResponse();
		response.setAccount(account);
		response.setApproved(true);
		response.setAmount(30000);
		return response;
	}
}
