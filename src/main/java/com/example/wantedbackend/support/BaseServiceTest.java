package com.example.wantedbackend.support;

import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseServiceTest {
}
