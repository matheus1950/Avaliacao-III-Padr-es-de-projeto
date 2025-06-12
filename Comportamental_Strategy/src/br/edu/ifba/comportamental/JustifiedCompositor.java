package br.edu.ifba.comportamental;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class JustifiedCompositor implements Compositor {
    private final int lineWidth;

    public JustifiedCompositor(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    @Override
    public String compose(String text) {
        System.out.printf("--- Formatando com JustifiedCompositor (%d colunas) ---\n", this.lineWidth);

        StringBuilder result = new StringBuilder();
        String[] words = text.split("\\s+");

        List<String> currentLineWords = new ArrayList<>();
        int currentLineLength = 0;

        for (String word : words) {
            if (currentLineLength + word.length() + currentLineWords.size() > this.lineWidth) {
                result.append(formatLine(currentLineWords, currentLineLength));
                result.append("\n");

                currentLineWords.clear();
                currentLineWords.add(word);
                currentLineLength = word.length();
            } else {
                currentLineWords.add(word);
                currentLineLength += word.length();
            }
        }

        if (!currentLineWords.isEmpty()) {
            result.append(leftAlignLine(currentLineWords));
        }

        return result.toString();
    }

    private String formatLine(List<String> words, int wordsLength) {
        if (words.size() <= 1) {
            return leftAlignLine(words);
        }

        StringBuilder lineBuilder = new StringBuilder();
        int totalSpacesNeeded = this.lineWidth - wordsLength;
        int gaps = words.size() - 1;

        int baseSpaces = totalSpacesNeeded / gaps;
        int extraSpaces = totalSpacesNeeded % gaps;

        lineBuilder.append(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            int spacesToApply = baseSpaces + (extraSpaces-- > 0 ? 1 : 0);
            for (int j = 0; j < spacesToApply; j++) {
                lineBuilder.append(" ");
            }
            lineBuilder.append(words.get(i));
        }

        return lineBuilder.toString();
    }
    
    private String leftAlignLine(List<String> words) {
        return String.join(" ", words);
    }
}