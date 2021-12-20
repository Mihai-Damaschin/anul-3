public class Ex5 {
    static StringBuffer text = new StringBuffer("Noi programam in C++");

    public static void main(String[] args) {
        System.out.println("Textul initial este: " + text);

        System.out.println("Lungimea sirului este: " + showLength());

        replaceWithJava();
        replaceWhiteSpaces();
        appendString();
        reverse();

        System.out.println("Textul final este: " + text);
    }

    public static void replaceWithJava() {
        text.replace(text.length() - 3, text.length(), "Java");
    }

    public static void replaceWhiteSpaces() {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                text.replace(i, i + 1, "_");
            }
        }
    }

    public static int showLength() {
        return text.length();
    }

    public static void appendString() {
        text.append(" si in Java");
    }

    public static void reverse() {
        text.reverse();
    }
}
