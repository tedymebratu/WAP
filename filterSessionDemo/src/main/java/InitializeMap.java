public class InitializeMap {

    private UsersData usersData;


    User user1=new User("abc","abc");
    User user2=new User("xyz","xyz");
    User user3=new User("fgh","fgh");
    User user4=new User("stu","stu");

    public InitializeMap(UsersData usersData) {

        this.usersData = usersData;

        usersData.addUsersToMap(user1.getUsername(),user1);
        usersData.addUsersToMap(user2.getUsername(),user2);
        usersData.addUsersToMap(user3.getUsername(),user3);
        usersData.addUsersToMap(user4.getUsername(),user4);


    }



}
