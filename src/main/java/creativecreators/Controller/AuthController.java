package creativecreators.Controller;

import creativecreators.Service.AuthService.AuthService;
import creativecreators.Service.AuthService.exception.AuthExceptionType;
import creativecreators.Service.AuthService.exception.AuthServiceException;
import creativecreators.dto.AuthenticationResponse;
import creativecreators.dto.UserDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {


    private final Logger logger = LogManager.getLogger(AuthController.class);
    @Autowired
    AuthService authService;
    @ApiOperation(value = "Login a specific user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AuthenticationResponse.class),
            @ApiResponse(code = 400, message = "INVALID_CREDENTIALS", response = AuthExceptionType.class),
            @ApiResponse(code = 404, message = "INVALID_CREDENTIALS", response = AuthExceptionType.class)
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<AuthenticationResponse> login(@Valid UserDto user, BindingResult result){

        logger.info("+++++++++LOGGING login+++++++++");
        loggingUserDto(user);
        if (result.hasErrors())
            throw new AuthServiceException("Username or password for user: "+ user+" can not be null!", AuthExceptionType.INVALID_CREDENTIALS, HttpStatus.BAD_REQUEST);

        AuthenticationResponse response = authService.login(user.getUsername(),user.getPassword());
        logger.info("+++++++++SUCCESSFUL LOGGING login+++++++++");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void loggingUserDto(UserDto userDto){

        logger.info("Username: {}", userDto.getUsername());
        logger.info("Password: {}", userDto.getPassword());
    }

}
