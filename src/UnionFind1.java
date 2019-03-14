public class UnionFind1 implements UF {

    //第一个版本的并查集 , 本质是一个数组
    private int[] id;   //数组里面存放的是每个元素所属集合的编号

    public UnionFind1(int size){
        id = new int[size];

        //初始化 , 每个id[i]指向自己 , 没有合并的元素
        for(int i = 0 ; i < size ; i++){
            id[i] = i;
        }
    }


    @Override
    public int getSize() {
        //返回并查集中维护的属性
        return id.length;
    }

    //查找元素p所对应的集合编号
    //O(1)复杂度
    private int find(int p){
        //p的合法性判断
        if(p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound");

        return id[p];
    }

    //查看元素p和元素q是否所属于一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    //合并元素q和元素p所属的集合
    @Override
    public void unionElements(int p, int q) {
        //获取元素p,q的集合编号
        int pID = find(p);
        int qID = find(q);

        if(pID == qID)  //集合编号相同 , 不用进行合并
            return;

        //合并集合 , 需要将同一个集合编号的元素查询出来 , 然后修改为同一个集合编号
        for(int i = 0 ; i < id.length ; i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
    }
}
