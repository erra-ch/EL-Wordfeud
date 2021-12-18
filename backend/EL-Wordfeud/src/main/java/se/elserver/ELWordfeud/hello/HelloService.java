package se.elserver.ELWordfeud.hello;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloService {

    List<Hello> helloList = new ArrayList<>(Arrays.asList(
            new Hello(1, "Greetings!", false),
            new Hello(23, "Hejsan hoppsan!", true),
            new Hello(69, "Öh! Gönnar!", true)
    ));

    public List<Hello> getHelloList() {
        return helloList;
    }
}
