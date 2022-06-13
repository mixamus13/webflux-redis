package com.mixamus.webfluxredis;

import org.junit.Test;
import reactor.test.StepVerifier;

public class LinkServiceTest {

    private final LinkService linkService = new LinkService("http://some-domain.com/");

    @Test
    public void shortensLink() {
        StepVerifier.create(linkService.shortenLink("http://spring.io"))
                .expectNextMatches(result -> result != null && result.length() > 0
                && result.startsWith("http://some-domain.com/"))
                .expectComplete()
                .verify();
    }
}
