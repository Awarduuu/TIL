package web.dao;

import java.util.List;

import web.dto.Member;

public interface MemberDAO {
	List<Member> selectAll();
}
