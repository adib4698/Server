package creativecreators.Controller;

import creativecreators.Entities.Tutorial;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tutorial")
public class TutorialController {
    private final Logger logger = LogManager.getLogger();

    @Autowired
    private TutorialService service;
   @ApiOperation(value = "findAllTutorials")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
    })
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tutorial>> findAllTutorials() {
        List<Tutorial> entities = service.findAllTutorials();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @ApiOperation(value = "findTutorialsByCategory")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
    })
    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Tutorial>> findTutorialsByCateogry(@PathVariable String category) {
        List<Tutorial> entities = service.findTutorialsByCategory(category);
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/saveTutorial/tutorialTitle/{tutorialTitle}/description/{description}/tutorialImage/{tutorialImage}/video/{video}/photos/{photos}/category/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String findAllCommentsByTutorial(@PathVariable String tutorialTitle, @PathVariable String description, @PathVariable String tutorialImage, @PathVariable String video, @PathVariable String photos, @PathVariable String category ) {
        service.addTutorial(tutorialTitle,description,tutorialImage,video,photos,category);
        return "OK";
    }
}
