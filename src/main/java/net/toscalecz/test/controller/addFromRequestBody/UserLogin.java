package net.toscalecz.test.controller.addFromRequestBody;

//add from request body from frontend Login.vue
public class UserLogin {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
