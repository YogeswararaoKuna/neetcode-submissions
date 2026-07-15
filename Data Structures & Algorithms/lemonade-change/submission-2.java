class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f = 0;
        int te = 0;

        for (int bill : bills) {

            if (bill == 5) {
                f++;
            }

            else if (bill == 10) {
                if (f == 0)
                    return false;

                f--;
                te++;
            }

            else { // bill == 20

                if (te >= 1 && f >= 1) {
                    te--;
                    f--;
                }
                else if (f >= 3) {
                    f -= 3;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}