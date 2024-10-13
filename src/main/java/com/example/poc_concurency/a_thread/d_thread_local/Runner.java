package com.example.poc_concurency.a_thread.d_thread_local;

public class Runner {
    public static void main(String[] args) {
        // Create threads for different users
        Thread user1Thread = new Thread(new UserService("111-User1"));
        Thread user2Thread = new Thread(new UserService("222-User2"));

        // Start the threads
        user1Thread.start();
        user2Thread.start();
    }
}
