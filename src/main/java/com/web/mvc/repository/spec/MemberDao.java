package com.web.mvc.repository.spec;

import com.web.mvc.entity.Member;
import java.util.List;

public interface MemberDao {
    List<Member> query();
}
