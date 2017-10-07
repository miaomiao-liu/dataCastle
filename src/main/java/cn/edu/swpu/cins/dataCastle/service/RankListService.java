package cn.edu.swpu.cins.dataCastle.service;

import cn.edu.swpu.cins.dataCastle.enums.MatchEnum;
import cn.edu.swpu.cins.dataCastle.model.view.ScoreRank;

import java.util.Date;
import java.util.List;

/**
 * Created by miaomiao on 17-10-5.
 */
public interface RankListService {

    MatchEnum addGroupDate(int groupId, Date date);

    List<ScoreRank> scoreList();
}
