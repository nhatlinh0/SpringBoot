package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> all = userService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("create-admin-user")
    public void createUser(@RequestBody User user) {
        userService.saveAdminUser(user);
    }

//    @PostMapping("/update/{myId}")
//    public ResponseEntity<?> updateAdmin (@PathVariable ObjectId myId) {
//        Optional<User> find = userService.findById(myId);
//        if (find.isPresent()) {
//            User user = find.get();
//            if (!user.getRoles().contains("ADMIN")) {
//                user.getRoles().add("ADMIN");
//                userService.saveUser(user);
//            }
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/delete/{myId}")
//    public ResponseEntity<?> deleteAdmin (@PathVariable ObjectId myId) {
//        Optional<User> find = userService.findById(myId);
//        if (find.isPresent()) {
//            User user = find.get();
//            if (user.getRoles().contains("ADMIN")) {
//                user.getRoles().remove("ADMIN");
//                userService.saveUser(user);
//            }
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
