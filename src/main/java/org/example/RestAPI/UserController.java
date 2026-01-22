package org.example.RestAPI;


/*
@PathVariable - to take url me path ka variable
@RequestBody - json body ka data
@RequestParam - query string parameters
@RequestHeader - http headers
@CookieValue - cookies

 */
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> list = new ArrayList<>();

    //Get all users
    @GetMapping
    public List<User> getAllUsers(){
        return list;
    }

    //POST add users
    @PostMapping
    public String addUser(@RequestBody User user) {
        list.add(user);
        return "added!";
    }

    //POST add multiple users
    @PostMapping("/bulk")
    public String addAllUser(@RequestBody List<User> users) {
        list.addAll(users);
        return "Total - " + list.size();
    }

    //GET user by index
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return list.get(id);
    }

    //DELETE user by index
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        list.remove(id);
        return "deleted!";
    }

    // put - replace the resource file with the given data
    //updating the user at index id will get updated with the given user data,
    // the missing fields will be null if not given in the data
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {

        if (id < 0 || id >= list.size()) {
            return "Invalid id/index!";
        }

        user.setId(id); //assigns the id from the url to the given user data
        list.set(id, user); //updating
        return "done!";
    }

    //patch - updates resource file but does not change the value of the fields which are missing
    @PatchMapping("/{id}")
    public String partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> updates) {

        if (id < 0 || id >= list.size()) {
            return "Invalid id/index!";
        }

        if(updates.containsKey("name")) {
            Object newName = updates.get("name");
            list.get(id).setName((String) newName);
        }
        if(updates.containsKey("email")) {
            Object newEmail = updates.get("email");
            list.get(id).setEmail((String) newEmail);
        }

        return "patch";

    }


}
