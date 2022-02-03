package se.elserver.ELWordfeud.game.dictionary;

import com.gargoylesoftware.css.parser.CSSErrorHandler;
import com.gargoylesoftware.css.parser.CSSException;
import com.gargoylesoftware.css.parser.CSSParseException;
import com.gargoylesoftware.htmlunit.IncorrectnessListener;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptErrorListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SwedishWordDictionary extends WordDictionary {

    private WebClient webClient;

    public SwedishWordDictionary() {
        super.wordMap = setWordMap(); // Don't know how this should be done
    }

    private Map<String, String> setWordMap() {
        return new HashMap<>(
          // Where should this info be?
        );
    }

    private void getWord(String word) {
        // load page using HTML Unit and fire scripts
        if (webClient == null) {
            webClient = new WebClient();
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.setIncorrectnessListener(new IncorrectnessSilencer());
            webClient.setCssErrorHandler(new CSSSilencer());
            webClient.setJavaScriptErrorListener(new ScriptErrorSilencer());
        }
        word = word.toLowerCase();
        try {
        HtmlPage myPage = webClient.getPage("https://svenska.se/tre/?sok=" + word);
        Thread.sleep(2000); // TODO: What is optimal time to wait? Or other solution
        // convert page to generated HTML and convert to document
        Document doc = Jsoup.parse(myPage.asXml());
        Element saol = doc.getElementById("saol-1").getElementsByClass("cshow").first();
        if (saol.text().contains("Sökningen")) {
            super.wordMap.put(word, "false");
        } else {
            super.wordMap.put(word,saol.getElementsByClass("syntex").text().replaceAll("\u00AD", ""));
        }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isValidWord(String word) {
        word = word.toLowerCase();
        if (!super.wordMap.containsKey(word)) {
            getWord(word);
        }
        System.out.println(super.wordMap.get(word));
        if (super.wordMap.get(word).equals("false")) {

            return false;
        }
        return true;
    }

    @Override
    public String getDefinition(String word) {
        word = word.toLowerCase();
        if (!super.wordMap.containsKey(word)) {
            getWord(word);
        }
        return super.wordMap.get(word);
    }


    // Custom implementations to silence errors

    class IncorrectnessSilencer implements IncorrectnessListener {

        @Override
        public void notify(String s, Object o) {

        }
    }

    class CSSSilencer implements CSSErrorHandler {


        @Override
        public void warning(CSSParseException e) throws CSSException {

        }

        @Override
        public void error(CSSParseException e) throws CSSException {

        }

        @Override
        public void fatalError(CSSParseException e) throws CSSException {

        }
    }

    class ScriptErrorSilencer implements JavaScriptErrorListener {

        @Override
        public void scriptException(HtmlPage htmlPage, ScriptException e) {

        }

        @Override
        public void timeoutError(HtmlPage htmlPage, long l, long l1) {

        }

        @Override
        public void malformedScriptURL(HtmlPage htmlPage, String s, MalformedURLException e) {

        }

        @Override
        public void loadScriptError(HtmlPage htmlPage, URL url, Exception e) {

        }

        @Override
        public void warn(String s, String s1, int i, String s2, int i1) {

        }
    }
}
