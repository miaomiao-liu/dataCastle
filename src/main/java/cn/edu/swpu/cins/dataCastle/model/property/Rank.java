package cn.edu.swpu.cins.dataCastle.model.property;

import java.sql.Date;

/**
 * Created by miaomiao on 17-9-28.
 */
public class Rank {

    private int id;
    private int groupId;
    private int score;
    private Date lastDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}
