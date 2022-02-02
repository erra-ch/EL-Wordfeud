package se.elserver.ELWordfeud;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.elserver.ELWordfeud.game.dictionary.SwedishWordDictionary;
import se.elserver.ELWordfeud.game.dictionary.WordDictionary;

import java.util.logging.Level;

@SpringBootApplication
public class ElWordfeudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElWordfeudApplication.class, args);
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		WordDictionary dict = new SwedishWordDictionary();
		System.out.println(dict.getDefinition("attans"));
	}
}
