public class solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = (m + n - 1) / 2;
        boolean even = ((m + n) % 2 < 1) ? true : false;
        int index1 = 0;
        int index2 = 0;
        double result = 0.0;

        for(int i = 0; i < total; i++)
            if(index1 < m && index2 < n)
                if(nums1[index1] < nums2[index2])
                    index1++;
                else
                    index2++;
            else
                if(index1 == m)
                    index2++;
                else
                    index1++;
        if(index1 < m && index2 < n)
            if(nums1[index1] < nums2[index2])
                result = nums1[index1++];
            else
                result = nums2[index2++];
        else
            if(index1 == m)
                result = nums2[index2++];
            else
                result = nums1[index1++];
        if(even)
        {
            if(index1 < m && index2 < n)
                if(nums1[index1] < nums2[index2])
                    result += nums1[index1];
                else
                    result += nums2[index2];
            else
                if(index1 == m)
                    result +=nums2[index2];
                else
                    result += nums1[index1];
            result /= 2;
        }
            
        return result;
    }
}
