package com.example.demo;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import com.example.demo.order.Order;
import com.example.demo.order.OrderService;
import com.example.demo.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(memberRepository);
        OrderService orderService = new OrderServiceImpl(memberRepository);

        Long memberID = 1L;
        Member member = new Member(memberID,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberID,"itemA",10000);
        System.out.println("order = " + order);
    }
}
