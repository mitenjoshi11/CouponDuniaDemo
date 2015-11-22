package com.couponduniademo.httphelper;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class JSONHelper {

    public static final String TAG = "COUPONDUNIA  : JSON Helper";

    // TimeOuts for webservices
    public static final int CONNECTION_TIME_OUT = 30000;
    public static final int SOCKET_TIME_OUT = 30000;

    // URL OF WEBSERVICE
    private static final String URL = "http://staging.couponapitest.com/task.txt";

    public static String getWSResponse() {
        String jsonResponse = "";
        try {
            final HttpParams params = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(params, CONNECTION_TIME_OUT);
            HttpConnectionParams.setSoTimeout(params, SOCKET_TIME_OUT);
            HttpClientParams.setRedirecting(params, true);
            HttpClientParams.setCookiePolicy(params, CookiePolicy.BROWSER_COMPATIBILITY);

            DefaultHttpClient httpClient = new DefaultHttpClient(params);
            httpClient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:23.0) Gecko/20131011 Firefox/23.0");
            HttpGet httpGet = new HttpGet(URL);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            jsonResponse = EntityUtils.toString(httpEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }
}
