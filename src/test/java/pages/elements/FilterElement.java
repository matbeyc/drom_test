package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import pages.selectors.FilterSelectors.ConstantFilterSelectors;
import pages.elements.utils.filter.MarkList;

import java.util.*;

public class FilterElement extends BasePage {


    public void displayTopSoldMarks(Integer topBorder) {
        MarkList markList = new MarkList(getAllMarkElements());
        markList.sortDesc();
        markList.display(20);
    }

    private List<WebElement> getAllMarkElements() {
        Select select = new Select(driver.findElement(ConstantFilterSelectors.SELECT_MARK_DROPDOWN));
        return select.getOptions();
    }
}
