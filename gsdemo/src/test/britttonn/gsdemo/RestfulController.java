package test.britttonn.gsdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import test.britttonn.gsdemo.model.beans.Sentence;

@Controller
public class RestfulController {

    @RequestMapping(method=RequestMethod.GET, value="/gsdemo")
    public String getSentence(@RequestParam(value="book") String bookName, @RequestParam(value="text") String text) {
    	Sentence sentence = new Sentence();
    	return sentence.addText("The sea glinted with merry making.").toString();
    }
}


