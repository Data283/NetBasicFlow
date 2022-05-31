import java.security.PublicKey;
import java.util.Set;

public class Flow {

    int numOfVertex;
    int[][] valueOfFlow;
    int[]  vertex;

    /*
    * 初始化一个空流
    * */
    public Flow(){
    }
    public  Flow(int n ){
        this.numOfVertex = n;
        this.valueOfFlow =  new int[numOfVertex][numOfVertex];
        this.vertex=  new int[n];
    }


    //加顶点
    public void addVertex(int m){
        this.vertex[m] = 1;
    }

    //情况1，(j, j+1 )是一条弧
    public void addValue(int i, int j){
        this.valueOfFlow[i][j] += 1;
    }

    public void subtractValue(int i, int j){
        this.valueOfFlow[i][j] -= 1;
    }

    public void initialize(){
        this.vertex =  new int[this.numOfVertex];
    }
    public void output(){
        System.out.println("最大流如下表：");

        for (int i = 0; i < this.numOfVertex; i++){
            for (int j =0; j < this.numOfVertex; j++){
                System.out.print(this.valueOfFlow[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
