package com.example.mycommunity.service;

import com.example.mycommunity.aop.TimeTraceAop;
import com.example.mycommunity.repository.JpaMemberRepository;
import com.example.mycommunity.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

   private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }


//    @Component (Scan 사용을 위해 잠시 주석처리)
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }


//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
