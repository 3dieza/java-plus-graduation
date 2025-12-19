//package ru.practicum.ewm.config;
//
//import net.devh.boot.grpc.client.inject.GrpcClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import ru.practicum.grpc.ewm.dashboard.analyzer.RecommendationsControllerGrpc;
//import ru.practicum.grpc.ewm.stats.collector.UserActionControllerGrpc;
//import ru.practicum.statsclient.AnalyzerClient;
//import ru.practicum.statsclient.CollectorClient;
//
//@Configuration
//public class GrpcClientsConfig {
//
//    @Bean
//    public AnalyzerClient analyzerClient(@GrpcClient("analyzer") RecommendationsControllerGrpc.RecommendationsControllerBlockingStub stub) {
//        return new AnalyzerClient(stub);
//    }
//
//    @Bean
//    public CollectorClient collectorClient(@GrpcClient("collector") UserActionControllerGrpc.UserActionControllerBlockingStub stub) {
//        return new CollectorClient(stub);
//    }
//}