package Fsoft.MockProject.services.service_interface;

import Fsoft.MockProject.entities.ResponseAPI;
import Fsoft.MockProject.entities.entitiesDTO.request.UserRequest;
import Fsoft.MockProject.entities.entitiesDTO.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> list();
    ResponseAPI add(UserRequest userRequest);
    ResponseAPI update(UserRequest userRequest, int id);
    ResponseAPI delete(int id);
}
