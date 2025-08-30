import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Calculation History Manager
 * Stores and manages the history of calculations performed
 */
public class CalculationHistory {
    private static List<HistoryEntry> history = new ArrayList<>();
    private static final int MAX_HISTORY_SIZE = 50;
    
    /**
     * Inner class to represent a history entry
     */
    private static class HistoryEntry {
        private String calculation;
        private String timestamp;
        
        public HistoryEntry(String calculation) {
            this.calculation = calculation;
            this.timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );
        }
        
        @Override
        public String toString() {
            return String.format("[%s] %s", timestamp, calculation);
        }
    }
    
    /**
     * Add a calculation to history
     */
    public static void addToHistory(String calculation) {
        if (calculation == null || calculation.trim().isEmpty()) {
            return;
        }
        
        history.add(new HistoryEntry(calculation));
        
        // Maintain maximum history size
        if (history.size() > MAX_HISTORY_SIZE) {
            history.remove(0); // Remove oldest entry
        }
    }
    
    /**
     * Display calculation history
     */
    public static void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No calculations in history yet.");
            return;
        }
        
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                    CALCULATION HISTORY                     |");
        System.out.println("+-------------------------------------------------------------+");
        
        // Display last 10 entries (or all if less than 10)
        int startIndex = Math.max(0, history.size() - 10);
        
        for (int i = startIndex; i < history.size(); i++) {
            System.out.printf("| %-59s |%n", history.get(i).toString());
        }
        
        System.out.println("+-------------------------------------------------------------+");
        
        if (history.size() > 10) {
            System.out.println("Showing last 10 calculations. Total: " + history.size());
        }
    }
    
    /**
     * Clear calculation history
     */
    public static void clearHistory() {
        history.clear();
        System.out.println("History cleared successfully!");
    }
    
    /**
     * Get the number of calculations in history
     */
    public static int getHistorySize() {
        return history.size();
    }
    
    /**
     * Get the last calculation performed
     */
    public static String getLastCalculation() {
        if (history.isEmpty()) {
            return "No calculations performed yet.";
        }
        return history.get(history.size() - 1).calculation;
    }
}
