
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import nu.te4.entities.User;
import nu.te4.sessionbeans.UserFacade;
import nu.te4.support.BCrypt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guan97005
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

    private String name, password, hashedPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @EJB
    UserFacade userFacade;

    public List<User> getUsers() {
        return userFacade.findAll();
    }

    public String createUser() {
        hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(null, name, hashedPassword);
        userFacade.create(user);
        return "index";
    }

    public String authenticate() {
        List<User> user = userFacade.findWithName(name);
        User users = user.get(0);
        if(BCrypt.checkpw(password, users.getPassword())){
            System.out.println("Logged in");
               return "myPage";
        }else{
            System.out.println("Login does not work");
             return "index";
        }
    }

    //public String login(){
    //String namn = "Koke";
    //if(name.equals(namn)){
    //  return "myPage";
    //}else{
    //  return "index";
    //}
    //}
}
