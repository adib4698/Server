package creativecreators.Controller;

import creativecreators.Service.CommentsService.CommentsService;
import creativecreators.Service.ContactService.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Contact")
public class ContactController {
    private final Logger logger = LogManager.getLogger();

        @Autowired
        private ContactService contactService;
        @RequestMapping(value = "/addContact/firstName/{firstName}/lasName/{lastName}/email/{email}/phone/{phone}/comments/{comments}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        public String findAllCommentsByTutorial(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String email, @PathVariable String phone, @PathVariable String comments ) {
            contactService.addContact(firstName,lastName,email,phone,comments);
            return "OK";
        }
}
