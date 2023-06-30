package klotski.controller;
/**
 * Controller class responsible for controlling the timer.
 */
public class TimerController {
    private long startTime;
    private long elapsedTime;
    private boolean isRunning;
    
     /**
     * Default constructor for the TimerController class,
     * it starts the timer with a initial time of "00:00".
     */
    public TimerController() {
        startTimer("00:00");
    }
     /**
     * Constructor for the TimerController class with specified minutes and seconds. It starts the timer with the specified time.
     * 
     * @param minutes The initial minutes for the timer.
     * @param seconds The initial seconds for the timer.
     */
    public TimerController(int minutes, int seconds) {
        startTime = System.currentTimeMillis();
        elapsedTime = (minutes * 60 + seconds) * 1000;
        
        startTimer("00:00");
    }
     /**
     * Get the elapsed time in milliseconds.
     * 
     * @return The elapsed time in milliseconds.
     */
    public long getElapsedTime() {
        return elapsedTime;
    }
    /**
     * Set the timer with the specified time.
     * 
     * @param timeString The time string representing the desired time (format: minutes:seconds).
     */
    public void setTime(String timeString) {
        String[] timeParts = timeString.split(":");
        if (timeParts.length == 2) {
            int minutes = Integer.parseInt(timeParts[0].trim());
            int seconds = Integer.parseInt(timeParts[1].trim());
            this.elapsedTime = (minutes * 60 + seconds) * 1000;
        } else {
            throw new IllegalArgumentException("Invalid time format. Expected format: minutes:seconds");
        }
        startTime = System.currentTimeMillis() - elapsedTime;
        Thread timerThread = new Thread(() -> {
            while (true) {
                elapsedTime = System.currentTimeMillis() - startTime;

                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start();
    }
    
     /**
     * Start the timer with the specified time.
     * 
     * @param timeString The time string representing the initial time (format: minutes:seconds).
     */
    private void startTimer(String timeString) {
        String[] timeParts = timeString.split(":");
        if (timeParts.length == 2) {
            int minutes = Integer.parseInt(timeParts[0].trim());
            int seconds = Integer.parseInt(timeParts[1].trim());
            this.elapsedTime = (minutes * 60 + seconds) * 1000;
        } else {
            throw new IllegalArgumentException("Invalid time format. Expected format: minutes:seconds");
        }
        startTime = System.currentTimeMillis() + elapsedTime;
        startTimerThread();
    }
    /**
     * Start the timer thread.
     */
    private void startTimerThread() {
        isRunning = true;
        Thread timerThread = new Thread(() -> {
            while (isRunning) {
                elapsedTime = System.currentTimeMillis() - startTime;

                try {
                    Thread.sleep(1000); // Update the value every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start();
    }
    /**
     * Stop the timer.
     */
    public void stopTimer() {
        isRunning = false;
    }
     /**
     * Get the formatted time string representing the current elapsed time.
     * 
     * @return The formatted time string (format: minutes:seconds).
     */
    public String getTimeString() {
        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        String timeString = String.format("%02d:%02d", minutes, seconds);
        return timeString;
    }
    /**
     * Get the formatted time string representing the current elapsed time for updating the UI.
     * 
     * @return The formatted time string (format: minutes:seconds).
     */
    public String getTimeUpdate() {
        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        String timeString = String.format("%02d:%02d", minutes, seconds);
        return timeString;
    }
    /**
     * Reset the timer to zero.
     */
    public void resetTimer() {
        startTime = System.currentTimeMillis();
        elapsedTime = 0;
    }

}
