package com.theultimatelist.services;

import com.api.igdb.apicalypse.APICalypse;
import com.api.igdb.exceptions.RequestException;
import com.api.igdb.request.IGDBWrapper;
import com.api.igdb.request.ProtoRequestKt;
import com.api.igdb.request.TwitchAuthenticator;
import com.api.igdb.utils.TwitchToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import proto.Search;
import com.google.protobuf.GeneratedMessageV3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TwitchService {

    private Logger logger = LoggerFactory.getLogger(TwitchService.class);

    private RestTemplate restTemplate;



    @Autowired
    public TwitchService(RestTemplateBuilder builder){

        restTemplate = builder.build();
    }

    public void getTwitchToken(){

        TwitchAuthenticator tAuth = TwitchAuthenticator.INSTANCE;

        TwitchToken token = tAuth.requestTwitchToken("inwgora7yt27nvnd0ncwep1z059bul", "rarmt4ig6jwqi2za4dgdtkotqtyobl");

    }


    public List<String> getGames(String name) {

        IGDBWrapper wrapper = IGDBWrapper.INSTANCE;
        wrapper.setCredentials("inwgora7yt27nvnd0ncwep1z059bul", "co52csuqbgpydm3xewy2xdil6lruc8");
       List<String> gameList = new ArrayList<String>();



        APICalypse query = new APICalypse()
                .search(name)
                .fields("name");

        try {
            List<Search> result = ProtoRequestKt.search(wrapper, query);
            if (!result.isEmpty()){
                for(int i=0; i<result.size(); i++){

                    logger.info("Game: " + result.get(i));

                    logger.info("game={}", result.get(i));

                    gameList.add(result.get(i).getName());
                }


            }
        } catch (RequestException e) {

            logger.error("This is an error message={}", e.getMessage(),e);


        }

    return gameList;
    }


}
