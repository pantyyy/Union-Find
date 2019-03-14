import java.util.Random;

public class Main {

    //测试不同实现的时间复杂度
    //m代表操作的次数
    public static double testUF(UF uf , int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        //进行m次合并操作
        for(int i = 0 ; i < m ; i++){
            //生成两个随机数进行合并 , 范围为[0 , size);
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a , b);
        }

        //进行m次判断是否连接
        for(int i = 0 ; i < m ; i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a , b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }



    public static void main(String[] args){
        int size = 10000000;
        int m = 10000000;

//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1 : " + testUF(uf1 , m) + "s");
//
//
//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2 : " + testUF(uf2 , m) + "s");

        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3 : " + testUF(uf3 , m) + "s");

        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");

        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5 : " + testUF(uf5, m) + " s");

        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("UnionFind6 : " + testUF(uf6, m) + " s");
    }
}
