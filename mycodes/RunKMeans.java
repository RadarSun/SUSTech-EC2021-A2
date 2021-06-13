package mycodes;

import java.util.ArrayList;
import java.util.Set;

public class RunKMeans {
    private ArrayList<float[]> dataSet;
    private KMeans kRun;
    private Set<Cluster> clusterSet;
    public RunKMeans(int[] freqs){
        dataSet = new ArrayList<float[]>();
        int len = freqs.length;
        for (int i = 0; i<len; i++){
            dataSet.add(new float[] {freqs[i]});
        }
        kRun =new KMeans(2, dataSet);

        clusterSet = kRun.run();
        System.out.println("单次迭代运行次数："+kRun.getIterTimes());
        for (Cluster cluster : clusterSet) {
            System.out.println(cluster);
            System.out.println("Current cluster constain: "+cluster.getNumOfMenbers()+" points");
        }

    }
    public int getPoint(){
        int cnt = 0;
        float[] center1 = new float[1];
        int point1 = 0;
        float[] center2 = new float[1];
        int point2 = 0;
        for (Cluster cluster : clusterSet) {
            if(cnt == 0){
                center1 = cluster.getCenter().getlocalArray();
                point1 = cluster.getNumOfMenbers();
            }
            else {
                center2 = cluster.getCenter().getlocalArray();
                point2 = cluster.getNumOfMenbers();
            }
            cnt++;
        }
        if (center1[0]>center2[0]){
            return point1;
        }
        else {
            return point2;
        }
    }
}
