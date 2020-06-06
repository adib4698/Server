package creativecreators.Controller;

import creativecreators.Entities.UserCC;
import creativecreators.Service.UserService.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    private final Logger logger = LogManager.getLogger();

    @ApiOperation(value = "findAllUsers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
    })
    @RequestMapping(value = "/findAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserCC>> findAllUsers() {
        List<UserCC> entities = service.findAllUsers();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
    @ApiOperation(value = "register")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
    })
    @RequestMapping(value = "/register/username/{username}/password/{password}/nickname/{nickname}/email/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String register(@PathVariable String username, @PathVariable String password, @PathVariable String nickname,@PathVariable String email) {
        service.register(username,password,nickname,email);
        return "Ok";
    }
}
