package utils;

import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkList {


    private final List<Mark> markList;


    public MarkList(List<WebElement> markElementList) {
        this.markList = create(markElementList);
    }

    public void display(Integer topBorder) {
        System.out.format("| %-22s | %-22s | %n", "Фирма", "Количество объявлений");
        for (int i = 0; i < topBorder; i++) {
            System.out.format("| %-22s | %-22s | %n", markList.get(i).getName(), markList.get(i).getAmount());
        }
    }

    public void sortDesc() {
        markList.sort(Collections.reverseOrder());
    }


    private List<Mark> create(List<WebElement> allMarkElements) {
        Set<Mark> markSet = new HashSet<>();
        List<Mark> markList = new ArrayList<>();
        for (WebElement markElement : allMarkElements) {
            Integer amount = extractAmountOfSoldMarks(markElement);
            String name = extractMarkName(markElement);
            Mark mark = new Mark(name, amount);
            if (!markSet.contains(mark)) {
                markList.add(mark);
            }
            markSet.add(mark);
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
