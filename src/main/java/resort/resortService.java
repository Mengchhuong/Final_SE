package resort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class resortService {
    @Autowired
    private resortRepository resortRe;

    @Transactional
    public List<resort> listVisitor(){
        List<resort> re = new ArrayList<>();
        resortRe.findAll().forEach(re::add);
        return re;
    }
    @Transactional
    public resort addVisitor(resort re){
        try{
            resortRe.save(re);
            return re;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }


}
