package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import selectors.FilterSelectors.ConstantFilterSelectors;
import utils.Mark;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FilterElement extends BasePage {


    public void getTopSoldMark(List<WebElement> markElementList, Integer topOf) {
        List<WebElement> allMarkElements = getAllMarkElements();
        List<Mark> markList = createMarkList(allMarkElements);
        List<Mark> sortedMarkList = sortMarkListDesc(markList);
        for (Mark mark : sortedMarkList) {
            System.out.println(mark.getName() + " " + mark.getAmount());
        }

    }

    private List<Mark> sortMarkListDesc(List<Mark> markList) {
        markList.sort(Comparator.comparing(Mark::getAmount));
        return markList;
    }

    private List<Mark> deleteDuplicates(List<Mark> markList) {
        markList = markList.stream().distinct().toList();
        return markList;
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


    public List<WebElement> getAllMarkElements() {
        Select select = new Select(driver.findElement(ConstantFilterSelectors.SELECT_MARK_DROPDOWN));
        return select.getOptions();
    }
}
