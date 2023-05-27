package com.gupt.bigdata.sparkmoviesweb.mapper;

import com.gupt.bigdata.sparkmoviesweb.entity.Personalratings;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonalratingsMapper {

    @Insert("inset into personalratings(userid,movieid,rating,timestamp) values(#{userid},#{movieid},#{rating},#{timestamp})")
    public int insertPersonalratings(Personalratings personalratings);
}
