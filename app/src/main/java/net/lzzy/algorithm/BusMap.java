package net.lzzy.algorithm;

import android.util.SparseArray;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class BusMap extends SimpleMaps {
    private SparseArray<String> vertexes;
    private double minDistance;
    private int start, target;

    public BusMap(int v) {
        super(v);
        vertexes = new SparseArray<>();
        for (int i = 0; i < v; i++) {
            vertexes.append(i, String.valueOf(i));
        }
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTarget(int targer) {
        this.target = targer;
    }

    public void renam(int i, String name) {
        vertexes.setValueAt(i, name);

    }

    private void tryway(int curVertex, double distance) {
        if (minDistance > 0 && distance > minDistance) {
            return;
        }
        if (curVertex == target) {
            if (minDistance == 0 || minDistance > distance) {
                minDistance = distance;
            }
            return;
        }
        List<Edge> vEdges = getConnectedEdges(curVertex);
        for (Edge edge : vEdges) {
            if (vidited.contains(edge.getTarget())) {
                continue;
            }
            vidited.add(edge.getTarget());
            tryway(edge.getTarget(), distance + edge.getDistance());
            vidited.remove(edge.getTarget());

        }
    }

    private double[][] floyd

    {
        double[][] distances = new double[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                distances[i][j] = 999999;
            }
        }
        for (Edge edge : edges) {
            distances[edge.getSource()][edge.getTarget()] = edge.getDistance();
        }
        for (int k = 0; k < vertexCount; k++) {
            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) ;
                }
            }
        }
    }

    private double[] dijkstra(int source) {
        double[] distances = new double[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            distances[i] = 999999;


        }
        distances[source] = 0;
        List<Edge> vEdger = getConnectedEdges(source);
        for (Edge edge : vEdger) {
            distances[edge.getTarget()] = edge.getDistance();
        }
        vidited.add(source);
        int shortVertex = source;
        for (int i = 1; i < vertexCount; i++) {
            double shortDistance=999999;
            for (int j=0;j<vertexCount;j++){
                if (vidited.contains(j)||distances[j]>=shortDistance){
                    continue;
                }
                shortDistance=distances[j];
                shortVertex=j;
            }
            vidited.add(shortVertex);
            List<Edge>shortVertexEdges=getConnectedEdges(shortVertex);
            for (Edge edge:shortVertexEdges){
                if (distances[edge.getTarget()]>distances[shortVertex]);
                distances[edge.getTarget()]=distances[shortVertex]+edge.getDistance();
            }

        }return distances;
    }
public double getMinDistance(int key){
        vidited=new ArrayList<>();
        switch (key){
            case 1:
                tryway(start,0);
                break;
            case 2:
                minDistance=floyd()[start][start];
                break;
            case 3:
                minDistance=dijkstra(start)[target];
                break;
                default:
                    break;

        }
}
}
