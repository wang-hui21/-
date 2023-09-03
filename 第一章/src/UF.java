public class UF {
    private int[] id;    //����ID���Դ�����Ϊ����
    private int count;  //��������

    public UF(int N) {
        //��ʼ������id����
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

//    public int find(int p) {
//        return id[p];
//    }
    private int find(int p){
        //�ҳ�����������
        while(p!=id[p]) p=id[p];
        return p;
    }

//    public void union(int p, int q)    //������������UF�㷨�����⣬���ں�������ʵ��
//    {
//        //��p��q�鲢����ͬ�ķ�����
//        int pID = find(p);
//        int qID = find(q);
//
//        //���p��q�Ѿ�����ͬ�ķ���������Ҫ��ȡ�κ��ж�
//        if (pID == qID) return;
//
//        //��p�ķ���������Ϊq������
//        for (int i = 0; i < id.length; i++) {
//            if (id[i] == pID) id[i] = qID;
//        }
//        count--;    //��¼�������ٸ�������
//    }
    public void union(int p,int q){
        //��p��q�ĸ��ڵ�ͳһ
        int pRoot=find(p);
        int qRoot=find(q);
        if (pRoot==qRoot) return;
        id[pRoot]=qRoot;
        count--;
    }

    public static void main(String[] args) {
        //�����StdIn�õ��Ķ�̬��ͨ������
        int N = StdIn.readInt();      //��ȡ��������
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();              //��ȡ������
            if (uf.connected(p, q)) continue;     //����Ѿ���ͨ�����
            uf.union(p, q);                      //�鲢����
            StdOut.println(p + " " + q);            //��ӡ����
        }
        StdOut.println(uf.count() + "components");
    }
}
