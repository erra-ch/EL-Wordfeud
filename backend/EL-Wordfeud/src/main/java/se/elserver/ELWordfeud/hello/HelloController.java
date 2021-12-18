package se.elserver.ELWordfeud.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class HelloController {

    @Autowired // This is dependency injection. HelloService is a singleton (service)
    private HelloService helloService;

    @GetMapping("/hello")
    public List<Hello> hello() {
        return helloService.getHelloList();
    }
}
