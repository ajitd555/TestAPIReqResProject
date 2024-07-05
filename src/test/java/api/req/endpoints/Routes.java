package api.req.endpoints;

public class Routes {

	public static String baseUrl="https://reqres.in/";
	
	public static String regitsrUser= baseUrl+"api/register";
	public static String loginUser=baseUrl+"api/login";
	public static String deleteUser=baseUrl+"api/users/{id}";
	public static String updateUserpatch=baseUrl+"api/users/2";
	public static String getAllUser=baseUrl+"api/users?page=2";
	
}
