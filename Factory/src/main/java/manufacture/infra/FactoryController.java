package manufacture.infra;
import manufacture.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/factories")
@Transactional
public class FactoryController {
    @Autowired
    FactoryRepository factoryRepository;




    @RequestMapping(value = "factories/{id}/recall",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Factory recallProduct(@PathVariable(value = "id")  id, @RequestBody RecallProductCommand recallProductCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /factory/recallProduct  called #####");
            Optional<Factory> optionalFactory = factoryRepository.findById(id);
            
            optionalFactory.orElseThrow(()-> new Exception("No Entity Found"));
            Factory factory = optionalFactory.get();
            factory.recallProduct(recallProductCommand);
            
            factoryRepository.save(factory);
            return factory;
            
    }
    



}
