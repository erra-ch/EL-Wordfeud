package se.elserver.ELWordfeud.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    List<Hello> helloList = new ArrayList<>(Arrays.asList(
            new Hello(1, "Greetings!", false),
            new Hello(23, "Hejsan hoppsan!", true),
            new Hello(69, "Öh! Gönnar!", true)
    ));


    public Iterable<Hello> getHellosFromDatabase() {
        List<String> hellos = new ArrayList<String>();
        Iterable<Hello> fetchedHellos = helloRepository.findAll();
        for (Hello h : fetchedHellos) {
            hellos.add(h.getMessage());
        }

        return fetchedHellos;
    }

    public List<Hello> getHelloList() {
        return helloList;
    }
}
