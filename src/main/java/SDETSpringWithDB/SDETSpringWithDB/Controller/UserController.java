package SDETSpringWithDB.SDETSpringWithDB.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    //Pass UserID as path parameter in request
    //localhost:8080/users/4
    @GetMapping(path="/{userID}")
    public String getUser(@PathVariable String userID){
        return "Get API is executes for User : " + userID;
    }

    //get users with query parameter pageNo and limit
    //localhost:8080/users?pageNo=3&limit=4
    @GetMapping
    public String getUsers(@RequestParam(value="pageNo") int pageNo,@RequestParam(value="limit") int limit){
        return "Get API is executes for page : " + pageNo + "and limit : " + limit  ;
    }

    @PostMapping
    public String addUser(){
        return "Post API is executes";
    }

    @PutMapping  
    public String updateUser(){
        return "Put Users is executes";
    }

    @DeleteMapping
    public String DeleteUser(){
        return "Delete API is executes";
    }

    @PatchMapping
    public String PatchUser(){
        return "Patch API is executes";
    }
}
