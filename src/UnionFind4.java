public class UnionFind4 implements UF {

    //parent[i]表示第i个元素所指向的父节点
    private int[] parent;
    //rank[i]表示以i为根的集合中树的高度
    private int[] rank;

    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];

        //初始化节点 , 每个节点指向自己
        for(int i = 0 ; i < parent.length ; i++){
            parent[i] = i;
            rank[i] = 1;
        }

    }


    @Override
    public int getSize() {
        return parent.length;
    }

    //查找元素p所对应的根节点
    private int find(int p){
        //p合法性判断
        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        while(parent[p] != p){
            p = parent[p];
        }

        return parent[p];
    }


    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        //找到p和q的根节点
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){ //根节点相同 , 不用进行合并
            return;
        }

        //根节点不同 , 需要进行合并
        //把p根节点中指向的元素修改为指向q元素的根节点即可

        //进行高度的判断 , 把高度低的树接到高度高的树上
        if(rank[pRoot] < rank[qRoot]){
            //拼接之后 , 比较高的树的高度并没有变化
            parent[pRoot] = qRoot;
        }else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else{
            //两颗树的高度一样 , 随意接一棵树即可
            parent[pRoot] = qRoot;
            //因为树的高度一样 , 所以高度会发生变化
            rank[qRoot] += 1;
        }


    }
}
