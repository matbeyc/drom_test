package helpers;

public class XpathGenerator {
    public static String createXpath(String xpathExp, Object... args) {
        for (int i = 0; i < args.length; i++) {
            xpathExp = xpathExp.replace("{" + i + "}", (CharSequence) args[i]);
        }
        return xpathExp;
    }
}
