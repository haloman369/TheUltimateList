package com.theultimatelist.services;


import com.api.igdb.apicalypse.APICalypse;
import com.api.igdb.exceptions.RequestException;
import com.api.igdb.request.IGDBWrapper;
import com.api.igdb.request.ProtoRequestKt;
import com.api.igdb.request.TwitchAuthenticator;
import com.api.igdb.utils.TwitchToken;
import org.junit.jupiter.api.Test;
import proto.Search;

import java.util.List;

class TestJavaWrapper {


    @Test
    void testGetTwitchToken() {
        // Create the Twitch authenticator instance
        TwitchAuthenticator tAuth = TwitchAuthenticator.INSTANCE;
        // request a new Twitch Authentication token
        String clientID = System.getenv("client_id");
        String clientSecret = System.getenv("client_secret");

        TwitchToken token = tAuth.requestTwitchToken(System.getenv("client_id"), System.getenv("client_secret"));

        assert(token != null);
        assert(token.getExpires_in() > 5000000);
        Long tokenFutureDate = System.currentTimeMillis() + 5000000; // 57 days
        assert(tokenFutureDate > token.getExpiresUnix());
    }


    @Test
    void testSearch() {

        IGDBWrapper wrapper = IGDBWrapper.INSTANCE;
        wrapper.setCredentials("inwgora7yt27nvnd0ncwep1z059bul", "co52csuqbgpydm3xewy2xdil6lruc8");

        APICalypse query = new APICalypse()
                .search("Halo")
                .fields("name");

        try {
            List<Search> result = ProtoRequestKt.search(wrapper, query);
            assert(!result.isEmpty());
        } catch (RequestException e) {
            assert(false);
        }
    }

}