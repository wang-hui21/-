public class train {
    public static void main(String[] args ) {
        System.out.println("Hello World!");
        int[] a={2,3,5,12,4,7,65,8,9,56,44};
        int key=56;
        int result=rank(key,a);
        System.out.println("二分查找的结果:"+result);
    }
    public static int rank(int key, int[] a)
    {
        return rank(key,a,0,a.length-1);
    }
    public static int rank(int key, int[] a, int lo, int hi){
        //如果key的值存在于a[]中，他的索引不会小于lo且不会大于hi
        if(lo>hi) return -1;
        int mid=lo+(hi-lo)/2;
        if (key<a[mid]) return rank(key,a ,lo,mid-1);
        else if (key>a[mid]) return rank(key,a,mid+1,hi);
        else return mid;
    }
}
