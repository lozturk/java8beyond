package Streams.assignments.brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkUtil {

    // hits the given url and returns the HTTP response code
    // this method will accept the link and will return the response code from that link

    public static int getResponseCode(String link) {
        // create a URL object
        URL url;
        // create a connection object
        HttpURLConnection connection = null;

        Integer responseCode = 0;
        try {
            url = new URL(link);
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            // skip
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return responseCode;
    }
}
