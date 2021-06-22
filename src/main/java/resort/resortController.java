package resort;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class resortController {
    @Autowired
    private resortService resortService;
    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping("/register")
    public List<resort> getAllVisitor(){
        return resortService.listVisitor();
    }
    @CrossOrigin(origins="http://localhost:8080")
    
    @PostMapping("/visitor")
    public List<resort> postVisitor(@RequestBody resort re){
        ArrayList<resort> res = new ArrayList<resort>();
        
        res.add(resortService.addVisitor(re));
        return res;
    }
}
