package TH3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        URL url = null;
        try {
            url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // open the stream and put it into BufferedReader
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
// close scanner
        scanner.close();
        // remove all new line
        content = content.replaceAll("\\n+", "");


        // regex
        Pattern p = Pattern.compile("name_song\">(.*?)</a>");
        Matcher m = p.matcher(content);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
