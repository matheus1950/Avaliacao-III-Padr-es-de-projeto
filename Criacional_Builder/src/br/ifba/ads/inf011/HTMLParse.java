package br.ifba.ads.inf011;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParse {

    private Pattern boldPattern = Pattern.compile("<b>|</b>", Pattern.CASE_INSENSITIVE);
    private Pattern  italicPattern = Pattern.compile("<i>|</i>", Pattern.CASE_INSENSITIVE);
    private Pattern  paraPattern = Pattern.compile("<p>|</p>|<br>|<br/>", Pattern.CASE_INSENSITIVE);
    private Pattern charPattern = Pattern.compile("."); 
    
    private String html;
    
	
	public HTMLParse(String html) {
		this.html = html.trim();
	}
	

	public List<Token> parse() {
        List<Token> tokens = new ArrayList<>();

        Matcher boldMatcher = boldPattern.matcher(html);
        Matcher italicMatcher = italicPattern.matcher(html);
        Matcher paraMatcher = paraPattern.matcher(html);
        Matcher charMatcher = charPattern.matcher(html);


        int lastIndex = 0;

        while (lastIndex < html.length()) {
            boldMatcher.region(lastIndex, html.length());
            italicMatcher.region(lastIndex, html.length());
            paraMatcher.region(lastIndex, html.length());
            charMatcher.region(lastIndex, html.length());

            if (boldMatcher.find() && boldMatcher.start() == lastIndex) {
                tokens.add(new Token(TipoToken.BOLD, boldMatcher.group().toLowerCase())); // <b> ou </b>
                lastIndex = boldMatcher.end();
            } else if (italicMatcher.find() && italicMatcher.start() == lastIndex) {
                tokens.add(new Token(TipoToken.ITALIC, italicMatcher.group().toLowerCase())); // <i> ou </i>
                lastIndex = italicMatcher.end();
            } else if (paraMatcher.find() && paraMatcher.start() == lastIndex) {
                String match = paraMatcher.group();
                tokens.add(new Token(TipoToken.PARA, match.toLowerCase()));
                lastIndex = paraMatcher.end();
            } else if (charMatcher.find() && charMatcher.start() == lastIndex) {
                tokens.add(new Token(TipoToken.CHAR, charMatcher.group()));
                lastIndex = charMatcher.end();
            } else {
                break;
            }
        }

        return tokens;
    }
	
}
