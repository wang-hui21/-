public class UF {
    private int[] id;    //分量ID（以触点作为索引
    private int count;  //分量数量
    public UF(int N){
        //初始化分量id数组
        count=N;
        id =new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
        }
    }
}
