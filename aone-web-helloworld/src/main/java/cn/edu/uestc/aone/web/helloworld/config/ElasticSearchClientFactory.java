package cn.edu.uestc.aone.web.helloworld.config;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress; //用于6.0版本以前
import org.elasticsearch.common.transport.TransportAddress;	//用于 6.0版本以后
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * ElasticSearch配置，可实例化一个客户端
 * Created by Carter Peng 2018/10/14
 **/
@Configuration
public class ElasticSearchClientFactory {

    // 一次ping的等待时间
    @Value("#{configure['es.transport.ping_timeout']}")
    private String transportPingTimeout;

    // es集群节点地址字符串，用","分隔两个节点
    @Value("#{configure['es.search.clusterList']}")
    private String clusterListStr;

    private static Client client = null;

    /**
     * 获取一个ES客户端，与ES服务器交互，单例模式实现
     * @return Client
     */
    public Client getInstance() {
        if (client == null) {
            synchronized (ElasticSearchClientFactory.class){
                if (client == null) {
                    open();
                }
            }
        }

        return client;
    }

    /**
     * 根据配置打开一个ES客户端
     */
    private void open() {
        try {
            Settings settings = Settings.builder()
                    .put("client.transport.ping_timeout", transportPingTimeout).build();
            PreBuiltTransportClient pc = new PreBuiltTransportClient(settings);
            for ( Pair<String, Integer> p : getNodeCluster()) {
                pc.addTransportAddress(new TransportAddress(InetAddress.getByName(p.getKey()), p.getValue()));
            }

            client = pc;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析节点地址配置字符串，地址与端口
     * @return List<Pair<String, Integer>>
     */
    private List<Pair<String, Integer>> getNodeCluster(){
        List<Pair<String, Integer>> nodeCluster = new ArrayList<>();
        for(String s : clusterListStr.split(",")) {
            String[] ps = s.split(":");
            nodeCluster.add(new Pair<String, Integer>(ps[0], Integer.parseInt(ps[1])));
        }
        return nodeCluster;
    }
}

/**
 * 二元组数据结构
 * @param <T1>
 * @param <T2>
 */
class Pair<T1, T2> {
    private T1 key;
    private T2 value;

    Pair(T1 k, T2 v) {
        this.key = k;
        this.value = v;
    }

    public T1 getKey() {
        return key;
    }

    public void setKey(T1 key) {
        this.key = key;
    }

    public T2 getValue() {
        return value;
    }

    public void setValue(T2 value) {
        this.value = value;
    }
}
