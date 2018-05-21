package com.yihui.demo.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@ElasticSimpleJob(cron="* * * * * ?",jobName="test001",description = "测试DataflowJob" ,shardingTotalCount=2,jobParameter="测试参数",shardingItemParameters="0=A,1=B")
//@Component
public class MyDataflowJob implements DataflowJob<String> {
    @Override
    public List<String> fetchData(ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "DATAFLOW FETCH"));
        //return fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
        List<String> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("xxx"+i);
        }
        return list;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<String> list) {
        for (String str: list) {
            System.out.println(str);
        }
    }
}
