package com.example.poc_concurency.a_thread.d_thread_local;

public class UserContext {
    // ThreadLocal variable to store user ID
    private static final ThreadLocal<String> userIdThreadLocal = new ThreadLocal<>();

    // Method to set user ID
    public static void setUserId(String userId) {
        userIdThreadLocal.set(userId);
    }

    // Method to get user ID
    public static String getUserId() {
        return userIdThreadLocal.get();
    }

    // Method to clear user ID
    public static void clear() {
        userIdThreadLocal.remove();
    }
}
