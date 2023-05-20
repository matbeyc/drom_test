package utils;

import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkList {


    private List<Mark> markList;


    public MarkList(List<WebElement> markElementList) {
        this.markList = create(markElementList);
    }

    public void display() {
        System.out.format("| %-22s | %-22s | %n", "Фирма", "Количество объявлений");
        for (Mark mark : markList) {
            System.out.format("| %-22s | %-22s | %n", mark.getName(), mark.getAmount());
        }
    }

    public void sortDesc() {
        markList.sort(Collections.reverseOrder());
    }

    public void deleteDuplicates() {
        markList = markList.stream().distinct().toList();
    }

    private List<Mark> create(List<WebElement> allMarkElements) {
        List<Mark> markList = new ArrayList<>();
        for (WebElement markElement : allMarkElements) {
            Integer amount = extractAmountOfSoldMarks(markElement);
            String name = extractMarkName(markElement);
            markList.add(new Mark(name, amount));
        }
        return markList;
    }
    private String extractMarkName(WebElement mark) {
        Pattern regex = Pattern.compile("([а-яА-Яa-zA-Z-]+)");
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
