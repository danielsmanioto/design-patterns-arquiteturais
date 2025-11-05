package com.danielsmanioto.request_response_grpc_ms1;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class EchoClientService {

    @GrpcClient("echo-service")
    private EchoServiceGrpc.EchoServiceBlockingStub echoStub;

    public void chamaOutroServico() {
        EchoRequest req = EchoRequest.newBuilder().setMessage("Olá do MS1!").build();
        EchoResponse resp = echoStub.echo(req);
        System.out.println("Resposta do MS2: " + resp.getReply());
    }
}