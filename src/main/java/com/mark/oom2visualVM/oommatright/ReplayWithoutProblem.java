package com.mark.oom2visualVM.oommatright;

import com.mark.oom2visualVM.oommat.HttpAsyncClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;

import java.util.ArrayList;
import java.util.List;

public class ReplayWithoutProblem {
    public List loadMockRequest(int n) {
        List cache = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            //todo 改动
            cache.add("http://www.baidu.com?a=" + i);
        }
        return cache;
    }

    public void start(List cache) throws InterruptedException {
        HttpAsyncClient httpClient = new HttpAsyncClient();
        int i = 0;
        while (true) {
            //todo 改动
            String url = (String) cache.get(i % cache.size());
            final HttpGet request = new HttpGet(url);
            httpClient.execute(request,
                    new FutureCallback() {
//                public void completed(final HttpResponse response) {
//
//                }

                        @Override
                        public void completed(Object o) {
                            final HttpResponse response = (HttpResponse) o;
                            System.out.println(request.getRequestLine() + "->" + response.getStatusLine());
                        }

                        public void failed(final Exception ex) {
                            System.out.println(request.getRequestLine() + "->" + ex);
                        }

                        public void cancelled() {
                            System.out.println(request.getRequestLine() + " cancelled");
                        }
                    });
            i++;
            Thread.sleep(100);
        }
    }
}
