import java.util.HashMap;
import java.util.Map;

public class UsersData {

    private HashMap<String, User> usersMap=new HashMap<String,User>();


    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    public void addUsersToMap(String str, User user) {
        usersMap.put(str,user);
    }

    @Override
    public String toString() {
        return usersMap.toString();
    }


}
