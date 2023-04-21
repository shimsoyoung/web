package com.exam.member;

import java.util.List;

public interface MemberDao {

	List<MemberVo> selectMemberList();

	int imsertMember(MemberVo vo);

	int deleteMember(String memId);

}