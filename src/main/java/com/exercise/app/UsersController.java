package com.exercise.app;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UsersController {
    @Autowired
    private UserServices userServices;


    //HTTP Get returns list of users
    @RequestMapping("/")
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    //Get specific user (not required)
    // @RequestMapping("/users/{id}")
    // public User getUser(@PathVariable String id){
    //     return userServices.getUser(id.toLowerCase());
    // }



    //Post new user
    @RequestMapping(method=RequestMethod.POST, value = "/")
    @ResponseBody
    public String addUser(@RequestBody User user) throws Exception{
        //Verify a username, password, and IP address have been entered
        if(user.getUserName()==null||user.getPassword()==null||user.getIpAddress()==null){
            throw new Exception("Enter username, password, and IP address");
        }

        //Check if password is valid
        if(!isValid(user.getPassword())){
            throw new Exception("Password must be greater than 8 characters, containing at least 1 number, 1 Capitalized letter, 1 special character in this set _# $ % .");
        }
        else{
            //check if from Canada
            if(!validLocation(user)){
                throw new Exception("Users in this location are not eligible to register");
            }
            //Assign user UUID and send welcome message
            user.setUuid(UUID.randomUUID());
            //userServices.addUserToList(user);
            return "Welcome "+user.getUserName()+" ID: "+user.getUuid()+" from "+user.getCity();
        }
        
        
    }

   


    //Check user is from valid location
    public boolean validLocation(User user){
        Location location;
        //call external API
        RestTemplate restTemplate = new RestTemplate();
        location=restTemplate.getForObject("http://ip-api.com/json/"+user.getIpAddress(), Location.class);
        
        if(location.getCountry().equals("Canada")){
            user.setCity(location.getCity());
            return true;
        }
        return false;
    }

    //Verify password meets all requirements
    public boolean isValid(String pass){
        if(pass.length()<8) return false;
        if(pass.matches("[a-zA-Z0-9_#$%.]+")&&
        pass.matches(".*[A-Z]+.*")&&
        pass.matches(".*[0-9]+.*")&&
        pass.matches(".*[_#$%.]+.*")
        )return true;
        else return false;
    
    }

}
