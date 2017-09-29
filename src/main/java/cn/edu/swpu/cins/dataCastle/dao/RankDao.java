package cn.edu.swpu.cins.dataCastle.dao;

import cn.edu.swpu.cins.dataCastle.model.view.ScoreDate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by miaomiao on 17-9-28.
 */
@Repository
@Mapper
public interface RankDao {

   ScoreDate selectRank(int groupId);

   List<ScoreDate> selectRankList();
}
