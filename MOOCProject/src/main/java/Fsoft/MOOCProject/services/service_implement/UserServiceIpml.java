package Fsoft.MOOCProject.services.service_implement;

import Fsoft.MOOCProject.entities.model.User;
import Fsoft.MOOCProject.repository.UserRepository;
import Fsoft.MOOCProject.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIpml {
    @Autowired
    private UserRepository userRepository;

    Helper helper = new Helper();

    public List<User> list(){
        return this.userRepository.findAll();
    }

    public String add(User u){
        try {
            User user = helper.getUser(u, this.userRepository.findAll());
            if(user == null){
                if(u.getRId() < 1 || u.getRId() > 2){
                    return "role is invalid";
                }else{
                    this.userRepository.save(u);
                    return "Create account successfully";
                }
            }else{
                return "Username has been existed";
            }
        }catch (Exception e){
            return "ex";
        }
    }

    public String update(User u, int id){
        try {
            User user = userRepository.findById(id).get();
            if(user != null){
                user.setPassword(u.getPassword());
                user.setRId(u.getRId());
                user.setStatus(u.getStatus());
                this.userRepository.save(user);
                return "updated!";
            }else{
                return "account is not exists";
            }
        }catch (Exception e){
            return "ex " + e.getMessage();
        }
    }

    public String delete(int id){
        try {
            User user = userRepository.findById(id).get();
            if(user.getRId() == 1){
                return "this is your boss's account, you can't delete it";
            }else{
                this.userRepository.deleteById(id);
                return "deleted!";
            }
        }catch (Exception e){
            return "ex" + e.getMessage();
        }
    }

    public String login(User u){
         try {
             User user = helper.login(u, this.userRepository.findAll());

             if(user == null){
                 return "login fail";
             }else {
                 //day vao session, cookie
                 return "login successfully\nWelcome " + user.getUsername();
             }
         }catch (Exception e){
            return "ex" + e.getMessage();
         }
    }
}
