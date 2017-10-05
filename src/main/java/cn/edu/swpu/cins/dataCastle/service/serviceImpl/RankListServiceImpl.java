package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.dao.GroupDao;
import cn.edu.swpu.cins.dataCastle.dao.RankDao;
import cn.edu.swpu.cins.dataCastle.model.view.ScoreRank;
import cn.edu.swpu.cins.dataCastle.service.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by miaomiao on 17-10-5.
 */
@Service
public class RankListServiceImpl implements RankListService {

    @Autowired
    RankDao rankDao;
    @Autowired
    GroupDao groupDao;

    @Override
    public List<ScoreRank> scoreList() {
        List<ScoreRank> scoreRankList = rankDao.allRankList();
        for (ScoreRank scoreRank : scoreRankList){
            scoreRank.setGroupName(groupDao.selectGroup(scoreRank.getGroupId()));
        }
        scoreRankList = Ranking(scoreRankList);
        return scoreRankList;
    }

    //排序
    public List<ScoreRank> Ranking(List<ScoreRank> scoreRankList){
        int n = scoreRankList.size();
        for(int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - 1 - i; j++){
                if(scoreRankList.get(j).getScore() > scoreRankList.get(j).getScore()){
                    swap(scoreRankList,j,j + 1);
                }
            }
        }
        return scoreRankList;
    }

    //交换
    public void swap(List<ScoreRank> scoreRankList,int i,int j){
        ScoreRank scoreRank = scoreRankList.get(i);
        scoreRankList.set(i,scoreRankList.get(j));
        scoreRankList.set(j,scoreRank);
    }

    //设置排名
    public void rank(List<ScoreRank> scoreRankList) {
        int n = scoreRankList.size();
        for (int i = 0; i < n; i++) {
            scoreRankList.get(i).setId(i++);
        }
    }

}