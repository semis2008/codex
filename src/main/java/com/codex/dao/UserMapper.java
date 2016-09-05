package com.codex.dao;

import java.util.List;

import com.codex.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {


//	public List<CeqDayPushCount> getDayPushCountByDate(
//			@Param("summaryType") int summaryType,
//			@Param("startTime") String startTime,
//			@Param("endTime") String endTime);



	 User queryUserByName(String name);

	Integer insertUser(User user);

}