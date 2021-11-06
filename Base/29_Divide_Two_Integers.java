class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        long dividend_ = dividend < 0 ? -Long.valueOf(dividend) : dividend;
        long divisor_ = divisor < 0 ? -Long.valueOf(divisor) : divisor;
        long quotient = 0;

        for (int i = 31; i >= 0; i--) {
            if (divisor_ << i <= dividend_ && divisor_ > 0L) {
                quotient += 1L << i;
                dividend_ -= divisor_ << i;
                if (dividend_ == 0)
                    break;
            }
        }
        if (dividend < 0 ^ divisor < 0)
            quotient = -quotient;
        if (quotient > Integer.MAX_VALUE)
            quotient = Integer.MAX_VALUE;

        return (int) quotient;
    }
}
