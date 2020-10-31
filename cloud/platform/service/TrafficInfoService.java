package com.cloud.platform.service;

import com.cloud.platform.entity.TrafficInfo;
import com.cloud.platform.repository.TrafficInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TrafficInfoService {

    //注入TrafficInfoRepository
    @Resource
    private TrafficInfoRepository trafficInfoRepository;

    /**
       save、 update、 delete方法需要绑定事务。使用@Transactional进行事务绑定

       保存对象
       @param trafficInfo
       @return 包含自动生成的id的TrafficInfo对象
     */
    @Transactional
    public TrafficInfo save(TrafficInfo trafficInfo) {
        return trafficInfoRepository.save(trafficInfo);
    }

    /**
     * 查询所有数据
     * @return 返回所有TrafficInfo对象
     */
    public Iterable<TrafficInfo> getAll(){
        return trafficInfoRepository.findAll();
    }
    /**
     * 根据id查询数据
     * @return 返回id对应的TrafficInfo对象
     */
    public TrafficInfo getById(Integer id) {
        //根据id查询对应的持久化对象
        Optional<TrafficInfo> op = trafficInfoRepository.findById(id);
        return op.get();
    }
    @Transactional
    public void update(TrafficInfo trafficInfo) {
        //直接调用持久化对象的set方法修改对象数据
    }
}
