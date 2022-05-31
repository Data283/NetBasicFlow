import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("顶点个数：");
        Scanner scan=new Scanner(System.in);
        int r=scan.nextInt();
        Integer[][] allOfArc=new Integer[r][r];
        scan.nextLine();//用来跳过行列后的回车符
        System.out.println("输入顶点之间弧的容量：");
        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
                allOfArc[i][j]=scan.nextInt();
                System.out.print(allOfArc[i][j]+",");
            }
            System.out.println("");
        }


        Graph graph = new Graph(allOfArc);
        Flow flow = new Flow(allOfArc.length);

        while (true) {
            //初始化 流的各个参数
            flow.initialize();
            graph.setList(new ArrayList<>());
            flow.addVertex(0);
            //获得U 中的弧
            List<Arc> pointList  = judge(graph, flow);

            //情况1,获得最大流
            if (flow.vertex[flow.numOfVertex - 1] == 0) break;

            else {
                //情况2 更新 flow
                List<Arc> list = new ArrayList<>();
                //获取一个顶点序列
                graph.getVertexList(graph.numOfVertex - 1,pointList, list,0);

                List<Arc> list2 = graph.list;

                //根据顶点序列更新flow的值
                for (Arc arc: list2){
                    if (arc.isXToY)
                        flow.valueOfFlow[arc.x][arc.y] += 1;
                    else
                        flow.valueOfFlow[arc.x][arc.y] -= 1;
                }
            }
        }
        flow.output();
    }

    /* 获取U 中的弧
     * */
    private static List<Arc> judge(Graph graph, Flow flow) {

        List<Arc> arcList =  new ArrayList<>();

        int index = 0;
        //x
        while (index  < graph.numOfVertex){

            int index1 = 0;
            //y
            while (index1 < graph.numOfVertex){
                Arc arc = new Arc();
                // x 在 flow, y 不在 flow
                if (flow.vertex[index] == 1 && flow.vertex[index1] == 0 && graph.allOfArc[index][index1] > 0 &&
                        graph.allOfArc[index][index1] > flow.valueOfFlow[index][index1]) {
                    flow.vertex[index1] = 1;
                    arc.setX(index);
                    arc.setY(index1);
                    arc.isXToY =  true;
                    arcList.add(arc);
                    index = 0;
                    break;
                }
                // x 不在flow, y 在flow
                if (flow.vertex[index] == 0 && flow.vertex[index1] == 1 && graph.allOfArc[index][index1] > 0 &&
                        flow.valueOfFlow[index][index1] >  0) {
                    flow.vertex[index] = 1;
                    arc.setX(index);
                    arc.setY(index1);
                    arc.isXToY = false;
                    arcList.add(arc);
                    index = 0;
                    break;
                }
                index1++;
            }
            index++;
        }
        return arcList;
    }
}
