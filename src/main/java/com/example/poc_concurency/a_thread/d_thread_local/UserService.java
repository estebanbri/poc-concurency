package com.example.poc_concurency.a_thread.d_thread_local;

class UserService implements Runnable {
    private final String userId;
    private UserRepository userRepository = new UserRepository();

    public UserService(String userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        // Set user ID in ThreadLocal
        UserContext.setUserId(userId);

        // Simulate some work with the user ID
        System.out.println("Processing in UserService user ID: " + UserContext.getUserId());

        userRepository.execute();

        // Clear the ThreadLocal variable after use
        UserContext.clear();
    }
}
