package helpers;

public class XpathGenerator {
    public static String createXpathForPagination(String xpathExp, Object... args) {
        for (int i = 0; i < args.length; i++) {
            xpathExp = xpathExp.replace("{" + i + "}", (CharSequence) args[i]);
        }
        return xpathExp;
    }

    public static String createXpathForCarCardBaseElement(String innerXpath) {
        return "//" + innerXpath + "/ancestor::a[@data-ftid=\"bulls-list_bull\"]";
    }
}
