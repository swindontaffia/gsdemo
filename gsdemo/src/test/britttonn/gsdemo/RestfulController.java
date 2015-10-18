package test.britttonn.gsdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

//import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import test.britttonn.gsdemo.model.beans.Sentence;

@RestController
public class RestfulController {

    @RequestMapping(method=RequestMethod.GET, value="/gsdemo/findtext/json/{bookName}")
    public Sentence getSentenceAsJson(@PathVariable String bookName, @RequestParam(value="text") String text) {
    	// Using both pathVaribale and requestParam simply the purpose of the demo 
    	Sentence sentence = new Sentence();
    	return sentence.addText("The sea glinted with merry making").addText(" ").addText(text);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/findtext/text/{bookName}")
    public String getSentenceAsText(@PathVariable String bookName, @RequestParam(value="text") String text) throws GSDemoException,GSDemoNotFoundException{
    	if(text.equals("*")) throw new GSDemoException(); 

    	else if (text.equals("n")) throw new GSDemoNotFoundException();
    	
    	Sentence sentence = new Sentence();
    	return sentence.addText("The sea glinted with merry making").addText(" ").addText(text).toString();
    }

    @ExceptionHandler(GSDemoException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public String handleException() {
        return "That doesnt work - conflict";
    }
    
    @ExceptionHandler(GSDemoNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleException2() {
        return "That doesnt work - not foud";
    }

}


