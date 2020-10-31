package com.cloud.platform.repository;

import com.cloud.platform.entity.TrafficInfo;
import org.springframework.data.jpa.repository.JpaRepository;

//持久化对象TrafficInfo作为CrudRepository的第一个类型参数，Integer作为JpaRepository的第二个类型参数
public interface TrafficInfoRepository extends JpaRepository<TrafficInfo, Integer> {
}
