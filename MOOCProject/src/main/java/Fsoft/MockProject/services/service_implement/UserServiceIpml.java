package Fsoft.MockProject.services.service_implement;

import Fsoft.MockProject.entities.ResponseAPI;
import Fsoft.MockProject.entities.entitiesDTO.request.UserRequest;
import Fsoft.MockProject.entities.entitiesDTO.response.UserResponse;
import Fsoft.MockProject.entities.model.User;
import Fsoft.MockProject.repository.UserRepository;
import Fsoft.MockProject.services.service_interface.UserService;
import Fsoft.MockProject.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIpml implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    Helper helper = new Helper();

    public UserServiceIpml(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UserRequest> getUserRequestList(){
        List<User> userList = this.userRepository.findAll();
        List<UserRequest> userRequestList = new ArrayList<>();
        for(User u : userList){
            userRequestList.add(mapper.map(u, UserRequest.class));
        }
        return userRequestList;
    }

    public List<UserResponse> list(){
        List<User> userList = this.userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        for(User u : userList){
            userResponseList.add(mapper.map(u, UserResponse.class));
        }
        return userResponseList;
    }

    public ResponseAPI add(UserRequest u){
            UserRequest user = helper.getUserRequest(u, this.getUserRequestList());
            if(user == null){
                if (u.getRole().equals("boss") || u.getRole().equals("dev")) {
                    User user1 = mapper.map(u, User.class);
                    this.userRepository.save(user1);
                    return new ResponseAPI(true, "Create account successfully");
                } else {
                    return new ResponseAPI(false, "role is invalid");
                }
            }else{
                return new ResponseAPI(false,"Username has been existed");
            }
    }

    public ResponseAPI update(UserRequest u, int id){
        try {
            Optional<User> user = this.userRepository.findById(id);
            if(user.isPresent()){
                u.setId(id);
                u.setUsername(user.get().getUsername());
                User user1 = mapper.map(u, User.class);
                this.userRepository.save(user1);
                return new ResponseAPI(true,"Updated");
            }else{
                return new ResponseAPI(false,"User is not exists");
            }
        }catch (Exception e){
            return new ResponseAPI(false, e.getMessage());
        }
    }

    public ResponseAPI delete(int id){
        try {
            Optional<User> user = userRepository.findById(id);
            if(user.isPresent()){
                if(user.get().getRole().equals("boss")){
                    return new ResponseAPI(false,"this is your boss's account, you can't delete it");
                }else{
                    this.userRepository.deleteById(id);
                    return new ResponseAPI(true, "deleted!");
                }
            }else{
                return new ResponseAPI(false,"user is not exists");
            }
        }catch (Exception e){
            return new ResponseAPI(false, e.getMessage());
        }
    }
}
