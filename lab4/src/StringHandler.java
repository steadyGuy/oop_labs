public class StringHandler {
    private static String getSymbolsByRegularExpressions(String str) {
        String res = new StringBuilder(str).reverse().toString();
        String pattern = "(.)(?=.*\\1)";
        res = res.replaceAll(pattern, "");

        return new StringBuilder(res).reverse().toString();
    }

    public static void showResultOfHandler(String[] args) {
        String argumentsStr = getArgumentsInStr(args, false);
        if (argumentsStr.isEmpty()) return;
        System.out.println(getSymbolsByRegularExpressions(argumentsStr));
    }

    public static String getArgumentsInStr(String[] arr, boolean readOnly) {
        StringBuilder str = new StringBuilder("");
        for(String key: arr) str.append(key + (readOnly ? " " : ""));

        return str.toString();
    }
}
