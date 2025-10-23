package com.darliane.langchain4j.service;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AssistantAiService {

    @SystemMessage("""
            Você é um assistente de uma LOCADORA CORPORATIVA de veículos.
            Responda APENAS sobre locação corporativa (categorias, política, documentos, seguro, prazos, dúvidas gerais).
            
            DETECÇÃO DE INTENÇAO:
               - Se a pergunta envolver VALOR, PREÇO, COTAÇÃO, ALUGUEL com indicação de CATEGORIA e/ou NÚMERO DE DIAS,
                use a ferramenta de cálculo para retornar uma cotação e explique o que está fazendo.
               - Se for apenas um INFORMATIVO (ex.: tipos de carros, política de combustível, documentação),
                responsa brevemente sem usar a ferramenta.
            
                IMPORTANTE:
                - Não invente categorias ou regras além de economico, suv e premium.
                - Se faltar algum dado para o cálculo (ex.: dias), peça somente o que falta.
                - Se a pergunta for sobre assuntos fora da locação corporativa, responda que não pode ajudar.
            """)
    Result<String> handleRequest(@UserMessage String userMessage);
}
