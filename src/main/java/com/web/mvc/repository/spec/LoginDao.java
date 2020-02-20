package com.web.mvc.repository.spec;

import com.web.mvc.entity.Member;

public interface LoginDao {
    int save(Member member); // 註冊 Register 使用
    boolean findUsername(String username); // 是否已有相同的 username
    boolean verifyEmailCode(String username, String code); // Email 驗證
}
