package com.task.exercise13;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Service {
    public CompletableFuture<String> fetchUserData(long userId){
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data:" +userId;
        });
    }
    public CompletableFuture<String> fetchCombinedUser(long userId1, long userId2){
        CompletableFuture<String> completableFuture1 = fetchUserData(userId1);
        CompletableFuture<String> completableFuture2 = fetchUserData(userId2);

        return completableFuture1.thenCombine(completableFuture2,(result1,result2) -> {
            return result1 + "," + result2;
        }).exceptionally(ex -> {
            return "Error : " +ex.getMessage();
        });
    }

    public static void main(String[] arg){
        Service service = new Service();
        CompletableFuture completableFuture = service.fetchCombinedUser(1,2);
        completableFuture.thenAccept(s -> System.out.println(s));
    }
}
