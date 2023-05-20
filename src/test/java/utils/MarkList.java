package utils;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkList {
    List<Mark> markList = new ArrayList<>();

    public MarkList(List<WebElement> markElementList) {
        this.markList = createMarkList(markElementList);
    }

    private List<Mark> createMarkList(List<WebElement> allMarkElements) {
        List<Mark> markList = new ArrayList<>();
        for (WebElement markElement : allMarkElements) {
            Integer amount = extractAmountOfSoldMarks(markElement);
            String name = extractMarkName(markElement);
            markList.add(new Mark(name, amount));
        }
        return markList;
    }

    private String extractMarkName(WebElement mark) {
        Pattern regex = Pattern.compile("([à-ÿÀ-ßa-zA-Z-]+)");
        Matcher regexMatcher = regex.matcher(mark.getText());
        if (regexMatcher.find()) {
            return regexMatcher.group(1);
        }
        return "";

    }

    private int extractAmountOfSoldMarks(WebElement mark) {
        Pattern regex = Pattern.compile("\\((.*?)\\)");
        Matcher regexMatcher = regex.matcher(mark.getText());
        while (regexMatcher.find()) {
            if (!Objects.equals(regexMatcher.group(1), "0")) {
                return Integer.parseInt(regexMatcher.group(1));
            }
        }
        return 0;
    }
}
