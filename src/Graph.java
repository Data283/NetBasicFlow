import java.util.ArrayList;
import java.util.List;

public class Graph {
    /*
    * 用二位数组表示网络 arc[i][j]表示 i 到 j 的容量
    * 第一行表示 s
    * 最后一行表示 t
    * */
    Integer numOfVertex;
    Integer[][] allOfArc;
    List<Arc> list = new ArrayList<>();


    public List<Arc> getList() {
        return list;
    }

    public void setList(List<Arc> list) {
        this.list = list;
    }

    public  Graph(Integer[][] value){
        this.numOfVertex = value.length;
        this.allOfArc = value;
    }


    public Integer[][] getAllOfArc() {
        return allOfArc;
    }

    public void setAllOfArc(Integer[][] allOfArc) {
        this.allOfArc = allOfArc;
    }

    public void getVertexList(int numOfVertex, List<Arc> pointList, List<Arc> resList, int current) {

        if (resList.size() >= 1 && resList.get(resList.size() -1).y == numOfVertex){

            for (Arc arc : resList)
                this.list.add(arc);
            return;
        }
        for (Arc arc: pointList){
            if (arc.x == current){
                resList.add(arc);
                getVertexList(numOfVertex, pointList.subList(1, pointList.size()), resList, arc.y);
                resList.remove(arc);
            }
        }
        return ;
    }

}
