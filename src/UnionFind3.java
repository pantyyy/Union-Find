public class UnionFind3 implements UF {

    //parent[i]表示第i个元素所指向的父节点
    private int[] parent;
    //sz[i]表示以i为根的集合中节点的个数
    private int[] sz;

    public UnionFind3(int size){
        parent = new int[size];
        sz = new int[size];

        //初始化节点 , 每个节点指向自己
        for(int i = 0 ; i < parent.length ; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i < sz.length ; i++){
            sz[i] = 1;
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

        //进行节点个数的判断 , 如果pRoot的节点数比较大 , 那么就把qRoot接到pRoot上
        //如果qRoot的节点多 , 就把pRoot接到qRoot上
        if(sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            //更新pRoot的节点个数
            sz[qRoot] += sz[pRoot];
        }else{
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }


    }
}
