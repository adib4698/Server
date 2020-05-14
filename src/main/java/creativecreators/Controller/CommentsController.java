package creativecreators.Controller;

import creativecreators.Entities.Comment;
import creativecreators.Entities.Tutorial;
import creativecreators.Service.CommentsService.CommentsService;
import creativecreators.Service.TutorialService.TutorialService;
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
@RequestMapping("/comments")
public class CommentsController {

    private final Logger logger = LogManager.getLogger();

    @Autowired
    private CommentsService service;
    @ApiOperation(value = "findAllComments")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
    })
    @RequestMapping(value = "/findAll/tutorial/{idTutorial}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Comment>> findAllCommentsByTutorial(@PathVariable String idTutorial) {
        List<Comment> entities = service.findCommentsFromTutorial(idTutorial);
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @ApiOperation(value = "saveComment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
    })
    @RequestMapping(value = "/saveComment/tutorial/{idTutorial}/userUsername/{userUsername}/comment/{comment}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String findAllCommentsByTutorial(@PathVariable String idTutorial, @PathVariable String userUsername, @PathVariable String comment) {
        service.addComment(idTutorial,userUsername,comment);
        return "OK";
    }

}
