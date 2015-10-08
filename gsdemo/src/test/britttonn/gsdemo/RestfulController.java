package test.britttonn.gsdemo;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.britttonn.gsdemo.model.beans.Sentence;

@RestController
public class RestfulController {

    @RequestMapping(method=GET, value="/gsdemo/findtext/json/{bookName}")
    public Sentence getSentenceAsJson(@PathVariable String bookName, @RequestParam(value="text") String text) {
    	Sentence sentence = new Sentence();
    	return sentence.addText("The sea glinted with merry making");
    }
    
    @RequestMapping(method=GET, value="/gsdemo/findtext/text/{bookName}")
    public String getSentenceAsText(@PathVariable String bookName, @RequestParam(value="text") String text) {
    	Sentence sentence = new Sentence();
    	return sentence.addText("The sea glinted with merry making").toString();
    }

}


