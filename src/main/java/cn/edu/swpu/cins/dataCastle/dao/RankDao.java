package cn.edu.swpu.cins.dataCastle.dao;

import cn.edu.swpu.cins.dataCastle.model.view.ScoreDate;
import cn.edu.swpu.cins.dataCastle.model.view.ScoreRank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by miaomiao on 17-9-28.
 */
@Repository
@Mapper
public interface RankDao {

   ScoreDate selectRank(int groupId);

   List<ScoreRank> allRankList();

   int addDate(@Param("groupId") int groupId,@Param("date") Date date);

   int updateDate(@Param("groupId") int groupId,@Param("date") Date date);
}
