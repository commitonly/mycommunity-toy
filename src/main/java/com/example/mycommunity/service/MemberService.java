package com.example.mycommunity.service;

import com.example.mycommunity.domain.Member;
import com.example.mycommunity.repository.MemberRepository;
import com.example.mycommunity.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    //    회원가입
    public Long join(Member member){

        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member);
        return member.getId();
    }

}
