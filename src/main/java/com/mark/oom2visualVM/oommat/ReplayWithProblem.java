package com.mark.oom2visualVM.oommat;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;

import java.util.ArrayList;
import java.util.List;

public class ReplayWithProblem {
    public List loadMockRequest(int n) {
        List cache = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            HttpGet request = new HttpGet("http://www.baidu.com?a=" + i);
            cache.add(request);
            //OOM报错后最大的对象是这个ArrayList，说明往里面填的HttpGet太大太多了，那就改掉，不要add对象，直接add URL,要用的时候根据URL再生产对象
        }
        return cache;
    }

    public void start(List cache) throws InterruptedException {
        HttpAsyncClient httpClient = new HttpAsyncClient();
        int i = 0;
        while (true) {
            final HttpUriRequest request = (HttpUriRequest) cache.get(i % cache.size());
            httpClient.execute(request,
                    new FutureCallback() { //每次发起请求都会new一个回调类！！！！！！！

//                public void completed(final HttpResponse response) {
//                    System.out.println(request.getRequestLine() + "->" + response.getStatusLine());
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
