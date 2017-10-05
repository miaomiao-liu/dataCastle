package cn.edu.swpu.cins.dataCastle.controller;

import cn.edu.swpu.cins.dataCastle.model.view.ScoreRank;
import cn.edu.swpu.cins.dataCastle.service.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by miaomiao on 17-10-5.
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    RankListService rankListService;

    @GetMapping("/list")
    public List<ScoreRank> scoreRank(){
        return rankListService.scoreList();
    }
}
