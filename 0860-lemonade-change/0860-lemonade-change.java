class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0; // Counters for $5 and $10 bills

        for (int payment : bills) {
            if (payment == 5) {
                five++; // Simply collect $5
            } else if (payment == 10) {
                if (five == 0) return false; // Need at least one $5 bill for change
                five--; // Give one $5 bill as change
                ten++; // Collect the $10 bill
            } else { // payment == 20
                if (ten > 0 && five > 0) { 
                    ten--; // Give one $10 bill as change
                    five--; // Give one $5 bill as change
                } else if (five >= 3) { 
                    five -= 3; // Give three $5 bills as change
                } else {
                    return false; // Unable to provide correct change
                }
            }
        }
        return true; // If we've provided correct change to all customers, return true
    }
}