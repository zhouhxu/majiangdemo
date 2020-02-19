package cn.edu.hxu.majiangdemo.mapper;

import cn.edu.hxu.majiangdemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("Insert into user (account_id,name,token,gmt_create,gmt_updated) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtUpdate})")
    int save(User user);


}
