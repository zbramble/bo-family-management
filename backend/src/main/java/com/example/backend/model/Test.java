package com.example.backend.model;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Test {

    public Test() {
        Test[] t = new Test[11];
        System.out.println("Object array testing: " + (t[0] == null));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Hello Thread!" + (0 + 'a'));

                // Arrays.asList
                Integer[] intArr = new Integer[]{1, 2, 4};
                List<Integer> list = Arrays.asList(intArr);
                list.set(0, 5);
                // Convert List to Array
                for (int i : list.toArray(new Integer[0])) {
//                    System.out.println("Arr: " + i);
                }

                // List.of
                List<Integer> list1 = List.of(intArr);
                // list1.set(0, 5);
//                list1.forEach(System.out::println);

                // record class
                Pairs pair = new Pairs(100, 200);
//                System.out.println(pair.key() + " " + pair.value());

                // Arrays.sort
                String[] strArr = new String[]{"3", "22", "111"};
                Arrays.sort(strArr);
//                Arrays.asList(strArr).forEach(System.out::println);

                // Functional Interface
                TestFunction<Integer> testFunction = a -> pair.key() + a;
//                System.out.println("Test Function: " + testFunction.test(1));

                // System.out.println("trailingZeroes: " + trailingZeroes(10000));

//                ArrayDeque<String> ad = new ArrayDeque<>();
                StringUtils.isNumeric("a");

                HttpClient httpClient = HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000).responseTimeout(Duration.ofMillis(5000)).doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS)).addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

                WebClient client = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();

                WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.post();

            }
        });

        thread.start();
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Pairs> visited = new HashSet<>();
        pq.offer(new int[]{nums1[0] + nums2[0], 0, 0});

        while (k-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1];
            int j = top[2];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length && !visited.contains(new Pairs(i + 1, j))) {
                pq.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pairs(i + 1, j));
            }

            if (j + 1 < nums2.length && !visited.contains(new Pairs(i, j + 1))) {
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pairs(i, j + 1));
            }
        }

        return ans;
    }

    public int trailingZeroes(int n) {
        int count5 = IntStream.rangeClosed(1, n).map(i -> {
            int count = 0;
            while (i % 5 == 0) {
                count++;
                i /= 5;
            }
            return count;
        }).sum();

        int count2 = IntStream.rangeClosed(1, n).map(i -> {
            int count = 0;
            while (i % 2 == 0) {
                count++;
                i /= 2;
            }
            return count;
        }).sum();
        return Math.min(count2, count5);
    }

    @FunctionalInterface
    public interface Count {
        int count();
    }

    record Pairs(Integer key, Integer value) {
    }
}
