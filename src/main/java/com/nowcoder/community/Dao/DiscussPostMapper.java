package com.nowcoder.community.Dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param用于参数取别名，如果方法只有一个参数，并且是动态参数（在<if>里使用必须加别名）
    int selectDiscussPostRows(@Param("userId") int userId);

}
