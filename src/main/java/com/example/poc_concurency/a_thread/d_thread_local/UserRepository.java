package com.example.poc_concurency.a_thread.d_thread_local;

public class UserRepository {
    public void execute() {
        System.out.println("Processing in UserRepository user ID: " + UserContext.getUserId());
    }
}
