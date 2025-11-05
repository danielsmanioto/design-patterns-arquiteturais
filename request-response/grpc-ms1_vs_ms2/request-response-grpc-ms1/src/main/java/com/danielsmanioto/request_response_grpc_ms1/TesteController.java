package com.danielsmanioto.request_response_grpc_ms1;

@RestController
public class TesteController {

    private final EchoClientService echoClientService;

    public TesteController(EchoClientService echoClientService) {
        this.echoClientService = echoClientService;
    }

    @GetMapping("/testar")
    public String testar() {
        echoClientService.chamaOutroServico();
        return "Chamada enviada!";
    }
}